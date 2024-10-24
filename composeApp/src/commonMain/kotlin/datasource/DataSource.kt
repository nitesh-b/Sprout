package datasource

import models.DiscoverModel
import models.Fact
import kotlin.random.Random

class DataSource {
    private val funFacts = arrayOf(
        Fact(
            id = "1",
            imageUrl = "https://picsum.photos/800/450",
            title = "Eiffel Tower",
            description = "The Eiffel Tower can be 15 cm taller during the summer due to thermal expansion of the iron."
        ),
        Fact(
            id = "2",
            imageUrl = "https://picsum.photos/800/450",
            title = "Honey",
            description = "Honey never spoils. Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still perfectly edible."
        ),
        Fact(
            id = "3",
            imageUrl = "https://picsum.photos/800/450",
            title = "Octopus",
            description = "An octopus has three hearts, nine brains, and blue blood."
        ),
        Fact(
            id = "4",
            imageUrl = "https://picsum.photos/800/450",
            title = "Bananas",
            description = "Bananas are berries, but strawberries aren't."
        ),
        Fact(
            id = "5",
            imageUrl = "https://picsum.photos/800/450",
            title = "Space Smell",
            description = "Astronauts report that space smells like seared steak, hot metal, and welding fumes."
        )
    )

    fun generateRandomDiscoverModel(): DiscoverModel {
        val id = Random.nextInt(1000, 9999).toString()
        val imageUrl = "https://picsum.photos/200/200"
        val title = "Title ${Random.nextInt(1, 100)}"
        val dateTS =
            Random.nextLong(1609459200, 1672444800) // Random timestamp between 2021 and 2023
        val address = "${Random.nextInt(1, 100)} Address st, City, NSW 2020"
        return DiscoverModel(id, imageUrl, title, dateTS, address)
    }


}