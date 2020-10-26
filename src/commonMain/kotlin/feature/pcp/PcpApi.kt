package feature.pcp

import WmResult
import feature.product.Product
import feature.product.ProductsResponse
import feature.product.getTrendingProductsRoute
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import toWmResult

class PcpApi {

    suspend fun getPcpCategory(location: Location): PcpModel {
        val categories:WmResult<ProductCategoriesResponse> = WmApiDependencies.httpClient
            .get<HttpResponse>(getCategoriesApiUrl(location.toLatLngQueryFormat()))
            .toWmResult(WmApiDependencies.json)
        val arrayOfCategories:Array<Category> = categories.getDataOrNull()?.data?.categories ?: arrayOf()
        val pcpModel = PcpModel(arrayOfCategories.map { PcpCategory(it, null) }.toTypedArray())
        return pcpModel
    }

    suspend fun getPcpSubcategory(categoryUuid: String, location:Location): Array<PcpSubCategory> {
        val subcategories:WmResult<ProductCategoriesResponse> = WmApiDependencies.httpClient
            .get<HttpResponse>(getSubcategoriesRoute(categoryUuid, location))
            .toWmResult(WmApiDependencies.json)
        val productsRequest:Deferred<WmResult<ProductsResponse>> = CompletableDeferred(WmApiDependencies.httpClient
            .get<HttpResponse>(getTrendingProductsRoute(location, categoryUuid, 30)).toWmResult(WmApiDependencies.json))

        val errorProduct = Product(-1, "error", null, null, null, null, null, null, null, null, null, null, null,null)

        val productsResponse = productsRequest.await().getDataOrNull()?.data?.products?.firstOrNull()
        val popularProducts = productsRequest.await().getDataOrNull()?.data?.products?.filterIndexed { index, product -> index > 0 }?.toTypedArray()
        val arrayOfSubcategories:Array<PcpSubCategory> = subcategories.getDataOrNull()?.data?.categories
            ?.map { PcpSubCategory(it, null, null, productsResponse ?: errorProduct, popularProducts, null) }
            ?.toTypedArray()
                ?: arrayOf()

        return arrayOfSubcategories
    }
}