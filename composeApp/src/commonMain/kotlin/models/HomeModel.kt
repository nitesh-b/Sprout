package models

import kotlinx.serialization.Serializable

@Serializable
data class HomeModel(val fact: Fact, val wod: WordOfDayModel)


@Serializable
data class WordOfDayModel(
    val word: String = "",
    val phonetics: String = "",
    val meaning: String = "",
    val exampleSentence: String = "",
)


