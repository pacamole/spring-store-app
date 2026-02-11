package com.example.spring_store.presentation.home

import com.example.spring_store.domain.model.Product

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val products: List<Product>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}