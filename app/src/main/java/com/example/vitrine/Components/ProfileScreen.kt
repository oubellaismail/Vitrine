package com.example.vitrine.Components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.vitrine.Entities.User
import com.example.vitrine.MainActivity
import com.example.vitrine.sendEmail

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController, mainActivity: MainActivity) {
    val user: User? = mainActivity.user
    val cartItems = mainActivity.user?.let { mainActivity.cart.getCartItemsForUser(it) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cart Page") },
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
                        onClick = { navController.navigate("logout") }
                    ) {
                        Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Cart Page", style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(16.dp))

            if (cartItems.isNullOrEmpty()) {
                Text("Your cart is empty", style = MaterialTheme.typography.bodySmall)
            } else {
                Text("Items in Cart:", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                cartItems.forEach { cartItem ->
                    Text("- ${cartItem.category.name} x${cartItem.quantity}")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { mainActivity.user?.let { it1 -> mainActivity.cart.getCartItemsForUser(it1) }  },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Buy")
                }
            }
        }
    }
}



//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ProfileScreen(navController: NavController, mainActivity: MainActivity) {
//    val user : User?= mainActivity.user
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text("Cart Page") },
//                actions = {
//                    IconButton(
//                        onClick = {
//                            if (user != null) {
//                                navController.navigate("home/${user.username}")
//                            }
//                        }
//                    ) {
//                        Icon(Icons.Default.Home, contentDescription = "Home")
//                    }
//                    IconButton(
//                        onClick = { navController.navigate("Profile")}
//                    ) {
//                        Icon(Icons.Default.Person, contentDescription = "Profile")
//                    }
//                    IconButton(
//                        onClick = { navController.navigate("logout")}
//                    ) {
//                        Icon(Icons.AutoMirrored.Filled.ExitToApp, contentDescription = "Logout")
//                    }
//                }
//            )
//        }
//    ){
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(40.dp)
//        ) {
//            Spacer(modifier = Modifier.height(100.dp))
//            Text("Cart Page")
//            Spacer(modifier = Modifier.height(16.dp))
//            Text("Items in Cart:")
//            mainActivity.user?.let { it1 ->
//                mainActivity.cart.getCartItemsForUser(it1).forEach { cartItem ->
//                    Text("- ${cartItem.category.name} x${cartItem.quantity}")
//                }
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(
//                onClick = { mainActivity.user?.let { it1 -> mainActivity.cart.getCartItemsForUser(it1) } },
//                modifier = Modifier.align(Alignment.CenterHorizontally)
//            ) {
//                Text("Buy")
//            }
//        }
//    }
//}