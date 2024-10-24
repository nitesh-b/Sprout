package datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import models.HomeModel
import models.ResponseModel
import networkService.NetworkService

class HomeDataSource(private val networkService: NetworkService = NetworkService()) {
    suspend fun getHomeData(): ResponseModel<HomeModel> {
        return withContext(Dispatchers.IO) {
            val response = networkService.get<HomeModel>(
                endPoint = "/home",
            )
            return@withContext response
        }


    }
}