package com.qingguomama;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("com.qingguomama.dao")
//@ComponentScan(basePackages = {"com.qingguomama.*"})
public class QingguomamaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QingguomamaApplication.class, args);
    }

}

