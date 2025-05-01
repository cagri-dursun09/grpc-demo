package com.grpc.demo.product.service;

import com.grpc.demo.campaign.Campaign;
import com.grpc.demo.campaign.CampaignRequest;
import com.grpc.demo.campaign.CampaignResponse;
import com.grpc.demo.campaign.CampaignServiceGrpc;
import com.grpc.demo.product.dto.ProductDto;
import com.grpc.demo.product.repository.ProductRepository;
import com.grpc.demo.product.repository.model.Product;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final CampaignServiceGrpc.CampaignServiceBlockingStub campaignServiceBlockingStub;
    //TODO: Inject mediaServiceBlockingStub.newBlockingStub()



    public ProductService(ProductRepository productRepository, ManagedChannel campaignManagedChannel) {
        this.productRepository = productRepository;
        this.campaignServiceBlockingStub = CampaignServiceGrpc.newBlockingStub(campaignManagedChannel);
        //TODO: Assign mediaServiceBlockingStub
    }

    public List<ProductDto> findByName(String name) {
        List<Product> product = productRepository.findByName(name);

        CampaignResponse campaignProduct = campaignServiceBlockingStub
                .getCampaignRateById(
                        CampaignRequest.newBuilder()
                                .addAllProductId(product.stream()
                                        .map(Product::getId)
                                        .collect(Collectors.toList()))
                                .build());
        //TODO: Call mediaServiceBlockingStub.getMediaByProductId()

        return product
                .stream()
                .map(product1 -> ProductDto.from(product1,
                        campaignProduct.getCampaignList()
                                .stream()
                                .filter(campaign -> campaign.getProductId().equals(product1.getId()))
                                .map(Campaign::getRate)
                                .toList()
                        //TODO: set media[]
                ))
                .toList();

    }
}
