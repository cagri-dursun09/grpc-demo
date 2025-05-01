package com.grpc.demo.campaign.service;

import com.grpc.demo.campaign.*;
import com.grpc.demo.campaign.repository.CampaignRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.logging.Logger;

@GrpcService
public class CampaignGrpcService extends CampaignServiceGrpc.CampaignServiceImplBase {

    private final Logger logger = Logger.getLogger(CampaignGrpcService.class.getName());
    private final CampaignRepository campaignRepository;


    public CampaignGrpcService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public void getCampaignRateById(CampaignRequest request,
                                    StreamObserver<CampaignResponse> responseObserver) {
        logger.info("gRPC Request is received: " + request);

        List<Campaign> response = campaignRepository
                .getCampaignByProductIdIn(request.getProductIdList())
                .stream()
                .map(campaign ->
                        Campaign.newBuilder()
                                .setCampaignId(campaign.getId())
                                .setProductId(campaign.getProductId())
                                .setRate(campaign.getRate() == null
                                        ? 0d
                                        : campaign.getRate()).build())
                .toList();

        responseObserver.onNext(
                CampaignResponse.newBuilder()
                        .addAllCampaign(response)
                        .build());

        responseObserver.onCompleted();

        logger.info("gRPC Response is sent: " + response);
    }
}
