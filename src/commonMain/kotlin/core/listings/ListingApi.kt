package core.listings

import WmResult
import io.ktor.client.request.*
import io.ktor.client.statement.*
import toWmResult

class ListingApi(){
    private val baseListingUrl = "${InternalWmApiDependencies.baseUrl}/discovery/v1/listings"
    suspend fun getListings():WmResult<ListingResponse>{
        return InternalWmApiDependencies.httpClient.get<HttpResponse>(baseListingUrl).toWmResult(InternalWmApiDependencies.json)
    }
}