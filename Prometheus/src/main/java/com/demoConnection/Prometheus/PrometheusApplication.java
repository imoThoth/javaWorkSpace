package com.demoConnection.Prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.demoConnection.Prometheus.*")
@EntityScan("com.demoConnection.Prometheus.*")
@EnableAutoConfiguration
@SpringBootApplication
public class PrometheusApplication {


	public static void main(String[] args) {
		SpringApplication.run(PrometheusApplication.class, args);
	}

}
