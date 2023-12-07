package fr.mathieudubart.wooof.ui.components.feed

import android.media.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import androidx.compose.ui.text.TextStyle
import fr.mathieudubart.wooof.utils.montserratFamily

@Composable
fun UltraLargeButton(icon: Painter, contentDescription: String, title: String, subtitle: String, modifier: Modifier =Modifier) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 20.dp,
                spotColor = Color(0x08001226),
                ambientColor = Color(0x08001226)
            )
            .height(72.dp)
            .background(
                color = Color(0xFFFFFFFF),
                shape = RoundedCornerShape(size = 16.dp)
            )
            .padding(12.dp)
    ) {
        Row{
            Image(painter = icon, contentDescription = contentDescription)

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF313131)
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = subtitle,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0x80313131),

                    )
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
                ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_more),
                    contentDescription = stringResource(
                        id = R.string.right_arrow
                    )
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UltraLargeButtonPreview() {
    WooofTheme {
        UltraLargeButton(
            icon = painterResource(id = R.drawable.icon_moving),
            contentDescription = "Moving icon",
            title = "Balades proches",
            subtitle = "24 Disponibles"
        )
    }
}