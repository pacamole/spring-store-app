package com.example.spring_store.presentation.cart

import androidx.lifecycle.ViewModel
import com.example.spring_store.data.repository.CartRepository
import com.example.spring_store.domain.model.CartItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartViewModel : ViewModel() {
    val cartItems: StateFlow<List<CartItem>> = CartRepository.cartItems;

    }