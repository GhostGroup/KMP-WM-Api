import io.ktor.client.*
import kotlinx.serialization.json.Json

internal object WmApiDependencies {
    var json:Json = Json {
        ignoreUnknownKeys = true
        isLenient = true}
    var httpClient:HttpClient = HttpClient()

}