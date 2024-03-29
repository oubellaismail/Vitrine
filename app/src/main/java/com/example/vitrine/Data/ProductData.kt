package com.example.vitrine.Data

import com.example.vitrine.Entities.Category
import com.example.vitrine.R

object ProductData {

    val categories = listOf(
        Category("Pizza", R.drawable.pizza, 10.99),
        Category("Tacos", R.drawable.tacos, 8.99),
        Category("Hamburger", R.drawable.hamburger, 6.99),
        Category("Drink", R.drawable.coca, 6.99),
        Category("Glace", R.drawable.glass3, 6.99)
    )

    val Pizza = listOf(
        Category("Margerita", R.drawable.margerita, 10.99),
        Category("Mozzarella", R.drawable.mozzarella, 8.99),
        Category("pepperoni", R.drawable.pepperoni, 6.99),
        Category("Margerita", R.drawable.pizza, 10.99),
        Category("Mozzarella", R.drawable.mozzarella, 8.99),
        Category("Margerita", R.drawable.margerita, 10.99),
        Category("Mozzarella", R.drawable.mozzarella, 8.99)
    )

    val tacos = listOf(
        Category("tacos", R.drawable.tacos, 10.99),
        Category("taco1", R.drawable.tacos1, 8.99),
        Category("tacos4", R.drawable.tacos4, 6.99),
        Category("tacos", R.drawable.tacos, 10.99),
        Category("tacos1", R.drawable.tacos1, 8.99),
        Category("tacos4", R.drawable.tacos4, 10.99)


    )

    val burger = listOf(
        Category("hamburger", R.drawable.hamburger, 10.99),
        Category("Turkey Burger", R.drawable.turkeyburger, 8.99),
        Category("burger", R.drawable.burgert, 6.99),
        Category("ChessBurger", R.drawable.cheeseburger, 10.99),
        Category("lamburger", R.drawable.lambburger, 8.99),
        Category("burger2", R.drawable.burger2, 10.99)


    )

    val glace = listOf(
        Category("glace", R.drawable.glace3, 10.99),
        Category("glace1 ", R.drawable.chocoloat, 8.99),
        Category("glace2", R.drawable.glace4, 6.99),
        Category("choclate", R.drawable.glace2, 10.99),
        Category("vanila", R.drawable.glace5, 8.99),
        Category("glace3", R.drawable.glass2, 10.99)


    )

    val drink = listOf(
        Category("Coca-Cola", R.drawable.coca, 10.99),
        Category("Fanta", R.drawable.fanta, 8.99),
        Category("Hawaiian Punch", R.drawable.hawai, 6.99),
        Category("Mixed Juice", R.drawable.mixed, 10.99),
        Category("Orange Juice", R.drawable.orange, 8.99),
        Category("Pomegranate Juice", R.drawable.poms, 10.99)
    )
}