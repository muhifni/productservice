package com.example.product.repository

import com.example.product.domain.entity.MasterProductEntity // Sesuaikan dengan nama entity-mu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MasterProductRepository : JpaRepository<MasterProductEntity, Int> {
    // Kamu bisa menambahkan custom query di sini jika dibutuhkan nantinya
    // contoh: fun findByNameContainingIgnoreCase(name: String): List<MasterProductEntity>
}
