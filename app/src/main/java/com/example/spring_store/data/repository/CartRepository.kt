package com.example.spring_store.data.repository

import com.example.spring_store.domain.model.CartItem
import com.example.spring_store.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object CartRepository {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems = _cartItems.asStateFlow()

    fun addProduct(product: Product) {
        _cartItems.update { currentList ->
            val existingItem: CartItem? = currentList.find { it.product.id == product.id }

            if (existingItem != null) {
                currentList.map { item ->

                    if (item.product.id == product.id) {
                        println("Produto ${product.name} atualizado com quantidade ${ item.quantity + 1 }")
                        item.copy(quantity = item.quantity + 1)
                    }
                    else item


                }



            } else {
                currentList + CartItem(product = product, quantity = 1)
            }
        }

    }
}