package com.grpc.demo.product.repository.model

import jakarta.persistence.*

@Entity
@Table(name = "products")
data class Product @JvmOverloads constructor(
        @Id
        val id: String? = "",
        val name: String?,
        val type: String?
)