package com.grpc.demo.campaign.repository;

import com.grpc.demo.campaign.repository.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, String> {

    List<Campaign> getCampaignByProductIdIn(List<String> productId);
}
