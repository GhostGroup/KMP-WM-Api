import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    @Test
    fun run(){
        runBlocking {
            val hello = HelloWorld()
            assertEquals(hello.getCarouselAds("166"),"fasdfdsfdfasdfsdf sad" )
        }
    }
}