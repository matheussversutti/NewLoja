package com.tool.eloja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan(basePackages="com.tool.eloja.models")

@SpringBootApplication
public class ElojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElojaApplication.class, args);
	}

}