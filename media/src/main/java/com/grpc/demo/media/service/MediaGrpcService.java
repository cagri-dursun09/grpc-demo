package com.grpc.demo.media.service;

import com.grpc.demo.media.repository.MediaRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.logging.Logger;

//TODO: Implement gRPC Service extends MediaServiceGrpc.CampaignServiceImplBase
@GrpcService
public class MediaGrpcService {

    private final Logger logger = Logger.getLogger(MediaGrpcService.class.getName());
    private final MediaRepository mediaRepository;


    public MediaGrpcService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    //TODO: Implement override the gRPC methods, method should return MediaResponse in responseObserver
    /**
     * gRPC method to get media by productId
     *
     * @param request        the request containing the productId
     * @param responseObserver the response observer to send the response
     */
}
