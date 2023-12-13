package fr.mathieudubart.wooof.ui.components.login_register

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.utils.montserratFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginRegisterTextFields(modifier: Modifier = Modifier, label: String, isPassword: Boolean, bind: String, onTextChange: (String) -> Unit) {
    Box(
        modifier = modifier
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = bind,
            onValueChange = onTextChange,
            placeholder = {
                Text(
                    text = label,
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight(600),
                    fontSize = 14.sp
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF1F4FF),
                textColor =  Color(0xFF313131),
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color(0xFFA58EFF),
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            maxLines = 1,
            shape = RoundedCornerShape(9.dp),
            visualTransformation = if (!isPassword) VisualTransformation.None else PasswordVisualTransformation()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginRegisterTextFieldsPreview() {
    var (email, setEmail) = remember { mutableStateOf("") }

    LoginRegisterTextFields(
        label = stringResource(id = R.string.email_label),
        bind = email,
        isPassword = false,
        onTextChange = setEmail
    )
}