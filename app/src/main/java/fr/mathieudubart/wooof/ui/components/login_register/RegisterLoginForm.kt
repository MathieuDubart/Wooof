package fr.mathieudubart.wooof.ui.components.login_register

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore
import fr.mathieudubart.wooof.R
import fr.mathieudubart.wooof.ui.theme.WooofTheme
import fr.mathieudubart.wooof.utils.montserratFamily

@Composable
fun RegisterLoginForm() {
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val (passwordConfirmed, setPasswordConfirmed) = remember { mutableStateOf("") }

    var isLogin by remember { mutableStateOf(true) }
    val minHeight = if(!isLogin) 245 else 165



    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        LoginRegisterIntroduction(
            title = stringResource(id = if(isLogin) R.string.login_title else R.string.register_title),
            subtitle = stringResource(id = if(isLogin) R.string.login_subtitle else R.string.register_subtitle)
        )

        Column(
            modifier = Modifier
                .defaultMinSize(minHeight = minHeight.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginRegisterTextFields(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.email_label),
                isPassword = false,
                bind = email,
                onTextChange = setEmail
            )

            LoginRegisterTextFields(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.password_label),
                bind = password,
                isPassword = true,
                onTextChange = setPassword,
            )

            if (isLogin) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ){
                    Text(
                        modifier = Modifier.padding(vertical = 6.dp),
                        text = stringResource(id = R.string.forgotten_password),
                        fontSize = 12.53.sp,
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFA58EFF),
                        textAlign = TextAlign.Center,
                    )
                }
            }

            if(!isLogin) {
                LoginRegisterTextFields(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.confirm_password_label),
                    bind = passwordConfirmed,
                    isPassword = true,
                    onTextChange = setPasswordConfirmed
                )
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 47.dp)
                .shadow(
                    elevation = 17.92717170715332.dp,
                    spotColor = colorResource(id = R.color.purple),
                    ambientColor = Color(0xFFCBD6FF)
                )
                .width(320.dp)
                .height(48.89075.dp)
                .background(
                    color = colorResource(id = R.color.purple),
                    shape = RoundedCornerShape(size = 8.96359.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            onClick = {
                if(isLogin) {
                    signInUser(email, password)
                } else {
                    if (passwordConfirmed === password) {
                        createUser(email, password)
                    }
                }
            }
        ) {
            if (isLogin) {
                Text(stringResource(id = R.string.login_title))
            } else {
                Text(stringResource(id = R.string.register_title))
            }
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
            ),
            onClick = {
                isLogin = !isLogin
            }
        ) {
            Text(
                text = stringResource(id = if(isLogin) R.string.create_account else R.string.already_have_account),
                color = Color.Black
            )
        }

    }
}


// ----------- utils

fun createUser(email: String, password: String) {
    var auth = Firebase.auth
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(ContentValues.TAG, "createUserWithEmail:success")

                registerUser(
                    email,
                    "",
                    "",
                    ""
                )


            } else {
                // If sign in fails, display a message to the user.
                Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                // Afficher l'erreur
            }
        }
}

fun registerUser(email: String, firstname: String, age: String, phoneNumber: String) {
    // Create a new user with a first and last name
    val user = hashMapOf(
        "email" to email,
        "firstname" to firstname,
        "age" to age,
        "phoneNumber" to phoneNumber,
    )

// Add a new document with a generated ID
    val db = Firebase.firestore
    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(ContentValues.TAG, "Error adding document", e)
        }
}

fun signInUser(email: String, password: String) {
    var auth = Firebase.auth
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)
            }
        }
}


@Preview
@Composable
fun RegisterLoginFormPreview() {
    WooofTheme {
        RegisterLoginForm()
    }
}