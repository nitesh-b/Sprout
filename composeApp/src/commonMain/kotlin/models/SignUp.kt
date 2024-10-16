package models

data class SignUp(
    val password: String,
    val retryPassword: String,
    override val email: String,
    override val firstName: String,
    override val lastName: String,
) : User()

abstract class User(
    val id: String? = null,
    open val email: String? = null,
    open val firstName: String? = null,
    open val lastName: String? = null,
    val dob: String? = null,
    val mobile: String? = null,
    val sex: String? = null,


    )
