package com.employees_management_system.employees_management_system.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@NotNull
@Entity
@ToString
public class Department {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
     private String nameOfDepartment;
    private  String headOfDepartment;
    private String jobDescription;
   @OneToMany
    private List<Employee> employee;

}
