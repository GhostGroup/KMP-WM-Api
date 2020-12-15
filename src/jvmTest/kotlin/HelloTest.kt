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
        WmApiDependencies.baseUrl = WmApiDependencies.acceptanceUrl

        runBlocking {
            val concentratesCategory = "4a284200-870b-466a-bd95-db521d2c5e69"
            val subcategoriesResponse = PcpApi().getPcpSubcategory(concentratesCategory, Location(33.68,-117.82))
            assertEquals(subcategoriesResponse.toString(), "test")
            WmApiDependencies.baseUrl = WmApiDependencies.prodUrl
        }
    }
}