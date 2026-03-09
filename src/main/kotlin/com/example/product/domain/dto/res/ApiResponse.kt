package com.example.product.domain.dto.res

data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T, message: String = "Success"): ApiResponse<T> =
            ApiResponse(success = true, message = message, data = data)

        fun <T> error(message: String): ApiResponse<T> =
            ApiResponse(success = false, message = message, data = null)
    }
}