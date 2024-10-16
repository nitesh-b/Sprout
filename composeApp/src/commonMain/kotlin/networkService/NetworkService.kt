package networkService

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.parameters
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import models.ResponseModel


class NetworkService {
    val client = HttpClient {
        expectSuccess = true
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HTTP Client", message = message)
                }
            }
            level = LogLevel.BODY
        }.also {
            Napier.base(DebugAntilog())
        }
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

    }

    val baseUrl = "10.0.2.2:8080"
    val protocol = URLProtocol.HTTP


    suspend inline fun <reified T> get(
        endPoint: String,
        queryParams: Map<String, String>?,
    ): ResponseModel<T> {
        val response: HttpResponse = client.get {
            url {
                protocol = URLProtocol.HTTP
                host = baseUrl
                path(endPoint)
                parameters {
                    queryParams?.forEach { (key, value) ->
                        append(key, value)
                    }
                }
            }
        }
        if (response.status == HttpStatusCode.OK) {
            val result: T = response.body()
            return ResponseModel.Success(result)
        } else {
            return ResponseModel.Error(response.status.description, response.status.value)
        }
    }


    suspend inline fun <reified T, reified S> post(
        endPoint: String,
        requestBody: T?,
    ): ResponseModel<S> {
        val response: HttpResponse = client.post {
            url {
                protocol = protocol
                host = baseUrl
                path(endPoint)
                setBody(requestBody)
            }
            contentType(ContentType.Application.Json)
        }
        if (response.status == HttpStatusCode.OK) {
            val result: S = response.body()
            return ResponseModel.Success(result)
        } else {
            return ResponseModel.Error(response.status.description, response.status.value)
        }
    }
}