package com.hr.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsvHrWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvHrWorkerApplication.class, args);
	}

}
