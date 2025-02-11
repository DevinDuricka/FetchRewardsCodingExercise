package one.fable.fetchexercise.repository.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class FetchHiringApi {

    //Also in production, we may want to use custom engines for the client depending on the platform
    //For this proof-of-concept though, this should be sufficient
    private val httpClient = HttpClient {
        //expectSuccess = true //https://ktor.io/docs/client-response-validation.html
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    //In production, we could handle inaccessible connection using the try/catch, but we may want to use custom engines instead
    suspend fun getAllHiringItems(): List<HiringItem> {
        return try {
            httpClient.get("https://fetch-hiring.s3.amazonaws.com/hiring.json").body()
        } catch (e: Exception) {
            emptyList()
        }
    }

}