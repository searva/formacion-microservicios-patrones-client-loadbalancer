package com.example.howtodoinjava.springhystrixschoolservice;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient("student-service")
public class StudentServiceConfiguration {
	
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    	return restTemplateBuilder
    			.setConnectTimeout(300)
    			.setReadTimeout(1000)
    			.build();
    }

}
