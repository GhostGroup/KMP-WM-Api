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
            .get<HttpResponse>("https://api-g.weedmaps.com/discovery/v1/categories")
            .toWmResult(InternalWmApiDependencies.json)
        val arrayOfCategories:Array<Category> = categories.getDataOrNull()?.data?.categories ?: arrayOf()
        val pcpModel = PcpModel(arrayOfCategories.map { PcpCategory(it, null) }.toTypedArray())
        return pcpModel
    }

    suspend fun getPcpSubcategory(categoryUuid: String, location:Location): Array<PcpSubCategory> {
        val subcategories:WmResult<ProductCategoriesResponse> = InternalWmApiDependencies.httpClient
            .get<HttpResponse>(getSubcategoriesRoute(categoryUuid, location))
            .toWmResult(InternalWmApiDependencies.json)
        val productsRequest:Deferred<WmResult<ProductsResponse>> = CompletableDeferred(InternalWmApiDependencies.httpClient
            .get<HttpResponse>(getTrendingProductsRoute(location, categoryUuid, 30)).toWmResult(InternalWmApiDependencies.json))

        val nearbyListings = CompletableDeferred(ListingApi().getListings())

        val productsResponse = productsRequest.await().getDataOrNull()?.data?.products?.firstOrNull()
        val popularProducts = productsRequest.await().getDataOrNull()?.data?.products?.filterIndexed { index, product -> index > 0 }?.toTypedArray()
        val arrayOfSubcategories:Array<PcpSubCategory> = subcategories.getDataOrNull()?.data?.categories
            ?.map { PcpSubCategory(it, null, null, productsResponse, popularProducts, nearbyListings.await().getDataOrNull()?.data?.listings) }
            ?.toTypedArray()
                ?: arrayOf()

        return arrayOfSubcategories
    }
}