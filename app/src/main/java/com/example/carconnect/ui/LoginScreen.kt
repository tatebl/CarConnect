package com.example.carconnect.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Welcome()
        EmailPassword()
        Spacer(modifier = Modifier.height(25.dp))

    }
}

@Composable
fun Welcome() {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "CarConnect",
            style= MaterialTheme.typography.h2,
            fontFamily = FontFamily.Cursive)

    }
}

@OptIn(ExperimentalComposeUiApi::class, androidx.compose.material.ExperimentalMaterialApi::class)
@Composable
fun EmailPassword() {
    val password = rememberSaveable() { mutableStateOf("") }
    val showPassword = remember { mutableStateOf(false) }
    val email = rememberSaveable() { mutableStateOf("") }
    var message = remember() { mutableStateOf("")  }//keeps track of cursor
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    //Email text field
    TextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        value = email.value,
        onValueChange = { email.value = it },
        label = { Text(text = "Email") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color(0xff586ae0),
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Email
        )
    )

    //Password text field
    TextField(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text(text = "Password") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color(0xff586ae0)
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None  //keep dots
        } else {
            PasswordVisualTransformation()   //show password
        },
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "Hide Password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "Show Password"
                    )
                }
            }
        }
    )
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${message.value}", color = Color.Red)
    }

    //login button
    Button(
        onClick = {
            if(loginSuccessful(email.value,password.value)) {
                //activeUser = email.value
                Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
//                context.startActivity(Intent(context, MainActivity()::class.java))
            } else {
                message.value = "Invalid username/password"
            }
        },
        modifier = Modifier
            .absolutePadding(top = 16.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xff586ae0)
        )
    )
    {
        Text("Login")
    }
    RegisterButton()
    Spacer(modifier = Modifier.height(60.dp))

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Text(text = "Continue without account",
            textAlign = TextAlign.Center,
            color = Color.Blue,
            style = TextStyle(Color.Blue,textDecoration = TextDecoration.Underline)
        )
    }

}

fun loginSuccessful(user:String, pass:String): Boolean {
    var userSuccessful: Boolean = false
    var passSuccessful: Boolean = false

//    if ((accountList.containsKey(user))) {
//        userSuccessful = true
//        var i = accountList.getValue(user)
//        if (i.password.equals(pass))
//            passSuccessful = true
//    }
//
//    if (userSuccessful && passSuccessful) {
//        return true
//    } else {
//        return false
//    }
    return true
}

@Composable
fun RegisterButton() {
    val context = LocalContext.current
    Button(
        onClick = {
//            context.startActivity(Intent(context, Registration::class.java))
        },
        modifier = Modifier
            .absolutePadding(top = 4.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.LightGray
        )) {
        Text("Register")
    }
}