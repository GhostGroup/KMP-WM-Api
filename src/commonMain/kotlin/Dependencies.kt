import io.ktor.client.*
import kotlinx.serialization.json.Json

object Dependencies {
    var json:Json = Json {ignoreUnknownKeys = true}
    var httpClient:HttpClient = HttpClient()

}