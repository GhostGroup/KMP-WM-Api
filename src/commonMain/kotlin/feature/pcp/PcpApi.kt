package feature.pcp

import WmResult
import core.listings.ListingApi
import core.listings.ListingResponse
import feature.product.ProductsResponse
import feature.product.getTrendingProductsForCategoryRoute
import feature.product.getTrendingProductsForTagRoute
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import toWmResult

class PcpApi {

    suspend fun getPcpCategory(location: Location): PcpModel {
        val categories: WmResult<ProductCategoriesResponse> = InternalWmApiDependencies.httpClient
            .get<HttpResponse>(getCategoriesApiUrl(location.toLatLngQueryFormat()))
            .toWmResult(InternalWmApiDependencies.json)
        val arrayOfCategories: Array<Category> = categories.getDataOrNull()?.data?.categories ?: arrayOf()
        val pcpModel = PcpModel(arrayOfCategories.map { PcpCategory(it, null) }.toTypedArray())
        return pcpModel
    }

    suspend fun getPcpSubcategory(categoryUuid: String, location: Location): Array<PcpSubCategory> {
        val trendingProductsMap: HashMap<String, Deferred<WmResult<ProductsResponse>>> = HashMap()
        val nearbyListingsMap:HashMap<String, Deferred<WmResult<ListingResponse>>> = HashMap()

        val subcategories: WmResult<ProductCategoriesResponse> = InternalWmApiDependencies.httpClient
            .get<HttpResponse>(getSubcategoriesRoute(categoryUuid, location))
            .toWmResult(InternalWmApiDependencies.json)
        val subcategoriesFirstFive =
            subcategories.getDataOrNull()?.data?.categories?.filter { it.uuid != null }?.take(4)
        subcategoriesFirstFive?.let {
            for (cat in it) {
                if (cat.facet_type == "tag") {
                    trendingProductsMap[cat.uuid!!] = CompletableDeferred(
                        InternalWmApiDependencies.httpClient
                            .get<HttpResponse>(getTrendingProductsForTagRoute(location, cat.uuid, 50))
                            .toWmResult(InternalWmApiDependencies.json)
                    )
                    nearbyListingsMap[cat.uuid] = CompletableDeferred(ListingApi().getListingsForTag(location, cat.uuid, 5))
                } else {
                    trendingProductsMap[cat.uuid!!] = CompletableDeferred(
                        InternalWmApiDependencies.httpClient
                            .get<HttpResponse>(getTrendingProductsForCategoryRoute(location, cat.uuid, 50))
                            .toWmResult(InternalWmApiDependencies.json)
                    )
                    nearbyListingsMap[cat.uuid] = CompletableDeferred(ListingApi().getListingsForCategory(location, cat.uuid, 5))

                }
            }
        }

        return subcategoriesFirstFive
            ?.map {
                val trending = trendingProductsMap[it.uuid!!]?.await()?.getDataOrNull()?.data?.products
                val listings = nearbyListingsMap[it.uuid]?.await()?.getDataOrNull()?.data?.listings
                PcpSubCategory(
                    category = it,
                    learnExcept = null,
                    learnImage = null,
                    topRatedProduct = trending?.firstOrNull(),
                    popularProducts = trending?.filterIndexed { index, product -> index > 0 }?.toTypedArray(),
                    nearbyListings = listings
                )
            }
            ?.toTypedArray()
            ?: arrayOf()
    }
}