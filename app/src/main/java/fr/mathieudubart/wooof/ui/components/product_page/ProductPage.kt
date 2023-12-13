package fr.mathieudubart.wooof.ui.components.product_page

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.montserratFamily

@Composable
fun ProductPage(product: Product) {
    Column{
        // Product image, navbar and author display
        Column(
            modifier = Modifier
                .weight(1f)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AsyncImage(
                    model = product.imgUrl,
                    contentDescription = stringResource(id = R.string.product_image_alt),
                    modifier = Modifier
                        .fillMaxSize()
                )
                Column(
                    Modifier
                        // to delete when page finished
                        .background(color = Color.Black)
                        .padding(24.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.icon_back),
                                contentDescription = stringResource(id = R.string.icon_back)
                            )
                        }

                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.icon_share),
                                contentDescription = stringResource(id = R.string.icon_share)
                            )
                        }
                    }

                    Row {
                        Column {
                            // User prez row
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    Modifier
                                        .background(
                                            color = Color(0x4DFFFFFF),
                                            shape = RoundedCornerShape(size = 30.dp)
                                        )
                                        .padding(
                                            start = 6.dp,
                                            top = 5.dp,
                                            end = 8.dp,
                                            bottom = 5.dp
                                        ),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_dog_card),
                                        contentDescription = stringResource(id = R.string.profile_picture),
                                        modifier = Modifier
                                            .width(32.dp)
                                            .height(32.dp)
                                            .clip(CircleShape)
                                    )


                                    Column {
                                        Row(
                                            modifier = Modifier
                                                .padding(start = 6.dp, end = 6.dp)
                                        ) {
                                            Text(
                                                text = product.author.firstName + " " + product.author.lastName.first() + ".",
                                                color = colorResource(id = R.color.white),
                                                fontSize = 13.sp,
                                                lineHeight = 14.sp,
                                                fontFamily = montserratFamily,
                                                fontWeight = FontWeight(600),
                                            )

                                            Image(
                                                modifier = Modifier.padding(start = 8.dp),
                                                painter = painterResource(id = R.drawable.icon_verify),
                                                contentDescription = stringResource(id = R.string.icon_verify)
                                            )
                                        }

                                        Row(
                                            modifier = Modifier
                                                .padding(start = 6.dp, end = 6.dp),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Row(){
                                                Image(
                                                    modifier = Modifier.padding(top = 2.dp,end = 3.dp),
                                                    painter = painterResource(id = R.drawable.icon_star),
                                                    contentDescription = stringResource(id = R.string.icon_star)
                                                )
                                                Text(
                                                    text = product.author.note,
                                                    fontSize = 13.sp,
                                                    fontFamily = montserratFamily,
                                                    fontWeight = FontWeight(600),
                                                    color = Color(0xB2FFFFFF)
                                                )
                                            }
                                        }


                                    }
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(
                                        text = stringResource(id = R.string.until) + " " + product.date,
                                        color = Color.White)
                                }
                            }
                        }

                    }
                }
            }
        }

        // Data display about product
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(24.dp)
        ){
            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                // Product title display
                Box(
                    modifier = Modifier.weight(1f)
                ){
                    Text(
                        text = product.title,
                        fontSize = 26.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(800),
                    )
                }

                // Product isFavorite display
                Box(
                    modifier = Modifier.padding(top = 7.dp)
                ){
                    IconButton(
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp),
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder,
                            contentDescription = stringResource(
                                id = R.string.add_to_favorite
                            )
                        )
                    }
                }
            }

            Box(
                modifier = Modifier.padding(bottom = 16.dp)
            ){
                Text(
                    text = product.description,
                    fontSize = 16.sp,
                    fontFamily = montserratFamily,
                    lineHeight = 22.sp,
                    fontWeight = FontWeight(500),
                    letterSpacing = 0.16.sp,)
            }

            Column {
                Row(
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.wallet),
                        contentDescription = stringResource(id = R.string.wallet_icon),
                        modifier = Modifier.padding(end = 7.dp)
                    )

                    Text(
                        text = stringResource(id = R.string.paid) + " " + product.price.toInt() + stringResource( id = R.string.money_symbol),
                        fontSize = 14.sp,
                        lineHeight = 17.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(600),
                        letterSpacing = 0.14.sp,
                    )
                }

                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.geo),
                        contentDescription = stringResource(id = R.string.geo_icon),
                        modifier = Modifier.padding(end = 7.dp)
                    )

                    Text(
                        text = product.place.address,
                        fontSize = 14.sp,
                        lineHeight = 17.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(600),
                        letterSpacing = 0.14.sp,
                    )
                }
            }

        }

        Row(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 8.dp)
        ) {

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(8.dp),
                onClick = { /*TODO*/ }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_chat),
                    contentDescription = stringResource(id = R.string.send_message)
                )
            }

            Box(
                Modifier.padding(top = 8.dp, start = 8.dp)
            ){
                Button(
                    modifier = Modifier
                        .shadow(
                            elevation = 12.dp,
                            spotColor = Color(0x6EBAA9FF),
                            ambientColor = Color(0x6EBAA9FF)
                        )
                        .background(
                            shape = RoundedCornerShape(size = 12.dp),
                            color = Color(0xFFA58EFF)
                        )
                        .height(60.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Text(
                        text = stringResource(id = R.string.propose_yourself),
                        fontSize = 14.sp,
                        lineHeight = 17.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        letterSpacing = 0.14.sp,
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductPagePreview() {
    WooofTheme {
        ProductPage(
            product = Product(
                "Balader et nourrir mon petit Roger",
                "Leaving for a week, French Bulldog Wilfred needs help feeding twice a day\n" +
                        "and walk from 26 to 30 September. \n" +
                        "I bought food, it will be easy.",
                50.0,
                Author("Jack", "Sparrow", "4.9", "", true),
                "20/09/2023",
                false,
                "https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*",
                Place(1.50, 2.60, "Adresse")
            )
        )
    }
}