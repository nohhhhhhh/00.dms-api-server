package com.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DmsApiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmsApiServerApplication.class, args);
    }
}
