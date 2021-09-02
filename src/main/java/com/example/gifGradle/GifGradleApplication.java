package com.example.gifGradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GifGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GifGradleApplication.class, args);
	}

}
