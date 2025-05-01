package com.grpc.demo.media.repository;

import com.grpc.demo.media.repository.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, String> {

    List<Media> getMediaByProductIdIn(List<String> productId);

}
