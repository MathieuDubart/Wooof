package fr.mathieudubart.wooof.ui.components.on_boarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.models.OnBoardingPage
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingPager(modifier: Modifier = Modifier, onGetStarted: () -> Unit) {
    val listOfPages = listOf<OnBoardingPage>(
        OnBoardingPage(
            stringResource(id = R.string.onboarding_first_title),
            stringResource(id = R.string.onboarding_first_subtitle),
            painterResource(id = R.drawable.onboarding_first_image),
            stringResource(id = R.string.onboarding_alt_first_image)
        ),
        OnBoardingPage(
            stringResource(id = R.string.onboarding_second_title),
            stringResource(id = R.string.onboarding_second_subtitle),
            painterResource(id = R.drawable.onboarding_second_image),
            stringResource(id = R.string.onboarding_alt_second_image)
        ),
        OnBoardingPage(
            stringResource(id = R.string.onboarding_third_title),
            stringResource(id = R.string.onboarding_third_subtitle),
            painterResource(id = R.drawable.onboarding_third_image),
            stringResource(id = R.string.onboarding_alt_third_image)
        )
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = {
        listOfPages.count()
    })

    val scope = rememberCoroutineScope()

    var currentPage = listOfPages[pagerState.currentPage]

    Column(Modifier.background(color = colorResource(id = R.color.gold))) {
        OnBoardingProgressBar(pagerState,nbPages = listOfPages.count())
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ){
            IconButton(onClick = onGetStarted) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = stringResource(id = R.string.close), tint = Color.White)
            }
        }
        HorizontalPager(state = pagerState) { page ->
            OnBoarding(currentPage = listOfPages[page],
                onNavigateLeft = {
                    if (pagerState.currentPage > 0) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
                onNavigateRight = {
                    if (pagerState.currentPage < listOfPages.size - 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                onGetStarted = onGetStarted
                )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingProgressBar(pagerState: PagerState, nbPages: Int) {
    val indicatorWidth = 120.dp
    val indicatorHeight = 3.dp
    val activeIndicatorColor = Color.White
    val inactiveIndicatorColor = Color.White.copy(alpha = 0.6f)

    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(nbPages) { iteration ->
            val color = if (pagerState.currentPage == iteration) activeIndicatorColor else inactiveIndicatorColor
            Box(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .size(width = indicatorWidth, height = indicatorHeight)
                    .background(color, RoundedCornerShape(50))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPagerPreview() {
    WooofTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            OnBoardingPager {

            }
        }
    }
}