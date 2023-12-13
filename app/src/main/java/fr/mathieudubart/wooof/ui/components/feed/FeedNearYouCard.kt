package fr.mathieudubart.wooof.ui.components.feed

import androidx.compose.foundation.Image
import coil.compose.AsyncImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.montserratFamily

@Composable
fun FeedNearYouCard(modifier: Modifier = Modifier, product:Product ) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Box(
        Modifier.padding(end = 16.dp)
    ){
        Column(
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = Color(0x08001226),
                        ambientColor = Color(0x08001226)
                    )
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 12.dp
                    )
                    .width(264.dp)
                    .height(326.dp),
                verticalArrangement = Arrangement.Top
            ) {
                Box(
                    modifier = Modifier.weight(0.4f)
                ) {
                    AsyncImage(
                        model = product.imgUrl,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(20.dp))
                            .fillMaxSize(),
                        contentDescription = stringResource(
                            id = R.string.card_box_description,
                        ),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        Modifier.padding(12.dp)
                    ) {
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
                                        id = R.string.add_to_favorite
                                    )
                                )
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
                            ) {
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
                                    modifier = Modifier.padding(start = 6.dp, end = 6.dp),
                                    color = Color.White
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
                        .weight(0.1f)
                        .padding(top = 12.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = product.title,
                        fontSize = 16.sp,
                        lineHeight = 22.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(600),
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .weight(0.9f)
                    )

                    Button(
                        modifier = Modifier
                            .width(40.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_chat_no_background),
                            contentDescription = stringResource(id = R.string.send_message)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedNearYouCardPreview() {
    WooofTheme {
        FeedNearYouCard(
            product = Product(
                "Balader et nourir mon petit Roger",
                "Lorem ipsum",
                50.0,
                Author("Jack", "Sparrow", "", "", true),
                "20/09/2023",
                true,
                "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*",
                Place(1.50, 2.60, "Adresse")
            ),
            modifier = Modifier
                .background(
                    color = Color.Red,
                    shape = RoundedCornerShape(20.dp)
                )
        )
    }
}