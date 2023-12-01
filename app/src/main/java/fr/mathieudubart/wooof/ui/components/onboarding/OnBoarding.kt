package fr.mathieudubart.wooof.ui.components.onboarding

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.models.OnBoardingPage
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.SetStatusBarColor
import fr.mathieudubart.wooof.utils.montserratFamily

@Composable
fun OnBoarding(modifier: Modifier = Modifier, currentPage: OnBoardingPage, onNavigateLeft: () -> Unit, onNavigateRight: () -> Unit, onGetStarted: () -> Unit) {
    SetStatusBarColor(systemColor = colorResource(id = R.color.gold), navigationColor = colorResource(id = R.color.white))

    Box(
        Modifier
            .background(colorResource(id = R.color.gold))
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    val size = size.toSize()
                    val middleX = size.width / 2

                    if (offset.x < middleX) {
                        onNavigateLeft()
                    } else {
                        onNavigateRight()
                    }
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Image(modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(0.5f),
                        colorResource(id = R.color.gold)
                    )
                )
            ),
            painter = currentPage.imagePainter,
            contentDescription = currentPage.imageAlt,
            contentScale = ContentScale.FillWidth
        )

        Column (
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment =  Alignment.CenterHorizontally,
        ){
            Box(
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.onboarding_background),
                    contentDescription = stringResource(id = R.string.onboarding_alt_background),
                    contentScale = ContentScale.FillWidth
                )

                Column (Modifier.padding(bottom = 36.dp)){
                    Text(modifier = Modifier.padding(start = 48.dp, end = 48.dp, top = 16.dp, bottom = 16.dp), text = currentPage.title, fontFamily = montserratFamily, color = Color.Black, fontSize = 28.sp, lineHeight = 34.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                    Text(modifier = Modifier.padding(start = 64.dp, end = 64.dp, bottom = 48.dp), text = currentPage.description, fontFamily = montserratFamily, color = colorResource(id = R.color.subtitle), fontSize = 16.sp, lineHeight = 22.4.sp, textAlign = TextAlign.Center)
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
            OnBoarding(
                currentPage =
                    OnBoardingPage(
                        stringResource(id = R.string.onboarding_first_title),
                        stringResource(id = R.string.onboarding_first_subtitle),
                        painterResource(id = R.drawable.onboarding_background),
                        stringResource(id = R.string.onboarding_alt_first_image)
                    ),
                onNavigateLeft = {},
                onNavigateRight = {},
                onGetStarted = {}
            )
        }
    }
}