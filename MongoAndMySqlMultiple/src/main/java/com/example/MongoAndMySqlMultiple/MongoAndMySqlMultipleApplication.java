package com.example.MongoAndMySqlMultiple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MongoAndMySqlMultipleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoAndMySqlMultipleApplication.class, args);
	}
}
