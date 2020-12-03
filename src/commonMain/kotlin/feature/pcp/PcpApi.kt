package feature.pcp

import WmResult
import core.listings.ListingApi
import feature.product.ProductsResponse
import feature.product.getTrendingProductsRoute
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import toWmResult

class PcpApi {

    suspend fun getPcpCategory(location: Location): PcpModel {
        val categories:WmResult<ProductCategoriesResponse> = InternalWmApiDependencies.httpClient
            .get<HttpResponse>(getCategoriesApiUrl(location.toLatLngQueryFormat()))
            .toWmResult(InternalWmApiDependencies.json)
        val arrayOfCategories:Array<Category> = categories.getDataOrNull()?.data?.categories ?: arrayOf()
        val pcpModel = PcpModel(arrayOfCategories.map { PcpCategory(it, null) }.toTypedArray())
        return pcpModel
    }

    suspend fun getPcpSubcategory(categoryUuid: String, location:Location): Array<PcpSubCategory> {
        val trendingProductsMap:HashMap<String,Deferred<WmResult<ProductsResponse>>> = HashMap()
        val subcategories:WmResult<ProductCategoriesResponse> = InternalWmApiDependencies.httpClient
            .get<HttpResponse>(getSubcategoriesRoute(categoryUuid, location))
            .toWmResult(InternalWmApiDependencies.json)
        subcategories.getDataOrNull()?.data?.categories?.filter { it.uuid != null }?.take(5) ?.let {
            for (cat in it){
                trendingProductsMap[cat.uuid!!] = CompletableDeferred(InternalWmApiDependencies.httpClient
                    .get<HttpResponse>(getTrendingProductsRoute(location, cat.uuid, 30)).toWmResult(InternalWmApiDependencies.json))
            }
        }

        val nearbyListings = CompletableDeferred(ListingApi().getListings(location))

        return subcategories.getDataOrNull()?.data?.categories
            ?.map {
                val trending = trendingProductsMap[it.uuid!!]?.await()?.getDataOrNull()?.data?.products
                PcpSubCategory(
                category = it,
                learnExcept = null,
                learnImage = null,
                topRatedProduct = trending?.firstOrNull(),
                popularProducts = trending?.filterIndexed { index, product -> index > 0 }?.toTypedArray(),
                nearbyListings = nearbyListings.await().getDataOrNull()?.data?.listings
            ) }
            ?.toTypedArray()
                ?: arrayOf()
    }
}