package com.config.servercfn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServercfnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServercfnApplication.class, args);
	}

}
