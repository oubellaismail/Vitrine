package com.example.vitrine.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vitrine.Data.ProductData
import com.example.vitrine.Data.ProductData.tacos
import com.example.vitrine.Entities.Category
import com.example.vitrine.Entities.User
import com.example.vitrine.MainActivity

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TacosScreen(navController: NavController, mainActivity: MainActivity){
    val user: User? = mainActivity.user
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Takos Screen") },
                actions = {
                    IconButton(
                        onClick = {
                            if (user != null) {
                                navController.navigate("home/${user.username}")
                            }
                        }
                    ) {
                        Icon(Icons.Default.Home, contentDescription = "Home")
                    }
                    IconButton(
                        onClick = { navController.navigate("Profile") }
                    ) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    }
                    IconButton(
                        onClick = { navController.navigate("login") }
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        }
    )
    {
        LazyColumn(
            modifier = Modifier.padding(top = 40.dp)
        ) {
            items(tacos) { category ->
                TacosItem(category = category, navController = navController, mainActivity)
            }
        }
    }
}