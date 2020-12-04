package feature.product

import feature.pcp.Location

fun getTrendingProductsRoute(location:Location, categoryUuid:String, boundingRadius:Int = 50)=
    "${WmApiDependencies.baseUrl}/discovery/v1/products/trending?&latlng=${location.toLatLngQueryFormat()}" +
            "&filter[any_category_uuids][]=$categoryUuid&filter[bounding_radius]=${boundingRadius}mi"