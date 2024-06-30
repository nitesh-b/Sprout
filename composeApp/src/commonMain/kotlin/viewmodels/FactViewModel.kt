package viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import datasource.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import models.Fact

class FactViewModel : ViewModel() {
    private val _data = MutableStateFlow<Fact>(Fact())
    val data: StateFlow<Fact> = _data

    private val dataSource: DataSource = DataSource()

    fun getFact(){
        viewModelScope.launch {
            val fact = dataSource.getFact()
            _data.value  = fact
        }


    }
}