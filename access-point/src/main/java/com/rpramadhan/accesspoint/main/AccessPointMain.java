package com.rpramadhan.accesspoint.main;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * @author rpramadhan
 * Enter point for AccessPointMain
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.rpramadhan.accesspoint.controller")
public class AccessPointMain {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AccessPointMain.class, args);
	}
	
	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
		RestTemplate rt = new RestTemplate();
		rt.setErrorHandler(new ResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				
			}
		});
        return rt;
    }

}
