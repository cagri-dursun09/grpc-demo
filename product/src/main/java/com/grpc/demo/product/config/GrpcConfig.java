package com.grpc.demo.product.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcConfig {

    @Bean
    public ManagedChannel campaignManagedChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 9892)
                .usePlaintext()
                .build();
    }

    //TODO: Define ManagedChannel bean for media grpc service
    @Bean(name = "mediaManagedChannel")
    public ManagedChannel mediaManagedChannel() {
        return ManagedChannelBuilder
                .forAddress("localhost", 9893)
                .usePlaintext()
                .build();
    }
}
