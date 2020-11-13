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
            val subcategoriesResponse = PcpApi().getPcpSubcategory("f12d28a5-dc36-41d2-98f8-56d6cf2d8225", Location(37.773972,-122.431297))
            assertEquals(subcategoriesResponse.toString(), "test")
            WmApiDependencies.baseUrl = WmApiDependencies.prodUrl
        }
    }
}