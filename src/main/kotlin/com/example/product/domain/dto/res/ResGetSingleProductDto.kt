package com.example.product.domain.dto.res

data class ResGetSingleProductDto(
    val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int,
    val description: String? = null
)
