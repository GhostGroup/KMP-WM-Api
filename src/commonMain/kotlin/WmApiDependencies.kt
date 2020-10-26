import io.ktor.client.*
import kotlinx.serialization.json.Json

object WmApiDependencies {
    var json:Json = Json {
        ignoreUnknownKeys = true
        isLenient = true}
    var httpClient:HttpClient = HttpClient()
    var baseUrl:String = "https://api-g.weedmaps.com"
    var acceptanceUrl = "https://api-g-acceptance.internal-weedmaps.com"

}