package com.example.product.exception

class GlobalExceptionHandler {
    class DataNotFoundException(message: String) : RuntimeException(message)
}