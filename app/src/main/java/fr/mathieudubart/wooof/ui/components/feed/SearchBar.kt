package fr.mathieudubart.wooof.ui.components.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mathieudubart.wooof.utils.montserratFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar() {
    var text by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        TextField(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .shadow(
                    elevation = 12.dp,
                    spotColor = colorResource(id = R.color.shadow),
                    ambientColor = colorResource(id = R.color.shadow),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(end = 16.dp)
                .height(48.dp),
            value = text,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.iconsearch),
                    contentDescription = "searchIcon",
                    tint = Color(0xFF313131)
                )
            },
            onValueChange = { text = it },
            placeholder = {
                Text(
                    stringResource(id = R.string.textfield_label),
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                textColor =  Color(0xFF313131),
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            maxLines = 1,
        )

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .shadow(
                    elevation = 12.dp,
                    spotColor = colorResource(id = R.color.shadow),
                    ambientColor = colorResource(id = R.color.shadow),
                    shape = RoundedCornerShape(16.dp)
                )
                .height(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = stringResource(id = R.string.filter_alt),
                tint = Color.Unspecified,
                modifier = Modifier.fillMaxHeight(1f)
                    .aspectRatio(1f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    WooofTheme {
        CustomSearchBar()
    }
}