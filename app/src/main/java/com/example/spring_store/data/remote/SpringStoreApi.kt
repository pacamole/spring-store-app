package com.example.spring_store.data.remote

import com.example.spring_store.domain.model.Product
import com.example.spring_store.domain.model.SpringPage
import retrofit2.http.GET
import retrofit2.http.Query

public interface SpringStoreApi {

    @GET("api/products")
    suspend fun getProducts(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "name,asc"
    ): SpringPage<Product>


}