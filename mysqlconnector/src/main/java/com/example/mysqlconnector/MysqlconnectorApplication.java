package com.example.mysqlconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.mysqlconnector.repository") 
public class MysqlconnectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlconnectorApplication.class, args);
	}

}
