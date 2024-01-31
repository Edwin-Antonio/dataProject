package com.bankdata.securityAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SecurityAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityAdminApplication.class, args);
	}

}
