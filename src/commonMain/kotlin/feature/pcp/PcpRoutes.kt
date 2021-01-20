package feature.pcp

private val categoriesApiUrl = "${WmApiDependencies.baseUrl}/discovery/v1/categories?include[]=subcategories"

fun getCategoriesApiUrl(latlng:String):String = "${categoriesApiUrl}&latlng=${latlng}&filter[exclude_slugs][]=pre-roll"
fun getSubcategoriesRoute(uuid:String, location: Location) = "${WmApiDependencies.baseUrl}/discovery/v1/categories/$uuid/subcategories?include%5B%5D=parent&latlng=${location.toLatLngQueryFormat()}&sort_by=total_products_count"


