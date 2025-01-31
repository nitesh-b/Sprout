package models

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
data class Action(
    val id: String,
    val title: String,
    val imageUrl: String? = null,
    val tts: String? = null,
    @Contextual
    val localImage: DrawableResource? = null,
    val subItems: List<Action>? = null,
)

