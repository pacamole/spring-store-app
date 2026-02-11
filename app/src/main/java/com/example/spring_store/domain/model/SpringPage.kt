package com.example.spring_store.domain.model

data class SpringPage<T>(
    val content: List<T>,
    val totalPages: Int,
    val totalElements: Long,
    val Last: Boolean,
    val size: Int,
    val number: Int
)
