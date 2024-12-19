package models

data class InterestItem(
    val id: Int,
    val value: String,
    var isChecked: Boolean = false,
)
