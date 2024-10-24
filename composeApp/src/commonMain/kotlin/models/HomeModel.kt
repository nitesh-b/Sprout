package models

import kotlinx.serialization.Serializable

@Serializable
data class HomeModel(
    val fact: Fact,
    val dictionary: WordOfDayModel,
    val nationalDay: NationalDayModel? = null,
    val discover: List<DiscoverModel>? = null,
)

@Serializable
data class WordOfDayModel(
    val word: String = "",
    val pronunciation: String = "",
    val meaning: String = "",
    val example: String = "",
    val id: String,
)

@Serializable
data class NationalDayModel(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val dateTS: String = "",
)



