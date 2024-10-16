package repos

import models.AuthResponse
import models.ResponseModel
import models.SignUp

interface AuthRepository {
    suspend fun loginUser(email: String, password: String): ResponseModel<AuthResponse>
    suspend fun refreshToken(token: String): ResponseModel<AuthResponse>
    suspend fun signUpUser(user: SignUp): ResponseModel<AuthResponse>

}