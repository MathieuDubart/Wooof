package fr.mathieudubart.wooof.models

data class Product(
    val title: String = "",//
    val description: String = "",//
    val price: Double = 0.0,//
    val author: Author = Author(firstName="", lastName = "", note = "0.0", isCertified = false, profilePictureUrl = ""),
    val date: String = "",//
    val favorite: Boolean = false,
    val imgUrl: String = "",//
    val place: Place = Place(latitude = 0.0, longitude = 0.0, address = "")
)