package datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import models.HomeModel
import models.ResponseModel
import networkService.NetworkService

class HomeDataSource(private val networkService: NetworkService = NetworkService()) {
    private val dataSource = DataSource()
    suspend fun getHomeData(): ResponseModel<HomeModel> {
//        return withContext(Dispatchers.IO) {
//            val response = networkService.get<HomeModel>(
//                endPoint = "/home",
//            )
//            return@withContext response
//        }
        return withContext(Dispatchers.IO) {
            val activitiesList = dataSource.generateActivitiesList()
            val moodList = dataSource.generateMoodList()
            val homeModel = HomeModel(activitiesList, moodList)
            val response = ResponseModel.Success(homeModel)
            return@withContext response
        }


    }
}