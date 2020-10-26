package feature.pcp

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
    val category: Category,
    val description: String,
    val learnExcept: String?,
    val learnImage: String?,
    val topRatedProduct: Product?,
    val popularProducts: Array<Product>?,
    val nearbyListings: Array<Listing>?
)


@Serializable
data class Product(
    val productImage: String,
    val listingName: String,
    val productName: String,
    val rating: Rating,
    val priceRange: PriceRange
)

@Serializable
data class Rating(
    val stars: Float,
    val ratings: Int
)

@Serializable
data class PriceRange(
    val minPrice: Double,
    val maxPrice: Double,
    val currency: String
)

@Serializable
data class Listing(
    val name: String,
    val rating: Rating,
    val desc: String,
    val isOpen: Boolean,
    val hasOnlineOrdering: Boolean,
    val location: Location
)

@Serializable
data class Location(
    val latitude: Double,
    val longitude: Double
){
    fun toLatLngQueryFormat() = "$latitude,$longitude"
}