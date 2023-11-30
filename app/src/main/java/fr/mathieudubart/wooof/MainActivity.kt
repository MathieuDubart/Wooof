package fr.mathieudubart.wooof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.managers.ProductsManager
import fr.mathieudubart.wooof.ui.components.onboarding.OnBoarding
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.SetStatusBarColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WooofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    SetStatusBarColor(colorResource(id = R.color.gold))
                    OnBoarding(modifier = Modifier.fillMaxSize())
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

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    WooofTheme {
        OnBoarding()
    }
}