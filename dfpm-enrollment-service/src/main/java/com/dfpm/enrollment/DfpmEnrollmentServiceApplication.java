package com.dfpm.enrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DfpmEnrollmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DfpmEnrollmentServiceApplication.class, args);
    }

}
