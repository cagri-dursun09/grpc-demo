package com.grpc.demo.product.controller;

import com.grpc.demo.product.dto.ProductDto;
import com.grpc.demo.product.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{name}")
    public List<ProductDto> findByName(@PathVariable String name) {
        return productService.findByName(name);
    }
}
