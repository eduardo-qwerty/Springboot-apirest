package com.jonathaneduardo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		//System.out.println("password: " + new BCryptPasswordEncoder().encode("12345"));
		SpringApplication.run(CrudApplication.class, args);
	}
}
