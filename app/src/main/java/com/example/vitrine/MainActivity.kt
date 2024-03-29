package com.example.vitrine


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*

import androidx.compose.runtime.*

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vitrine.ui.theme.VitrineTheme
import androidx.compose.material.icons.*
import androidx.compose.material3.Text

import com.example.vitrine.Components.BurgerScreen
import com.example.vitrine.Components.DrinkScreen
import com.example.vitrine.Components.GlaceScreen
import com.example.vitrine.Components.Home
import com.example.vitrine.Components.Login
import com.example.vitrine.Components.PizzaScreen
import com.example.vitrine.Components.ProfileScreen
import com.example.vitrine.Components.Register
import com.example.vitrine.Components.TacosScreen
import com.example.vitrine.Data.UserData
import com.example.vitrine.Entities.Cart
import com.example.vitrine.Entities.Category
import com.example.vitrine.Entities.User

class MainActivity : ComponentActivity() {
    val cart = Cart()
    var user : User? = null
    val userData = UserData.users
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VitrineTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Login") {
                    composable(route = "Login") {
                        Login(navController){
                            navController.navigate("home/$it")
                        }
                    }

                    composable(route = "register"){
                        Register(navController)
                    }

                    composable(
                        route = "home/{username}") { arg ->
                        val username = arg.arguments?.getString("username")
                        user = userData.find { it.username == username }
                        user?.let {
                            Home(navController, it){
                                navController.navigate("category/$it")
                            }
                        }
                    }
                    composable(
                        route="Profile"

                    ){

                        ProfileScreen(navController, this@MainActivity)
                    }
                    composable (
                        route="category/{path}"
                    ){ arg ->
                        val path = arg.arguments?.getString("path")
                        when (path) {
                            "Pizza" -> PizzaScreen(navController = navController,this@MainActivity)
                            "Tacos" -> TacosScreen(navController = navController, this@MainActivity)
                            "Hamburger" -> BurgerScreen(navController = navController,this@MainActivity)
                            "Glace" -> GlaceScreen(navController = navController,this@MainActivity)
                            "Drink" -> DrinkScreen(navController = navController,this@MainActivity)
                            else -> {
                                Text(text = "Invalid route: $route")
                            }
                        }
                    }
                    composable(route = "logout"){
                        user = null
                        navController.navigate("login")
                    }
                }
            }
        }
    }
}


fun sendEmail(user : User, context: Context, cart : Cart) {
    val emailIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_EMAIL, arrayOf("admin@gmail.com"))
        putExtra(Intent.EXTRA_SUBJECT, "Purchase Notification")
        val emailContent = StringBuilder()
        emailContent.append("You've purchased the following items:\n\n")
        cart.getCartItemsForUser(user).forEach{ cartItem ->
            emailContent.append("- ${cartItem.category.name} x${cartItem.quantity}\n")
        }
        putExtra(Intent.EXTRA_TEXT, emailContent.toString())
    }
    context.startActivity(emailIntent)
}