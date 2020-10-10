package com.example.builddream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class BuilddreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuilddreamApplication.class, args);
    }

}
