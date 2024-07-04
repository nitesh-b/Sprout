package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import models.Fact
import models.HomeModel
import models.NationalDayModel
import models.WordOfDayModel

class FactViewModel : ViewModel() {
    private val _data = MutableStateFlow<HomeModel>(
        HomeModel(
            fact = Fact("", "", ""),
            wod = WordOfDayModel(),
            nationalDay = NationalDayModel()
        )
    )
    val data: StateFlow<HomeModel> = _data

    private val dataSource: DataSource = DataSource()

    fun getHomeData() {
        viewModelScope.launch {
            val homeModel = dataSource.getHomeData()
            _data.value = homeModel
        }


    }
}