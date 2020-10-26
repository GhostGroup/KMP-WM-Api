import core.listings.ListingApi
import feature.pcp.Location
import feature.pcp.PcpApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {
    @Test
    fun test() {
        runBlocking {
            val listingResponse = PcpApi().getPcpCategory(Location(33.6846, -117.8265))
            assertEquals(listingResponse, "test")
        }
    }
}