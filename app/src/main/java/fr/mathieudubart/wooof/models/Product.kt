package fr.mathieudubart.wooof.models

data class Product(
    val title: String,
    val description: String,
    val price: Double,
    val author: Author,
    val date: String,
    val isFavorite: Boolean,
    val imgUrl: String,
    val place: Place
)
