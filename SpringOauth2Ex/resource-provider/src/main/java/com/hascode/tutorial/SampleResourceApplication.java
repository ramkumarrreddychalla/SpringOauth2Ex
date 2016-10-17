package com.hascode.tutorial;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableResourceServer
public class SampleResourceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SampleResourceApplication.class, args);
	}

	@RequestMapping("/")
	public String securedCall() {
		return "success (id: " + UUID.randomUUID().toString().toUpperCase() + ")";
	}
	
	@RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
