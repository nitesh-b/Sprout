package models

import kotlinx.serialization.Serializable

@Serializable
data class DiscoverModel(
    val id: String = "",
    val imageUrl: String = "",
    val title: String = "",
    val dateTS: Long = 0,
    val address: String = "",
)