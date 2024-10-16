package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import models.AuthResponse
import models.ResponseModel
import models.SignUp
import repos.AuthRepositoryImpl

class AuthViewModel : ViewModel() {
    private var _data = MutableStateFlow<ResponseModel<AuthResponse>>(
        ResponseModel.Ready
    )
    val data: StateFlow<ResponseModel<AuthResponse>> = _data
    private val repository = AuthRepositoryImpl()

    fun loginUser(email: String, password: String) {
        _data.value = ResponseModel.Loading
        viewModelScope.launch {
            val response = repository.loginUser(email, password)
            _data.value = response
        }


    }

    fun signUpUser(user: SignUp) {
        _data.value = ResponseModel.Loading
        viewModelScope.launch {
            val response = repository.signUpUser(user)
            _data.value = response
        }


    }


}