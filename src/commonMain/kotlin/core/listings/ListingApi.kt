package core.listings

import WmError
import WmResult
import io.ktor.client.request.*
import io.ktor.client.statement.*
import toWmResult

class ListingApi(){
    private val baseListingUrl = "${WmApiDependencies.baseUrl}/discovery/v1/listings"
    suspend fun getListings():WmResult<ListingResponse>{
        return WmApiDependencies.httpClient.get<HttpResponse>(baseListingUrl).toWmResult(WmApiDependencies.json)
    }
}