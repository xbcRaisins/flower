package com.xbc.flower.xbcflowerboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.xbc.flower.xbcflowerboot.dao"})
public class XbcFlowerBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(XbcFlowerBootApplication.class, args);
    }

}
