package com.wcy.change;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wcy.change.mapper")
public class ChangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChangeApplication.class, args);
    }

}
