package repos

import com.russhwolf.settings.Settings
import datasource.LoginDataSource
import models.AuthResponse
import models.ResponseModel
import models.SignUp

class AuthRepositoryImpl : AuthRepository {
    private val dataSource = LoginDataSource()
    private val settings = Settings()
    override suspend fun loginUser(email: String, password: String): ResponseModel<AuthResponse> {
        return dataSource.loginUser(email, password)
    }

    override suspend fun refreshToken(token: String): ResponseModel<AuthResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun signUpUser(user: SignUp): ResponseModel<AuthResponse> {
        if (user.password != user.retryPassword)
            return ResponseModel.Error("Passwords do not match", 0)
        return dataSource.signUpUser(user)
    }
}