package models

import kotlinx.serialization.Serializable

@Serializable
data class HomeModel(
    val fact: Fact,
    val wod: WordOfDayModel,
    val nationalDay: NationalDayModel,
    val discover: List<DiscoverModel>,
)

@Serializable
data class WordOfDayModel(
    val word: String = "",
    val phonetics: String = "",
    val meaning: String = "",
    val exampleSentence: String = "",
)

@Serializable
data class NationalDayModel(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val dateTS: String = "",
)



