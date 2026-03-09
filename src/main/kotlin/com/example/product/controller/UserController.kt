package com.example.product.controller

import com.example.product.domain.dto.res.ApiResponse
import com.example.product.domain.dto.res.ResGetUserDetailDto
import com.example.product.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    // GET /product/users/{id}
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Int): ResponseEntity<ApiResponse<ResGetUserDetailDto>> {
        val data = userService.getUserById(id)
        return ResponseEntity.ok(ApiResponse.success(data))
    }
}