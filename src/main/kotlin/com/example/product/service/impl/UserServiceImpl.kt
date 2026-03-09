package com.example.product.service.impl

import com.example.product.domain.dto.res.ResGetUserDetailDto
import com.example.product.rest.UserManagementClient
import com.example.product.service.UserService
import jakarta.persistence.Cacheable

class UserServiceImpl (
    private val userManagementClient: UserManagementClient
): UserService {
    @Cacheable("getUserById")
    override fun getUserById(id: Int): ResGetUserDetailDto {
        val user = userManagementClient.getUserByID().body!!.data!!
        return ResGetUserDetailDto(
            userId = user.userId,
            fullName = user.fullName,
            roleName = user.roleName
        )
    }
}