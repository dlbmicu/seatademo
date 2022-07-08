package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.example"},exclude = {DataSourceAutoConfiguration.class})
public class Launch {

    public static void main(String[] args) {
        SpringApplication.run(Launch.class, args);
    }

}
