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
    val id: Int?,
    val name: String?,
    val slug: String?,
    val facet_type: String?,
    val uuid: String?,
    val subcategories: Array<SubcategoryApiResponse>?,
    val image_url: String?,
    val total_products_count: Int
)
@Serializable
data class SubcategoryApiResponse(
    val id: Int?,
    val name: String?,
    val slug: String?,
    val facet_type: String?,
    val uuid: String?,
    val image_url: String?,
    val total_products_count: Int
)