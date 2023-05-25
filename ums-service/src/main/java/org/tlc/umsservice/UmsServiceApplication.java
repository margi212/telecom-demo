package org.tlc.umsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration
public class UmsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UmsServiceApplication.class, args);
    }

}
