package com.grpc.demo.media.repository.model

import jakarta.persistence.*

@Entity
@Table(name = "media")
data class Media @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String? = null,
        val productId: String,
        val url: String?
)