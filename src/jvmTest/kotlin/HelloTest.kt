import core.listings.ListingApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {
    @Test
    fun test() {
        runBlocking {
            val listingResponse = ListingApi().getListings()
            val response = listingResponse.getDataOrNull()
            assertEquals(listingResponse, "test")
        }
    }
}