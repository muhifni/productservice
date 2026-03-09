package com.example.product.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "mst_products")
class MasterProducts(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var price: Double,

    @Column(nullable = false)
    var stock: Int,

    @Column(nullable = false)
    var description: String? = null,

    @Column(nullable = false)
    val createdBy: String = "SYSTEM",

    @Column(nullable = false)
    var updatedBy: String = "SYSTEM",

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var isDeleted: Boolean = false,
)