import core.listings.ListingApi
import feature.pcp.Location
import feature.pcp.PcpApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {
    @Test
    fun getProductCategories() {
        runBlocking {
            val listingResponse = PcpApi().getPcpCategory(Location(37.773972,-122.431297))
            assertEquals(listingResponse, "test")
        }
    }

    @Test
    fun getProductSubcategories() {
        runBlocking {
            WmApiDependencies.baseUrl = WmApiDependencies.acceptanceUrl
            val subcategoriesResponse = PcpApi().getPcpCategory(Location(37.773972,-122.431297))
            assertEquals(subcategoriesResponse, "test")
            WmApiDependencies.baseUrl = WmApiDependencies.prodUrl
        }
    }
}