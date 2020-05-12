package com.cg.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.AbstractEnvironment;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Lavam
 *
 */
@EnableSwagger2
@EnableDiscoveryClient
@SpringBootApplication
public class FlightServiceApplication {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		SpringApplication.run(FlightServiceApplication.class, args);
	}

}
