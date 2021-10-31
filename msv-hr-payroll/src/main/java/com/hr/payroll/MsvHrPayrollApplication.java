package com.hr.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsvHrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvHrPayrollApplication.class, args);
	}

}
