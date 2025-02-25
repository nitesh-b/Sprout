package datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import models.AuthRequest
import models.AuthResponse
import models.ResponseModel
import models.SignUp
import networkService.NetworkService

class LoginDataSource(private val networkService: NetworkService = NetworkService()) {
    suspend fun loginUser(email: String, password: String): ResponseModel<AuthResponse> {
        return withContext(Dispatchers.IO) {
            val request = AuthRequest(
                email = "john.doe@example.com",
                password = "password123",
            )

            val response = networkService.post<AuthRequest, AuthResponse>(
                endPoint = "auth/login",
                requestBody = request
            )
            return@withContext response
        }

    }

    suspend fun signUpUser(user: SignUp): ResponseModel<AuthResponse> {
        return withContext(Dispatchers.IO) {
            val response = networkService.post<SignUp, AuthResponse>(
                endPoint = "auth/createuser",
                requestBody = user
            )
            return@withContext response
        }
    }
}