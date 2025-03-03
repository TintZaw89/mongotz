package com.mongodbtz.mongotz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MongoTZApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTZApplication.class, args);
	}

}
