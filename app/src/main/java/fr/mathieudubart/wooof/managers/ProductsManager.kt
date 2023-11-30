package fr.mathieudubart.wooof.managers

import androidx.lifecycle.ViewModel
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ProductsManager: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    fun getProducts() {
        //todo: get products on firebase
        //_products = retour de firebase
        _products.value = listOf(
            Product(
                "1",
                "Lorem ipsum",
                50.0,
                Author("Jack", "Sparrow", "", "", true),
                "20/09/2023",
                true,
                "",
                Place(1.50, 2.60, "Adresse")
            )
        )
    }
}