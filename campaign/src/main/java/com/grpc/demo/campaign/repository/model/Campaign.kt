package com.grpc.demo.campaign.repository.model

import jakarta.persistence.*

@Entity
@Table(name = "campaign")
data class Campaign @JvmOverloads constructor(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        val id: String? = null,
        val productId: String,
        val rate: Double?
)