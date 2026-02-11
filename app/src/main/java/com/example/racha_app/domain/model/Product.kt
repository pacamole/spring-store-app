package com.example.spring_store.domain.model

import java.math.BigDecimal
import com.google.gson.annotations.SerializedName

data class Product(
    val id: Long,
    val name: String,
    val description: String,
    val price: BigDecimal, // GSON consegue converter BigDecimal automaticamente

    @SerializedName("stockQuantity")
    val stock: Int
)
