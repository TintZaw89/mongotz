package com.mongodbtz.mongotz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MongoTZApplication {
	private static final Logger logger = LogManager.getLogger(MongoTZApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MongoTZApplication.class, args);
		logger.trace("We've just started Movie API!");
		logger.debug("We've just started Movie API!");
		//logger.info("We've just started Movie API!");
		//logger.warn("We've just started Movie API!");
		//logger.error("We've just started Movie API!");
		//logger.fatal("We've just started Movie API!");
	}

}
