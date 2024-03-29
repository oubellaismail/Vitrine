package com.example.vitrine.Entities

class Cart {
    private val cartItems = mutableListOf<CartItem>()
    fun addToCart(user: User, item: Category) {
        val existingItem = cartItems.find { it.category == item && it.user == user }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            cartItems.add(CartItem(user, item))
        }
    }

    fun getCartItemsForUser(user: User): List<CartItem> =
        cartItems.filter { it.user == user }
}