package com.grpc.demo.product;

import com.grpc.demo.product.repository.ProductRepository;
import com.grpc.demo.product.repository.model.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

	private final ProductRepository productRepository;

    public ProductApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args){
		System.out.println(productRepository.saveAll(List.of(
				new Product("1", "p1", "p1"),
				new Product("2", "p2", "p2"))));
	}
}
