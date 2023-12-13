package fr.mathieudubart.wooof.ui.components.feed

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.managers.ProductsManager
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.SetStatusBarColor


@Composable
fun FeedComponent(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var products = ProductsManager.products.collectAsState()

    LaunchedEffect(Unit) {
        ProductsManager.getProducts()
    }

    SetStatusBarColor(
        systemColor = colorResource(id = R.color.background),
        navigationColor = colorResource(id = R.color.background)
    )

    Box {
        Column(
            Modifier
                .padding(24.dp)
                .verticalScroll(scrollState)
        ) {
            CustomSearchBar(
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .fillMaxWidth()
            )
            FeedTitle(
                title = stringResource(id = R.string.near_you),
                subtitle = stringResource(id = R.string.on_map)
            )

            LazyRow(
                modifier = Modifier.padding(bottom = 20.dp)
            ) {
                items(products.value) { product ->
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

            FeedTitle(
                title = stringResource(id = R.string.categories),
                subtitle = stringResource(id = R.string.see_all)
            )
            UltraLargeButton(
                icon = painterResource(id = R.drawable.icon_moving),
                contentDescription = stringResource(id = R.string.moving_icon),
                title = stringResource(id = R.string.near_walk),
                subtitle = "24 " + stringResource(id = R.string.avalaible),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            UltraLargeButton(
                icon = painterResource(id = R.drawable.icon_house),
                contentDescription = stringResource(id = R.string.house_icon),
                title = stringResource(id = R.string.on_site_care),
                subtitle = "5 " + stringResource(id = R.string.tasks),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }


        //navigation tabview
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = Color(0xFFFCFCFC)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menu_icon),
                        contentDescription = stringResource(
                            id = R.string.menu_home
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menu_heart),
                        contentDescription = stringResource(
                            id = R.string.menu_heart
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .background(
                            colorResource(id = R.color.purple),
                            shape = RoundedCornerShape(50.dp)
                        )
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    
                }


                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menu_chat),
                        contentDescription = stringResource(
                            id = R.string.messages
                        )
                    )
                }

                Button(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues(0.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menu_user),
                        contentDescription = stringResource(
                            id = R.string.menu_user
                        )
                    )
                }
            }
        }
    }

}



fun addProduct() {
    val product = Product(
        "Balader et nourir mon petit roger",
        "Lorem ipsum",
        50.0,
        Author("Jack", "Sparrow", "", "", true),
        "20/09/2023",
        false,
        "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*",
        Place(1.50, 2.60, "Adresse")
    )

    val db = Firebase.firestore
    db.collection("products").add(product)
}


@Preview(showBackground = true)
@Composable
fun FeedPreview() {
    WooofTheme {
        FeedComponent(
            Modifier.fillMaxSize()
        )
    }
}