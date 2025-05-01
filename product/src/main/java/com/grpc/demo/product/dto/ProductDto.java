package com.grpc.demo.product.dto;

import com.grpc.demo.product.repository.model.Product;

import java.util.List;

public record ProductDto (
    String id,
    String name,
    String type,
    List<Double> campaignRates

    //TODO: List String - mediaUrls

){
    public static ProductDto from(Product product, List<Double> campaignRates) {
        return new ProductDto(product.getId(), product.getName(), product.getType(), campaignRates);
    }}
