import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun test(){
        runBlocking {
            val hello = HelloWorld()
            assertEquals(hello.getCarouselAds("166"),"fasdfdsfdfasdfsdf sad" )
        }
    }
}