package com.carbuybuy.carbuybuy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.carbuybuy.carbuybuy.mapper")
@MapperScan("com.carbuybuy.carbuybuy.admin.mapper")
public class CarbuybuyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbuybuyApplication.class, args);
    }

}
