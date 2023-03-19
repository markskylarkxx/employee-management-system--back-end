package com.employees_management_system.employees_management_system.dto;

import com.employees_management_system.employees_management_system.model.Department;
import com.employees_management_system.employees_management_system.model.Employee;
import com.employees_management_system.employees_management_system.model.Grades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest{
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String address;
    private String hobby;
    private int phoneNumber;
    private Grades grade;
    private String userName;
    private int registrationNumber;
    private Integer deptId;
    private String passport;
}

