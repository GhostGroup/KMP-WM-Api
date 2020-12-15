package core.listings

import feature.pcp.Location

private val baseListingUrl = "${WmApiDependencies.baseUrl}/discovery/v2/listings"
fun getListingForLocationRoute(location:Location) = "${baseListingUrl}?latlng=${location.toLatLngQueryFormat()}"

fun getListingForCategoryRoute(location:Location, categoryUuid:String, limit:Int = 5) =
    "${getListingForLocationRoute(location)}&sort_by=category_availability&sort_order=desc&limit=$limit&filter[category_uuids][]=${categoryUuid}"+
            "&filter[bounding_latlng]=${location.toLatLngQueryFormat()}&filter[bounding_radius]=50mi"

fun getListingForTagRoute(location: Location, tagUuid:String, limit: Int = 5) =
    "${getListingForLocationRoute(location)}>&sort_by=tag_availability&sort_order=desc&limit=$limit&filter[tag_uuids][]=$tagUuid" +
            "&filter[bounding_latlng]=${location.toLatLngQueryFormat()}&filter[bounding_radius]=50mi"