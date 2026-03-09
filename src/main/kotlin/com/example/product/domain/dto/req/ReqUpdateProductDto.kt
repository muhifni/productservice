package com.example.product.domain.dto.req

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

data class ReqUpdateProductDto(

    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:NotNull(message = "Price is required")
    @field:Positive(message = "Price must be greater than 0")
    val price: Double,

    @field:NotNull(message = "Stock is required")
    @field:Min(value = 0, message = "Stock cannot be negative")
    val stock: Int,

    val description: String? = null
)