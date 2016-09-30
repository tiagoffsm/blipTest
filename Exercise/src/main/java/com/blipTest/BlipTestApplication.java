package com.blipTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class BlipTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlipTestApplication.class, args);
    }

}
