package com.example.product.domain.dto.res

import java.io.Serializable

data class ResGetSingleProductDto(
    val id: Int,
    val name: String,
    val price: Double,
    val stock: Int,
    val description: String? = null
) : Serializable