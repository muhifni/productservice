package com.example.product.rest

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "usermanagementservice" )
interface UserManagementClient {
    // GET USER BY ID
    fun getUserByID(
//        @PathVariable
    )
}