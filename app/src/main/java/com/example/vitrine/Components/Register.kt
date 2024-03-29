package com.example.vitrine.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vitrine.Data.UserData
import com.example.vitrine.Entities.User
import com.example.vitrine.R

@Composable
fun Register(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmedPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var showEmptyFieldError by remember { mutableStateOf(false) }
    var showInvalidEmailError by remember { mutableStateOf(false) }
    var showUsernameExistedError by remember { mutableStateOf(false) }
    var showEmailExistedError by remember { mutableStateOf(false) }


    val userData = UserData.users

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logohd),
                contentDescription = "Logo",
                modifier = Modifier.size(230.dp)
            )

            Text(
                text = "Register",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = if (passwordVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) {
                        Icon(
                            imageVector = if (passwordVisible) {
                                Icons.Filled.Visibility
                            } else {
                                Icons.Filled.VisibilityOff
                            },
                            contentDescription = "Toggle Password Visibility"
                        )
                    }
                }
            )

            TextField(
                value = confirmedPassword,
                onValueChange = { confirmedPassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = if (passwordVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Validation
                    showEmptyFieldError = username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()
                    showInvalidEmailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

                    if (!showEmptyFieldError && !showInvalidEmailError && password == confirmedPassword) {

                        val isUserExisted = userData.find {it.username == username}
                        if(isUserExisted != null ){
                            showUsernameExistedError = true
                        }
                        val isEmailExisted = userData.find {it.email == email}
                        if(isEmailExisted != null){
                            showEmailExistedError = true
                        }

                        if(!showUsernameExistedError && !showEmailExistedError){
                            val user = User(username, email, password )
                            userData.add(user)
                            navController.navigate("login")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Register")
            }

            if (showEmptyFieldError) {
                Text(
                    text = "Please fill in all fields",
                    color = Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                showEmptyFieldError = false
            }

            if (showInvalidEmailError) {
                Text(
                    text = "Please enter a valid email",
                    color = Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                showInvalidEmailError = false
            }

            if (showEmailExistedError) {
                Text(
                    text = "Email Already in use",
                    color = Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                showEmailExistedError = false
            }

            if (showUsernameExistedError) {
                Text(
                    text = "Userame Already in use",
                    color = Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                showUsernameExistedError = false
            }

            if (password != confirmedPassword) {
                Text(
                    text = "Passwords do not match",
                    color = Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Already have an account? Sign in",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { navController.navigate("login") }
            )
        }
    }
}
