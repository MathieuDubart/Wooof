package fr.mathieudubart.wooof.ui.components.product_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.models.Product

@Composable
fun ProductPage(product: Product) {
    var painter = rememberImagePainter(data = product.imgUrl)

    // Product image, navbar and author display
    Column {
        Box {
            Image(painter = painter, contentDescription = product.description)
            Column {
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.icon_back),
                            contentDescription = stringResource(id = R.string.icon_back)
                        )
                    }

                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.icon_share),
                            contentDescription =  stringResource(id = R.string.icon_share)
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

                    Column {
                        Row {
                            Text(stringResource(id = R.string.until) + " " + product.date)
                        }
                    }
                }
            }
        }
    }

    // Data display about product
    Column {
        Row {
            // Product title display
            Column {

            }

            // Product isFavorite display
            Column {

            }
        }
    }
}