package com.slayerd.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(value = "USERSERVICE",configuration = LoadBalancerConfig.class)
public class BeanConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate template(){
        return new RestTemplate();
    }
}
