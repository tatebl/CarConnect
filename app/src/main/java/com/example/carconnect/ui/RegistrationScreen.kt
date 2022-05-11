package com.example.carconnect.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen() {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val firstName = rememberSaveable() { mutableStateOf("") }
    val lastName = rememberSaveable() { mutableStateOf("") }
    val phone = rememberSaveable() { mutableStateOf("") }
    val zip = rememberSaveable() { mutableStateOf("") }
    val email = rememberSaveable() { mutableStateOf("") }
    val password = rememberSaveable() { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        
            Text(text = "Basic Info",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(40.dp))
        
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = firstName.value,
                onValueChange = { firstName.value = it },
                label = { Text(text = "First Name") },
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

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = lastName.value,
                onValueChange = { lastName.value = it },
                label = { Text(text = "Last Name") },
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

            TextField(
                modifier = Modifier
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

            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color(0xff586ae0),
                    unfocusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ))

            Row() {
                TextField(
                    modifier = Modifier
                        .weight(.6f),
                    value = phone.value,
                    onValueChange = { phone.value = it },
                    label = { Text(text = "Phone #") },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color(0xff586ae0),
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp),
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Phone
                    )
                )

                TextField(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(.4f),
                    value = zip.value,
                    onValueChange = { zip.value = it },
                    label = { Text(text = "Zip") },
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color(0xff586ae0),
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(8.dp),
                    keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { /*TODO*/ },
                modifier = Modifier
                    .absolutePadding(top = 16.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xff586ae0)
                )) {
                Text(text = "Register")
            }

            Button(
                onClick = {
                },
                modifier = Modifier
                    .absolutePadding(top = 4.dp, left = 8.dp, right = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.LightGray
                )) {
                Text("Cancel")
            }
        }
        
    }
}