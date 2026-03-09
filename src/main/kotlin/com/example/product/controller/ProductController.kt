package com.example.product.controller

import com.example.product.domain.dto.req.ReqCreateProductDto
import com.example.product.domain.dto.req.ReqUpdateProductDto
import com.example.product.domain.dto.res.ApiResponse
import com.example.product.domain.dto.res.ResGetSingleProductDto
import com.example.product.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
    private val productService: ProductService
) {

    // GET /product/products
    @GetMapping
    fun getAllProducts(): ResponseEntity<ApiResponse<List<ResGetSingleProductDto>>> {
        val data = productService.getAllProducts()
        return ResponseEntity.ok(ApiResponse.success(data))
    }

    // GET /product/products/{id}
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Int): ResponseEntity<ApiResponse<ResGetSingleProductDto>> {
        val data = productService.getProductById(id)
        return ResponseEntity.ok(ApiResponse.success(data))
    }

    // POST /product/products
    @PostMapping
    fun createProduct(
        @Valid @RequestBody req: ReqCreateProductDto
    ): ResponseEntity<ApiResponse<ResGetSingleProductDto>> {
        val data = productService.createProduct(req)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ApiResponse.success(data, "Product created successfully"))
    }

    // PUT /product/products/{id}
    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: Int,
        @Valid @RequestBody req: ReqUpdateProductDto
    ): ResponseEntity<ApiResponse<ResGetSingleProductDto>> {
        val data = productService.updateProduct(id, req)
        return ResponseEntity.ok(ApiResponse.success(data, "Product updated successfully"))
    }

    // DELETE /product/products/{id}
    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Int): ResponseEntity<ApiResponse<Nothing>> {
        productService.deleteProduct(id)
        return ResponseEntity.ok(ApiResponse.success(null!!, "Product deleted successfully"))
    }
}