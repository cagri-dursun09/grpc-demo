package com.grpc.demo.media;

import com.grpc.demo.media.repository.model.Media;
import com.grpc.demo.media.repository.MediaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MediaApplication implements CommandLineRunner{
	private final MediaRepository mediaRepository;

    public MediaApplication(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(MediaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(mediaRepository.saveAll(List.of(
				new Media("1", "media-url-1"),
				new Media("2", "media-url-2"),
				new Media("1", "media-url-3"),
				new Media("2", "media-url-4")
		)));
	}
}
