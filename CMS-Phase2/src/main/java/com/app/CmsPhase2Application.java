package com.app;





import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import ch.qos.logback.classic.Logger;


@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.app.model"})
public class CmsPhase2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(CmsPhase2Application.class, args);
		Logger logger = (Logger) LoggerFactory.getLogger(CmsPhase2Application.class);
		logger.info("sadasd");

	}
	
	

}
