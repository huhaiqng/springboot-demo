package com.hhq.uploadingfiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hhq.uploadingfiles.storage.StroageService;

@SpringBootApplication
public class UploadingfilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadingfilesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StroageService stroageService) {
		return (args) -> {
			stroageService.deleteAll();
			stroageService.init();
		};
	}
}
