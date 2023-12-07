package fr.mathieudubart.wooof.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.montserratFamily

@Composable
fun FeedTitle(title: String, subtitle: String) {

    val screenWidth = LocalConfiguration.current.screenWidthDp

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(bottom = 20.dp)
    ){
        Text(
            text = title,
            fontFamily = montserratFamily,
            fontWeight = FontWeight(700),
            fontSize = 20.sp,
            modifier = Modifier.width((screenWidth/2).dp)
        )
        Row(
            modifier = Modifier
                .width((screenWidth/2).dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = subtitle,
                fontSize = 13.sp,
                lineHeight = 16.sp,
                fontFamily = montserratFamily,
                fontWeight = FontWeight(400),
                color = colorResource(id = R.color.subtitle),
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier.padding(start = 6.dp, end = 6.dp),
                painter = painterResource(id = R.drawable.icon_more_small),
                contentDescription = stringResource(
                    id = R.string.right_arrow
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NearYouPreview() {
    WooofTheme {
        FeedTitle(title = stringResource(id = R.string.near_you,), subtitle = stringResource(id = R.string.on_map,))
    }
}