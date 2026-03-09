package com.example.product.repository

import com.example.product.domain.entity.MasterProducts
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MasterProductRepository : JpaRepository<MasterProducts, Int> {

    // Cari semua product yang belum dihapus
    fun findAllByIsDeletedFalse(): List<MasterProducts>

    // Cari product by ID yang belum dihapus
    fun findByIdAndIsDeletedFalse(id: Int): MasterProducts?

    // Cari product by nama (untuk validasi duplikat)
    fun findByNameAndIsDeletedFalse(name: String): MasterProducts?
}