package models

import kotlinx.serialization.Serializable

@Serializable
data class SignUp(
    val id: String? = null,
    var password: String? = null,
    var retryPassword: String? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var dob: String? = null,
    var mobile: String? = null,
    var sex: String? = null,
)

