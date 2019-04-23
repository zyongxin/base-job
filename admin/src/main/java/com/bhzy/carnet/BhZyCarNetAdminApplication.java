package com.bhzy.carnet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bhzy.carenet.admin.mapper")
public class BhZyCarNetAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BhZyCarNetAdminApplication.class, args);
    }
}
