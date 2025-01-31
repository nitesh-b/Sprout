package datasource

import au.com.redmonk.resources.Res
import au.com.redmonk.resources.climb
import au.com.redmonk.resources.dance
import au.com.redmonk.resources.drink
import au.com.redmonk.resources.excercise
import au.com.redmonk.resources.go_out
import au.com.redmonk.resources.jump
import au.com.redmonk.resources.listen
import au.com.redmonk.resources.paint
import au.com.redmonk.resources.play
import au.com.redmonk.resources.point
import au.com.redmonk.resources.read
import au.com.redmonk.resources.run
import au.com.redmonk.resources.share
import au.com.redmonk.resources.sing
import au.com.redmonk.resources.sort
import au.com.redmonk.resources.touch
import models.Action
import models.Mood
import models.MoodType
import org.jetbrains.compose.resources.DrawableResource
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class DataSource {
    @OptIn(ExperimentalUuidApi::class)
    fun generateActivitiesList(): List<Action> {
        val listItems =
            mapOf<String, DrawableResource>(
                "Play" to Res.drawable.play,
                "Exercise" to Res.drawable.excercise,
                "Climb" to Res.drawable.climb,
                "Dance" to Res.drawable.dance,
                "Drink" to Res.drawable.drink,
                "Read" to Res.drawable.read,
                "Go out" to Res.drawable.go_out,
                "Jump" to Res.drawable.jump,
                "Listen" to Res.drawable.listen,
                "Paint" to Res.drawable.paint,
                "Point" to Res.drawable.point,
                "Run" to Res.drawable.run,
                "Share" to Res.drawable.share,
                "Sing" to Res.drawable.sing,
                "Sort" to Res.drawable.sort,
                "Touch" to Res.drawable.touch,
            )

        val relatedNouns = mapOf(
            "Play" to listOf("Game", "Toy", "Instrument", "Sports", "Cards"),
            "Exercise" to listOf("Workout", "Routine", "Gym", "Fitness", "Yoga"),
            "Climb" to listOf("Mountain", "Ladder", "Tree", "Wall", "Rocks"),
            "Dance" to listOf("Ballet", "Hip-hop", "Salsa", "Jazz", "Contemporary"),
            "Drink" to listOf("Water", "Juice", "Coffee", "Tea", "Smoothie"),
            "Read" to listOf("Book", "Article", "Magazine", "Novel", "Comic"),
            "Go out" to listOf("Park", "Mall", "Beach", "Restaurant", "Cinema"),
            "Jump" to listOf("Rope", "Trampoline", "Puddle", "Hurdles", "Box"),
            "Listen" to listOf("Music", "Podcast", "Radio", "Audiobook", "Concert"),
            "Paint" to listOf("Canvas", "Wall", "Portrait", "Landscape", "Abstract"),
            "Point" to listOf("Finger", "Arrow", "Sign", "Direction", "Map"),
            "Run" to listOf("Track", "Marathon", "Race", "Trail", "Path"),
            "Share" to listOf("Story", "Photo", "Meal", "Experience", "Knowledge"),
            "Sing" to listOf("Song", "Chorus", "Melody", "Karaoke", "Opera"),
            "Sort" to listOf("Files", "Clothes", "Books", "Cards", "Tools"),
            "Touch" to listOf("Screen", "Fabric", "Button", "Surface", "Material")
        )

        return listItems.map { (key, value) ->
            Action(
                id = Uuid.random().toString(),
                title = key,
                localImage = value,
                subItems = relatedNouns[key]?.map { noun ->
                    Action(
                        id = Uuid.random().toString(),
                        title = noun,
                        subItems = null
                    )
                }
            )
        }
    }


    @OptIn(ExperimentalUuidApi::class)
    fun generateMoodList(): List<Mood> {
        return listOf(
            Mood(
                id = Uuid.random().toString(),
                type = MoodType.HAPPY,
                title = "Happy",
                imageUrl = "very_happy.json"
            ),
            Mood(
                id = Uuid.random().toString(),
                type = MoodType.SAD,
                title = "Sad",
                imageUrl = "sad.json"
            ),
            Mood(
                id = Uuid.random().toString(),
                type = MoodType.ANGRY,
                title = "Angry",
                imageUrl = "angry.json"
            ),
            Mood(
                id = Uuid.random().toString(),
                type = MoodType.SURPRISED,
                title = "Surprised",
                imageUrl = "surprised.lottie"
            ),
            Mood(
                id = Uuid.random().toString(),
                type = MoodType.NEUTRAL,
                title = "Neutral",
                imageUrl = "neutral.json"
            ),
        )


    }


}