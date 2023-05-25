package org.tlc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ApiGatewayApplication{
    public static void main(String[] args){
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
