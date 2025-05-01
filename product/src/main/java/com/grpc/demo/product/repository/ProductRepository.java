package com.grpc.demo.product.repository;

import com.grpc.demo.product.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByType(String type);

    List<Product> findByName(String name);
}
