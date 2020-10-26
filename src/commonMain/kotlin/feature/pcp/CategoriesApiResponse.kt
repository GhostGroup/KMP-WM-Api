package feature.pcp

import kotlinx.serialization.Serializable

@Serializable
data class ProductCategoriesResponse(
    val data: CategoryApiBody?
)
@Serializable
data class CategoryApiBody(
    val categories: Array<Category>
)
@Serializable
data class Category(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val facet_type: String? = null,
    val uuid: String? = null,
    val subcategories: Array<SubcategoryApiResponse>? = arrayOf(),
    val image_url: String? = null,
    val total_products_count: Int? = null
)
@Serializable
data class SubcategoryApiResponse(
    val id: Int?  = null,
    val name: String? = null,
    val slug: String? = null,
    val facet_type: String? = null,
    val uuid: String? = null,
    val image_url: String? = null,
    val total_products_count: Int?  = null
)