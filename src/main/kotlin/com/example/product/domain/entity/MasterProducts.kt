package com.example.product.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column

@Entity
@Table(name = "mst_products")
class MasterProducts (
    @Id
    @GeneratedValue(GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var price: String,

    @Column
    var stock: Int,

    @Column
    val createdBy: String = "SYSTEM",

    @Column(nullable = false)
    var isDeleted: Boolean = false,
)