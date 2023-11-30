package fr.mathieudubart.wooof.ui.components.onboarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
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
fun OnBoarding(modifier: Modifier = Modifier) {
    Box(
        Modifier
            .background(colorResource(id = R.color.gold))
            .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
    ) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White,
                        colorResource(id = R.color.gold)
                    )
                )
            ),
            painter = painterResource(id = R.drawable.onboarding_first_image),
            contentDescription = stringResource(id = R.string.onboarding_alt_first_image),
            contentScale = ContentScale.FillWidth
        )

        Column (
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment =  Alignment.CenterHorizontally
        ){
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(50.dp))
                    .width(900.dp)
            ) {
                Canvas(modifier = Modifier.fillMaxWidth()) {
                    drawArc(
                        color = Color.LightGray,
                        -180f,
                        180f,
                        useCenter = false,
                        style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
                    )
                }
                Column {
                    Text(modifier = Modifier.padding(start = 48.dp, end = 48.dp, top = 16.dp, bottom = 16.dp), text = stringResource(id = R.string.onboarding_first_title), fontFamily = montserratFamily, color = Color.Black, fontSize = 28.sp, lineHeight = 34.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Text(modifier = Modifier.padding(start = 64.dp, end = 64.dp, bottom = 48.dp), text = stringResource(id = R.string.onboarding_first_subtitle), fontFamily = montserratFamily, color = colorResource(id = R.color.subtitle), fontSize = 16.sp, lineHeight = 22.4.sp, textAlign = TextAlign.Center)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPreview() {
    WooofTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            OnBoarding()
        }
    }
}