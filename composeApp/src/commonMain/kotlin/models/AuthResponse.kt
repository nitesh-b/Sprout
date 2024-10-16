package models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val email: String? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
)

