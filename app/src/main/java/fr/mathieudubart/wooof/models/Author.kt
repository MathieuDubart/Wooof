package fr.mathieudubart.wooof.models

data class Author(
    val firstName: String = "",
    val lastName: String = "",
    val note: String = "",
    val profilePictureUrl: String = "",
    var isCertified: Boolean = false
)
