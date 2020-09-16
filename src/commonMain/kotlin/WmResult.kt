import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

data class WmResult<T> private constructor(private val data: T? = null, private val error: WmError? = null) {
    constructor(data: T) : this(data, null)
    constructor(error: WmError) : this(null, error)

    fun getDataOrNull(): T? = data
    fun isSuccess() = data != null
    fun getErrorOrNull(): WmError? = error

}

data class WmError(val message: String, val responseCode: Int)

suspend inline fun <reified T> HttpResponse.toWmResult(json:Json): WmResult<T> {
    return if (this.status.isSuccess()) {
        return try {
            WmResult(json.decodeFromString<T>(this.readText()))
        } catch (e: Exception) {
            WmResult(WmError(e.message ?: "Error", this.status.value))
        }
    } else {
        WmResult(WmError("Api call failed with $this.", this.status.value))
    }
}