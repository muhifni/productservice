package com.example.product.rest

import com.example.product.domain.dto.res.ApiResponse
import com.example.product.domain.dto.res.ResGetUserDetailDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "usermanagementservice", url = "\${feign.client.usermanagement.url}")
interface UserManagementClient {

    @GetMapping("/users/{id}")
    fun getUserByID(@PathVariable id: Int): ResponseEntity<ApiResponse<ResGetUserDetailDto>>
}