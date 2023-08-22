package com.kleyber.SISGEO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SisgeoApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(SisgeoApplication.class, args);
	}
	
	public String PORT = System.getenv("PORT");
  
}
