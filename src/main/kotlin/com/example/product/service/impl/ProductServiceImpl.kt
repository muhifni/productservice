package com.example.product.service.impl

import com.example.product.domain.dto.req.ReqCreateProductDto
import com.example.product.domain.dto.req.ReqUpdateProductDto
import com.example.product.domain.dto.res.ResGetSingleProductDto
import com.example.product.domain.entity.MasterProducts
import com.example.product.exception.DataNotFoundException
import com.example.product.repository.MasterProductRepository
import com.example.product.service.ProductService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ProductServiceImpl(
    private val masterProductRepository: MasterProductRepository
) : ProductService {

    // ========================
    // GET ALL PRODUCTS
    // ========================
    override fun getAllProducts(): List<ResGetSingleProductDto> {
        return masterProductRepository.findAllByIsDeletedFalse()
            .map { it.toDto() }
    }

    // ========================
    // GET PRODUCT BY ID
    // ========================
    override fun getProductById(id: Int): ResGetSingleProductDto {
        val product = masterProductRepository.findByIdAndIsDeletedFalse(id)
            ?: throw DataNotFoundException("Product with id $id not found")

        return product.toDto()
    }

    // ========================
    // CREATE PRODUCT
    // ========================
    override fun createProduct(req: ReqCreateProductDto): ResGetSingleProductDto {
        // Validasi nama duplikat
        masterProductRepository.findByNameAndIsDeletedFalse(req.name)?.let {
            throw IllegalArgumentException("Product with name '${req.name}' already exists")
        }

        val newProduct = MasterProducts(
            name = req.name,
            price = req.price,
            stock = req.stock,
            description = req.description,
            createdBy = "SYSTEM",
            updatedBy = "SYSTEM"
        )

        val saved = masterProductRepository.save(newProduct)
        return saved.toDto()
    }

    // ========================
    // UPDATE PRODUCT
    // ========================
    override fun updateProduct(id: Int, req: ReqUpdateProductDto): ResGetSingleProductDto {
        val product = masterProductRepository.findByIdAndIsDeletedFalse(id)
            ?: throw DataNotFoundException("Product with id $id not found")

        // Validasi nama duplikat (kecuali milik diri sendiri)
        masterProductRepository.findByNameAndIsDeletedFalse(req.name)?.let {
            if (it.id != id) throw IllegalArgumentException("Product with name '${req.name}' already exists")
        }

        product.apply {
            name = req.name
            price = req.price
            stock = req.stock
            description = req.description
            updatedBy = "SYSTEM"
            updatedAt = LocalDateTime.now()
        }

        val updated = masterProductRepository.save(product)
        return updated.toDto()
    }

    // ========================
    // DELETE PRODUCT (soft delete)
    // ========================
    override fun deleteProduct(id: Int) {
        val product = masterProductRepository.findByIdAndIsDeletedFalse(id)
            ?: throw DataNotFoundException("Product with id $id not found")

        product.isDeleted = true
        product.updatedAt = LocalDateTime.now()
        masterProductRepository.save(product)
    }

    // ========================
    // HELPER: Entity -> DTO
    // ========================
    private fun MasterProducts.toDto() = ResGetSingleProductDto(
        id = this.id!!,
        name = this.name,
        price = this.price,
        stock = this.stock,
        description = this.description
    )
}