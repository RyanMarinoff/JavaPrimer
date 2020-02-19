package com.revature.ers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ErsApplication {
	
	// TODO: Remove logger here
	private static final Logger LOGGER = LoggerFactory.getLogger(ErsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ErsApplication.class, args);
		
		// TODO: Remove logs here
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
	}

}
