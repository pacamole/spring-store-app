package com.example.spring_store.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.example.spring_store.data.remote.RetrofitClient
import com.example.spring_store.data.repository.ProductRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading

            try {
                val products = ProductRepository.getProducts()

                _uiState.value = HomeUiState.Success(products)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error("Falha: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}