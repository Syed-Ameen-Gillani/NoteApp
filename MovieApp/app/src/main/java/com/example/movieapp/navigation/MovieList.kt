package com.example.movieapp.navigation

import android.media.Image
import androidx.annotation.DrawableRes
import com.example.movieapp.R

data class MovieList(
    val title:String,
    val producer: String,
    val description:String,
    @DrawableRes val image: Int,
    val year:String,
    )

fun getMovieList(): List<MovieList> {
    return listOf<MovieList>(
        MovieList("Whispers of Eternity", "Sophie Anderson", "Embark on a breathtaking journey through time and space in this sci-fi epic, as secrets unravel, destinies collide, and the universe unfolds its cosmic mysteries.", R.drawable.a, "2021"),
        MovieList("Chronicles of Destiny", "James Harris", "In a mystical land of enchantment, follow the hero's quest to fulfill an ancient prophecy and confront dark forces threatening to plunge the realm into eternal shadow.", R.drawable.b, "2024"),
        MovieList("Midnight Reverie", "Olivia Turner", "Love transcends boundaries in this captivating romantic drama set against the backdrop of a moonlit cityscape. Embrace the magic of the night and the power of true connection.", R.drawable.c, "2023"),
        MovieList("Legacy of Legends", "Daniel White", "Witness the epic tale of heroes and villains, as legacies clash and destinies intertwine. Unravel the rich tapestry of history in this grand cinematic experience.", R.drawable.d, "2021"),
        MovieList("Echoes of Eternity", "Emma Miller", "A mind-bending journey awaits as characters navigate the complexities of time and space. Brace yourself for unexpected twists and revelations that defy the laws of reality.", R.drawable.e, "1998"),
        MovieList("Enigmatic Secrets", "Ava Parker", "Unlock the mysteries shrouded in secrecy in this thrilling adventure. Immerse yourself in a world where every choice holds consequences, and nothing is as it seems.", R.drawable.f, "2003"),
        MovieList("Spectral Whispers", "Nathan Scott", "Dive into the supernatural with this haunting mystery. Whispers of the unseen echo through the shadows as characters grapple with forces beyond comprehension.", R.drawable.g, "2012"),
        MovieList("Beyond the Horizon", "Sophia Davis", "Embark on an adventurous quest to the unknown, where untold wonders and dangers await. Beyond the horizon lies a world of discovery, courage, and the triumph of the human spirit.", R.drawable.h, "2013"),
        MovieList("Shadows of Destiny", "Liam Carter", "A gripping crime drama unfolds as shadows cast doubt and deception. Follow the twists and turns of an intricate plot that keeps you guessing until the final revelation.", R.drawable.i, "2012"),
        MovieList("Lost in Time", "Emily Bennett", "Love defies the boundaries of time in this enchanting tale of romance and destiny. Brace yourself for a rollercoaster of emotions as characters navigate the challenges of temporal paradoxes.", R.drawable.j, "2017"),
        MovieList("Celestial Harmony", "Mia Campbell", "Journey through the cosmos in this musical odyssey, where celestial harmonies intertwine with the human experience. Let the melodies of the universe guide you on an ethereal adventure.", R.drawable.a, "2018"),
        MovieList("Realm of Dreams", "Ethan Turner", "Explore the fantastical landscapes of dreams in this visually stunning adventure. Unravel the secrets hidden within the dream realm as characters confront their deepest fears and desires.", R.drawable.b, "2019"),
        MovieList("Midnight Masquerade", "Isaac Rodriguez", "Step into a world of elegance and intrigue in this romantic ball under the stars. Masks conceal identities, and love blossoms amidst the enchanting atmosphere of a midnight masquerade.", R.drawable.c, "2020"),
        MovieList("Puzzle Pieces", "Grace Lewis", "Piece together the enigma of a mind-bending mystery that challenges perception and intellect. Every clue brings you closer to unraveling the puzzle, leading to a surprising and satisfying resolution.", R.drawable.d,"2021"))
}

