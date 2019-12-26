package com.neu.assigment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.neu.assigment.service.mapper")
public class AssigmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssigmentApplication.class, args);
    }

}
