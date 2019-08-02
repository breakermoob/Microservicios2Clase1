package com.microservicios2.clase1.zuulGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulMicro2Clase1Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulMicro2Clase1Application.class, args);
	}

}
