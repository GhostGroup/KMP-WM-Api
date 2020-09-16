package core.listings

import WmError
import WmResult
import io.ktor.client.request.*
import io.ktor.client.statement.*
import toWmResult

class ListingApi(){
    private val baseListingUrl = "https://api-g-acceptance.internal-weedmaps.com/discovery/v1/listings"
    suspend fun getListings():WmResult<ListingResponse>{
        return WmApiDependencies.httpClient.get<HttpResponse>(baseListingUrl).toWmResult(WmApiDependencies.json)
    }
}