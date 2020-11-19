package com.example.builddream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan({"com.example.builddream.mapper"})
public class BuilddreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuilddreamApplication.class, args);
    }

}
