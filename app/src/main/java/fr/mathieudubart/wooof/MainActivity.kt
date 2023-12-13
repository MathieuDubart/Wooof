package fr.mathieudubart.wooof

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.managers.ProductsManager
import fr.mathieudubart.wooof.ui.components.on_boarding.OnBoardingPager
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import fr.mathieudubart.wooof.ui.components.feed.FeedComponent
import fr.mathieudubart.wooof.ui.components.login_register.LoginView

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private var isAuthenticated by  mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        setContent {
            WooofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    if(isAuthenticated) {
                        FeedComponent()
                    } else {
                        ConnectionView()
                    }
                }
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            println("currentUser found to be: $currentUser")
            isAuthenticated = true
        }
    }
}

@Composable
fun ConnectionView(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "onBoarding") {
        composable("onBoarding") {
            OnBoardingPager(
                modifier = Modifier.fillMaxSize()
            ) {
                navController.navigate("connection")
            }
        }
        composable("connection") {
            LoginView()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainPreview() {
    WooofTheme {
        ConnectionView()
    }
}