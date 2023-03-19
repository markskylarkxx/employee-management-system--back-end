package com.employees_management_system.employees_management_system;

import com.employees_management_system.employees_management_system.resolver.PasswordGenerator;
import com.employees_management_system.employees_management_system.service.FileUploadService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeesManagementSystemApplication {

    public static void main(String[] args) {
        System.out.println(PasswordGenerator.getPassword() );

        SpringApplication.run(EmployeesManagementSystemApplication.class, args);


    }

}
