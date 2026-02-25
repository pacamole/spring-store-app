package com.example.spring_store.domain.model

import java.math.BigDecimal

data class CartItem(
    val product: Product, val quantity: Int = 1
) {
    val subTotal: BigDecimal get() = product.price.multiply(BigDecimal(quantity))
}
