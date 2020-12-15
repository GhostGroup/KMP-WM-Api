package feature.pcp

import core.listings.Listing
import feature.product.Product
import kotlinx.serialization.Serializable

@Serializable
data class PcpModel(
    val pcpCategory: Array<PcpCategory>
)

@Serializable
data class PcpCategory(
    val category: Category,
    val subCategories: Array<PcpSubCategory>?
)


@Serializable
data class PcpSubCategory(
    val category: Category? = null,
    val learnExcept: String? = null,
    val learnImage: String? = null,
    val topRatedProduct: Product? = null,
    val popularProducts: Array<Product>? = arrayOf(),
    val nearbyListings: Array<Listing>? = arrayOf()
)


@Serializable
data class Rating(
    val stars: Float? = 0f,
    val ratings: Int? = 0
)

@Serializable
data class PriceRange(
    val minPrice: Double? = null,
    val maxPrice: Double? = null,
    val currency: String? = null
)

@Serializable
data class Location(
    val latitude: Double? = 0.0,
    val longitude: Double? = 0.0
){
    fun toLatLngQueryFormat() = "$latitude,$longitude"
}