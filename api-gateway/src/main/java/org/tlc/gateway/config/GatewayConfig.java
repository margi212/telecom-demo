package org.tlc.gateway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayConfig {

    @LoadBalanced
    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }

}
