package fr.mathieudubart.wooof.managers

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ProductsManager: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    fun getProducts() {
        val db = Firebase.firestore
        val fetchedProducts = mutableListOf<Product>()

        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    fetchedProducts.add(document.toObject(Product::class.java))
                    Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
                    Log.d(ContentValues.TAG, "products: $products")
                }

                _products.value = fetchedProducts
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }
    }
}