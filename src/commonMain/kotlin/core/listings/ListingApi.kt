package core.listings

import WmResult
import feature.pcp.Category
import feature.pcp.Location
import io.ktor.client.request.*
import io.ktor.client.statement.*
import toWmResult

class ListingApi(){
    suspend fun getListings(location:Location):WmResult<ListingResponse>{
        return InternalWmApiDependencies.httpClient.get<HttpResponse>(getListingForLocationRoute(location))
            .toWmResult(InternalWmApiDependencies.json)
    }

    suspend fun getListingsForTag(location: Location, tagUuid:String, limit:Int):WmResult<ListingResponse>{
        return InternalWmApiDependencies.httpClient.get<HttpResponse>(getListingForTagRoute(location, tagUuid, limit))
            .toWmResult(InternalWmApiDependencies.json)
    }

    suspend fun getListingsForCategory(location: Location, categoryUuid: String, limit:Int):WmResult<ListingResponse>{
        return InternalWmApiDependencies.httpClient.get<HttpResponse>(getListingForCategoryRoute(location, categoryUuid, limit))
            .toWmResult(InternalWmApiDependencies.json)
    }
}