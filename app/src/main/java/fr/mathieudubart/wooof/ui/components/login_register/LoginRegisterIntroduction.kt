package fr.mathieudubart.wooof.ui.components.login_register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
fun LoginRegisterIntroduction(title: String, subtitle: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 43.dp, bottom = 13.dp),
            text = title,
            fontSize = 27.21.sp,
            fontFamily = montserratFamily,
            fontWeight = FontWeight(700),
            color = colorResource(id = R.color.purple),
            textAlign = TextAlign.Center,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 43.dp),
            text = subtitle,
            fontSize = 12.7.sp,
            fontFamily = montserratFamily,
            fontWeight = FontWeight(600),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginRegisterIntroPreview() {
    WooofTheme {
        LoginRegisterIntroduction(
            title = stringResource(id = R.string.register_title),
            subtitle = stringResource(id = R.string.register_subtitle)
        )
    }
}