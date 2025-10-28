package com.fernandesdraw;

import com.fernandesdraw.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(EmployeeService employeeService) {
        return (String[] args) -> {
            employeeService.loadEmployeeData();
        };
    }

}
