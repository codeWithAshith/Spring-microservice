package com.codeWithAshith.microservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// add enable config server
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}
	
	// create a folder called - git-localconfig 
	// link it to the spring-cloud-config-server project by
	// Right click on project name -> Build path -> Link source -> choose git-localconfig 
	// In git-localconfig create properties file limits-service.properties 
	// Add, commit to local git

}
