package core.listings

import feature.pcp.Location

private val baseListingUrl = "${WmApiDependencies.baseUrl}/discovery/v1/listings"
fun getListingForLocationRoute(location:Location) = "${baseListingUrl}?latlng=${location.toLatLngQueryFormat()}"