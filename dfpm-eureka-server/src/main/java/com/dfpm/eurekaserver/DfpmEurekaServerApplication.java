package com.dfpm.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DfpmEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfpmEurekaServerApplication.class, args);
    }

}
