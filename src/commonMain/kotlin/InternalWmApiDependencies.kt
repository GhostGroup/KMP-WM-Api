import io.ktor.client.*
import kotlinx.serialization.json.Json

internal object InternalWmApiDependencies {
    var json:Json = Json {
        ignoreUnknownKeys = true
        isLenient = true}
    var httpClient:HttpClient = HttpClient()
}

expect val client:HttpClient

object WmApiDependencies {
    var prodUrl = "https://api-g.weedmaps.com"
    var baseUrl:String = prodUrl
    var acceptanceUrl = "https://api-g-acceptance.internal-weedmaps.com"
}