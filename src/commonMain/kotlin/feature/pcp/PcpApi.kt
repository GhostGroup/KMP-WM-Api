package feature.pcp

class PcpApi {
    val testProduct = Product("imageurl", "Dans Drug Empo", "Dans Dank", Rating(5f, 200), PriceRange(20.0, 35.0, "USD"))
    val testListing =
        Listing("Dans Drug Empo", Rating(5f, 200), "Arlington VA", true, true, Location(38.847510, -77.131930))

    suspend fun getPcpCategory(location: Location): PcpModel {
        return PcpModel(
            arrayOf(
                PcpCategory(
                    Category(
                        id = "id1",
                        title = "Category 1",
                        facetType = "category",
                        uuid = "uuid1"
                    ), null
                )
            )
        )
    }

    suspend fun getPcpSubcategory(category: Category): Array<PcpSubCategory> {
        return arrayOf(
            PcpSubCategory(
                Category(id = "sub1", title = "Subcategory 1", facetType = "category", uuid = "subuuid1"),
                description = "This is the content that comes from somewhere",
                learnExcept = "learn link excerpt",
                learnImage = "imageurl",
                topRatedProduct = testProduct,
                popularProducts = arrayOf(testProduct, testProduct, testProduct),
                nearbyListings = arrayOf(testListing, testListing, testListing)
            ),
            PcpSubCategory(
                Category(id = "sub2", title = "Subcategory 2", facetType = "category", uuid = "subuuid2"),
                description = "This is the content that comes from somewhere",
                learnExcept = "learn link excerpt",
                learnImage = "imageurl",
                topRatedProduct = testProduct,
                popularProducts = arrayOf(testProduct, testProduct, testProduct),
                nearbyListings = arrayOf(testListing, testListing, testListing)
            )
        )
    }
}