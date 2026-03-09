package com.example.product.service

import com.example.product.domain.dto.res.ResGetUserDetailDto

interface UserService {

    fun getUserById(id: Int): ResGetUserDetailDto
}