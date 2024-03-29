package com.example.vitrine.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.vitrine.Entities.Category
import com.example.vitrine.MainActivity

@Composable
fun PizzaItem(category: Category, navController: NavController, mainActivity: MainActivity) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = category.image),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp)
        )
        Text(
            text = category.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "Price: $${category.price}",
            fontSize = 18.sp,
            color = Color.Gray
        )
        Button(
            onClick = { mainActivity.user?.let { mainActivity.cart.addToCart(it, category) } },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Buy")
        }
    }
}