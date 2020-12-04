package feature.product

import core.listings.Listing
import core.listings.OnlineOrdering
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponse(
    val data: ProductsWrapper
)

@Serializable
class ProductsWrapper(
    val products: Array<Product>
)

@Serializable
data class Product(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val variant_slug: String? = null,
    val brand: Brand? = null,
    val is_badged: Boolean? = null,
    val avatar_image_url: String? = null,
    val edge_category: EdgeCategory? = null,
    val reviews_count: Int? = null,
    val rating: Float? = null,
    val favorites_count: Int? = null,
    val price_stats: PriceStats? = null,
    val online_ordering: OnlineOrdering? = null,
    val variant: Variant? = null
)

@Serializable
class Variant(
    val slug: String? = null,
    val price: Price? = null,
    val listing: Listing? = null,
    val menu_item_id:String? = null
)

@Serializable
data class Price(
    val unit: String? = null,
    val quantity: String? = null,
    val price: Double? = null,
    val label: String? = null,
    val on_sale: Boolean? = null,
    val original_price: Double? = null
)

@Serializable
class PriceStats(
    val min: Double? = null,
    val max: Double? = null
)

@Serializable
data class EdgeCategory(
    val uuid: String? = null,
    val name: String? = null,
    val slug: String? = null
)

@Serializable
data class Brand(
    val avatar_image_url: String? = null,
    val name: String? = null,
    val id: Int? = null,
    val slug: String? = null
)