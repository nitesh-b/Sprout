package models

import kotlinx.serialization.Serializable


@Serializable
data class Fact(
    val id: String? = "",
    val imageUrl: String? = "",
    val title: String = "",
    val description: String = ""
)