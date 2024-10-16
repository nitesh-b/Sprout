package models

sealed class ResponseModel<out T> {
    data class Success<out R>(val data: R?) : ResponseModel<R>()
    data class Error(val message: String, val errorCode: Int) : ResponseModel<Nothing>()
    data object Loading : ResponseModel<Nothing>()
    data object Ready : ResponseModel<Nothing>()

}