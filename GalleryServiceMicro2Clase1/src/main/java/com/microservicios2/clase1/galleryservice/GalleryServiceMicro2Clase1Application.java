package com.microservicios2.clase1.galleryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient		//Activa el eureka client
@EnableCircuitBreaker //Activa el circuit Breaker
@SpringBootApplication
public class GalleryServiceMicro2Clase1Application {

	public static void main(String[] args) {
		SpringApplication.run(GalleryServiceMicro2Clase1Application.class, args);
	}
	
	@Configuration
	class RestTemplateConfig{
		
		//Crea un Bean para restTemplate que llama los servicios
		@Bean
		@LoadBalanced
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	}
	

}
