package fr.mathieudubart.wooof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.managers.ProductsManager
import fr.mathieudubart.wooof.ui.components.on_boarding.OnBoardingPager
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.mathieudubart.wooof.ui.components.feed.FeedComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WooofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainView()
                }
            }
        }
    }
}

@Composable
fun GetProductsView() {
    val products: State<List<Product>> = ProductsManager.products.collectAsState()

    Column {
        products.value.forEach { product ->
            Text(product.title)
            Text(product.description)
        }

        Button(onClick = { ProductsManager.getProducts() }) {
            Text("Récupérer les données")
        }
    }
}

@Composable
fun MainView(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "onBoarding") {
        composable("onBoarding") {
            OnBoardingPager(
                modifier = Modifier.fillMaxSize()
            ) {
                navController.navigate("feed")
            }
        }
        composable("feed") {
            FeedComponent(modifier = Modifier.fillMaxSize())
        }
    }
}
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    WooofTheme {
        MainView()
    }
}