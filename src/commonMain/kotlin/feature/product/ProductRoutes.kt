package feature.product

import feature.pcp.Location

fun getTrendingProductsForTagRoute(location:Location, tagUUID:String?,  boundingRadius:Int = 50):String {

    val tagFilter = if (tagUUID != null)"filter[any_tag_uuids][]=$tagUUID" else null

    val baseUrl = "${WmApiDependencies.baseUrl}/discovery/v1/products/trending?&latlng=${location.toLatLngQueryFormat()}&filter[bounding_radius]=${boundingRadius}mi"

    return  addQueryParam(baseUrl, tagFilter)
}

fun getTrendingProductsForCategoryRoute(location:Location, categoryUuid:String?,  boundingRadius:Int = 50):String {

    val categoryFilter = if (categoryUuid != null) "filter[any_category_uuids][]=$categoryUuid" else null

    val baseUrl = "${WmApiDependencies.baseUrl}/discovery/v1/products/trending?&latlng=${location.toLatLngQueryFormat()}&filter[bounding_radius]=${boundingRadius}mi"

    return addQueryParam(baseUrl, categoryFilter)

}

fun addQueryParam(url:String, queryParam:String?):String {
    if(queryParam == null) return url
    return "${url}&$queryParam"
}