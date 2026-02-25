package com.example.spring_store.presentation.detail

import androidx.lifecycle.ViewModel
import com.example.spring_store.data.repository.ProductRepository
import com.example.spring_store.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

public class DetailViewModel : ViewModel() {
    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product.asStateFlow()

    fun loadProduct(id: Long) {
        val product: Product? = ProductRepository.gedProductById(id)
        _product.value = product
    }
}