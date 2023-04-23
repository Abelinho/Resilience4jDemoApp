package com.abel.demouserdetailsfacade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DemouserdetailsfacadeApplication {

	//configure webclient bean for rest call
//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

	@Bean
//	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemouserdetailsfacadeApplication.class, args);
	}

}
