package com.example.product.service.impl

import com.example.product.domain.dto.res.ResGetSingleProductDto
import com.example.product.repository.MasterProductRepository
import com.example.product.service.ProductService
import com.example.product.service.UserService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(
    private val masterProductRepository: MasterProductRepository,
    private val httpServletRequest: HttpServletRequest,
    private val userService: UserService
) : ProductService {
    override fun getProductById(id: Int): ResGetSingleProductDto {

        // Cari data product berdasarkan ID
        val productData = masterProductRepository.findById(id).orElseThrow {
            // Bisa diganti dengan DataNotFoundException buatanmu jika ada
            RuntimeException("Product with id $id not found")
        }

        // Mapping dari Entity ke DTO response
        return ResGetSingleProductDto(
            id = productData.id!!,
            name = productData.name,
            price = productData.price,
            quantity = productData.quantity
        )
    }
}
