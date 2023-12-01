package fr.mathieudubart.wooof.ui.components.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.SetStatusBarColor

@Composable
fun FeedComponent(modifier: Modifier = Modifier) {
    SetStatusBarColor(
        systemColor = colorResource(id = R.color.background),
        navigationColor = colorResource(id = R.color.background)
    )

    Column(Modifier.padding(24.dp)) {
        CustomSearchBar()
    }
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