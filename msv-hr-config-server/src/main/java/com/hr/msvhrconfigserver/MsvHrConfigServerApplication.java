package com.hr.msvhrconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MsvHrConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvHrConfigServerApplication.class, args);
	}

}
