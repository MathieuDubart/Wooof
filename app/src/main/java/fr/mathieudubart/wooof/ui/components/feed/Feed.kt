package fr.mathieudubart.wooof.ui.components.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.models.Author
import fr.mathieudubart.wooof.models.Place
import fr.mathieudubart.wooof.models.Product
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.SetStatusBarColor

@Composable
fun FeedComponent(modifier: Modifier = Modifier) {
    val products = listOf(
                Product(
                    "1",
                    "Lorem ipsum",
                    50.0,
                    Author("Jack", "Sparrow", "", "", true),
                    "20/09/2023",
                    true,
                    "",
                    Place(1.50, 2.60, "Adresse")
                ),
                Product(
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


    SetStatusBarColor(
        systemColor = colorResource(id = R.color.background),
        navigationColor = colorResource(id = R.color.background)
    )

    Column(Modifier.padding(24.dp)) {
        CustomSearchBar()
        FeedTitle(title = stringResource(id = R.string.near_you), subtitle = stringResource(id = R.string.on_map))

        LazyRow {
            items(products) { product ->
                FeedNearYouCard(product = product, modifier = Modifier.padding(end = 16.dp))
            }
        }

        FeedTitle(title = stringResource(id = R.string.categories), subtitle = stringResource(id = R.string.see_all))
        UltraLargeButton(
            icon = painterResource(id = R.drawable.icon_moving),
            contentDescription = stringResource(id = R.string.moving_icon),
            title = stringResource(id = R.string.near_walk),
            subtitle = "24 " + stringResource(id = R.string.avalaible),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        UltraLargeButton(
            icon = painterResource(id = R.drawable.icon_house),
            contentDescription = stringResource(id = R.string.house_icon),
            title = stringResource(id = R.string.on_site_care),
            subtitle = "5 " + stringResource(id = R.string.tasks),
            modifier = Modifier.padding(bottom = 16.dp)
        )

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