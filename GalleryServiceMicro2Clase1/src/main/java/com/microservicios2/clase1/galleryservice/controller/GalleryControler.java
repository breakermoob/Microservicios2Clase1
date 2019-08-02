package com.microservicios2.clase1.galleryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import com.microservicios2.clase1.galleryservice.model.Gallery;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/")
public class GalleryControler {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home(){
		return "Hola desde Gallery Service, estoy corriendo en el puerto: " + env.getProperty("local.server.port");
	}
	
	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping("/{id}")
	public Gallery getGallery(@PathVariable final int id) {
		
		Gallery gallery = new Gallery();
		gallery.setId(id);
		
		List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
		gallery.setImages(images);
		
		return gallery;
	}
	
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "Hola desde Gallery Service del admin, estoy corriendo en el puerto: " + env.getProperty("local.server.port");
	}
	
	//Retorna en caso de un fallo
	public Gallery fallback(int galleryId , Throwable hystrixCommand) {
		return new Gallery(galleryId);
	}
	
}
