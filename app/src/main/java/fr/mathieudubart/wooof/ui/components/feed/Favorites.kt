package fr.mathieudubart.wooof.ui.components.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mathieudubart.wooof.managers.ProductsManager
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.ui.theme.WooofTheme

@Composable
fun Favorites() {
    var products = listOf<Product>(
        Product(
            "Balader et nourir mon petit roger",
            "Lorem ipsum",
            50.0,
            Author("Jack", "Sparrow", "", "", true),
            "20/09/2023",
            false,
            "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*",
            Place(1.50, 2.60, "Adresse")
        ),
        Product(
            "Balader et nourir mon petit roger",
            "Lorem ipsum",
            50.0,
            Author("Jack", "Sparrow", "", "", true),
            "20/09/2023",
            false,
            "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*",
            Place(1.50, 2.60, "Adresse")
        )
    )
    /*var products = ProductsManager.products.collectAsState()

    LaunchedEffect(Unit) {
        ProductsManager.getProducts()
    }*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        FeedTitle(title = "Gardes à venir", subtitle = null)

        LazyRow(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            items(products) { product ->
                FeedNearYouCard(
                    product = product,
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                )
            }
        }

        FeedTitle(title = "Gardes Passées", subtitle = null)

        LazyRow(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            items(products) { product ->
                FeedNearYouCard(
                    product = product,
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesPreview() {
    WooofTheme {
        Favorites()
    }
}