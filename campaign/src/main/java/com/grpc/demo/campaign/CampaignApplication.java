package com.grpc.demo.campaign;

import com.grpc.demo.campaign.repository.CampaignRepository;
import com.grpc.demo.campaign.repository.model.Campaign;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CampaignApplication implements CommandLineRunner {
	private final CampaignRepository campaignRepository;

    public CampaignApplication(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }


    public static void main(String[] args) {
		SpringApplication.run(CampaignApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(campaignRepository.saveAll(List.of(
				new Campaign("1", 10.0),
				new Campaign("2", 20.0),
				new Campaign("1", 30.0),
				new Campaign("2", 40.0)
		)));
	}
}
