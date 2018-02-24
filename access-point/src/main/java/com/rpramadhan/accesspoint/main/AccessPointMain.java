package com.rpramadhan.accesspoint.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author rpramadhan
 * Enter point for AccessPointMain
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class AccessPointMain {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AccessPointMain.class, args);
	}

}
