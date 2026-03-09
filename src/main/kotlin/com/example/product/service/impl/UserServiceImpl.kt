package com.example.product.service.impl

import com.example.product.domain.dto.res.ResGetUserDetailDto
import com.example.product.exception.DataNotFoundException
import com.example.product.rest.UserManagementClient
import com.example.product.service.UserService
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userManagementClient: UserManagementClient
) : UserService {

    @Cacheable(value = ["getUserById"], key = "#id")
    override fun getUserById(id: Int): ResGetUserDetailDto {
        val response = userManagementClient.getUserByID(id)
        val user = response.body?.data
            ?: throw DataNotFoundException("User with id $id not found")

        return ResGetUserDetailDto(
            userId = user.userId,
            fullName = user.fullName,
            roleName = user.roleName
        )
    }
}