package com.ses.example.aws_ses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AwsSesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSesApplication.class, args);
	}

}
