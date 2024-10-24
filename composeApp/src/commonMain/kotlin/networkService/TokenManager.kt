package networkService

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set
import io.github.aakira.napier.Napier
import models.AuthResponse

class TokenManager {
    companion object {
        private val settings = Settings()
        fun setToken(authResponse: AuthResponse) {
            Napier.d(tag = "TokenManager", message = "setToken: ${authResponse.accessToken}")
            settings["accessToken"] = authResponse.accessToken
            settings["refreshToken"] = authResponse.refreshToken
        }

        fun getAccessToken(): String? {
            val accessToken = settings["accessToken", ""]
            Napier.d(tag = "TokenManager", message = "getAccessToken: $accessToken")
            if (accessToken.isEmpty()) return null
            return accessToken
        }
    }
}