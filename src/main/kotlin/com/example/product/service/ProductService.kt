package com.example.product.service

import com.example.product.domain.dto.req.ReqCreateProductDto
import com.example.product.domain.dto.req.ReqUpdateProductDto
import com.example.product.domain.dto.res.ResGetSingleProductDto

interface ProductService {

    fun getAllProducts(): List<ResGetSingleProductDto>

    fun getProductById(id: Int): ResGetSingleProductDto

    fun createProduct(req: ReqCreateProductDto): ResGetSingleProductDto

    fun updateProduct(id: Int, req: ReqUpdateProductDto): ResGetSingleProductDto

    fun deleteProduct(id: Int)
    fun deleteUserProduct() {
        TODO("Not yet implemented")
    }
}