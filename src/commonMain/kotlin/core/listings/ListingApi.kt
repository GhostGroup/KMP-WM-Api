package core.listings

import WmResult
import feature.pcp.Location
import io.ktor.client.request.*
import io.ktor.client.statement.*
import toWmResult

class ListingApi(){
    suspend fun getListings(location:Location):WmResult<ListingResponse>{
        return InternalWmApiDependencies.httpClient.get<HttpResponse>(getListingForLocationRoute(location))
            .toWmResult(InternalWmApiDependencies.json)
    }
}