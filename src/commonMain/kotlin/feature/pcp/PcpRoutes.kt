package feature.pcp

private val categoriesApiUrl = "${WmApiDependencies.baseUrl}/discovery/v1/categories?include[]=subcategories&filter[location]=any"

fun getCategoriesApiUrl(latlng:String):String = "https://api-g.weedmaps.com/discovery/v1/listings"
fun getSubcategoriesRoute(uuid:String, location: Location) = "${WmApiDependencies.baseUrl}/discovery/v1/categories/$uuid/subcategories?include%5B%5D=parent&latlng=${location.toLatLngQueryFormat()}&sort_by=total_products_count"


