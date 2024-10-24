package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.HomeDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import models.HomeModel
import models.ResponseModel

class HomeViewModel : ViewModel() {
    private val _data = MutableStateFlow<ResponseModel<HomeModel>>(ResponseModel.Ready)
    val data: StateFlow<ResponseModel<HomeModel>> = _data

    private val dataSource = HomeDataSource()

    fun getHomeData() {
        viewModelScope.launch {
            val homeModel = dataSource.getHomeData()
            _data.value = homeModel
        }
    }
}