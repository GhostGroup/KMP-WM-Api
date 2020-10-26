package feature.pcp

import WmResult
import io.ktor.client.request.*
import io.ktor.client.statement.*
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
        val arrayOfSubcategories:Array<PcpSubCategory> = subcategories.getDataOrNull()?.data?.categories
            ?.map { PcpSubCategory(it, null, null, null, null, null) }
            ?.toTypedArray()
                ?: arrayOf()
        return arrayOfSubcategories
    }
//        return arrayOf(
//            PcpSubCategory(
//                Category(id = "sub1", title = "Subcategory 1", facetType = "category", uuid = "subuuid1"),
//                description = "This is the content that comes from somewhere",
//                learnExcept = "learn link excerpt",
//                learnImage = "imageurl",
//                topRatedProduct = testProduct,
//                popularProducts = arrayOf(testProduct, testProduct, testProduct),
//                nearbyListings = arrayOf(testListing, testListing, testListing)
//            ),
//            PcpSubCategory(
//                Category(id = "sub2", title = "Subcategory 2", facetType = "category", uuid = "subuuid2"),
//                description = "This is the content that comes from somewhere",
//                learnExcept = "learn link excerpt",
//                learnImage = "imageurl",
//                topRatedProduct = testProduct,
//                popularProducts = arrayOf(testProduct, testProduct, testProduct),
//                nearbyListings = arrayOf(testListing, testListing, testListing)
//            )
//        )
//    }
}