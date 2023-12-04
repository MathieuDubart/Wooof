package fr.mathieudubart.wooof.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.ui.theme.WooofTheme

@Composable
fun FeedNearYouCard(modifier: Modifier = Modifier, product:Product ) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Column(
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x08001226),
                ambientColor = Color(0x08001226)
            )
            .width(264.dp)
            .height(326.dp)
            .background(
                color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 28.dp)
            )
    ){
        Box(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 12.dp
                )
        ){
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(20.dp)),
                painter = painterResource(id = R.drawable.img_dog_card),
                contentDescription = stringResource(
                    id = R.string.card_box_description,
                )
            )
            Column(
                Modifier.padding(12.dp)
            ){
                // date & favorite row
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .width((screenWidth / 2).dp)
                            .height(20.dp),
                        text = product.date,
                    )
                    IconButton(
                        modifier = Modifier
                            .height(20.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder,
                            contentDescription = stringResource(
                            id = R.string.add_to_favorite
                        ))
                    }
                }

                // User prez row
                Row(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Row(
                        Modifier
                            .background(
                                color = Color(0x4DFFFFFF),
                                shape = RoundedCornerShape(size = 30.dp)
                            )
                            .padding(start = 6.dp, top = 5.dp, end = 8.dp, bottom = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.img_dog_card),
                            contentDescription = "profile picture",
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .clip(CircleShape)
                        )

                        Text(
                            text = product.author.firstName + " " + product.author.lastName.first() + ".",
                            modifier = Modifier.padding(start = 6.dp, end = 6.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.icon_verify),
                            contentDescription = stringResource(id = R.string.icon_verify)
                        )
                    }
                }
            }
        }

        Row(
            Modifier
                .height(44.dp)
                .fillMaxWidth()
        ) {
            Text("This is the second Row")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedNearYouCardPreview() {
    WooofTheme {
        FeedNearYouCard(
            product = Product(
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