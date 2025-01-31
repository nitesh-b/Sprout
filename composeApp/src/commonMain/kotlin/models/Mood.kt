package models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data class Mood(
    val id: String,
    val type: MoodType,
    val title: String,
    val imageUrl: String? = null,
    @Contextual
    val localImage: DrawableResource? = null,
)

enum class MoodType {
    NEUTRAL,
    HAPPY,
    SAD,
    ANGRY,
    SURPRISED,
    COOL
}