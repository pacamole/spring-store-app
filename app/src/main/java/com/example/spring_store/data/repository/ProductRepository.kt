package com.example.spring_store.data.repository

import com.example.spring_store.data.remote.RetrofitClient
import com.example.spring_store.domain.model.Product

object ProductRepository {
    private var cachedProducts: List<Product>? = null

    suspend fun getProducts(forceRefresh: Boolean = false): List<Product> {
        if (cachedProducts !=null && !forceRefresh) {
            return cachedProducts!!
        }

        val page = RetrofitClient.api.getProducts()
        cachedProducts = page.content

        return cachedProducts!!
    }

    fun gedProductById(id: Long): Product? {
        println("🕵️ DEBUG REPO: Buscando ID $id. O cache tem ${cachedProducts?.size} itens.")
        return cachedProducts?.find { it.id == id }
    }
}