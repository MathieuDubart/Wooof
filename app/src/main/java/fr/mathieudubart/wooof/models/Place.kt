package fr.mathieudubart.wooof.models

data class Place(
    val latitude: Double = 0.0,
    var longitude: Double = 0.0,
    val address: String = ""
)
