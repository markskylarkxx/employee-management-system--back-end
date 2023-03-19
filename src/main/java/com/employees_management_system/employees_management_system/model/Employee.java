package com.employees_management_system.employees_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private Integer id;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String address;
    private String hobby;
    private int phoneNumber;

    @Enumerated(value = EnumType.STRING)
    private Grades grade;

   // @NotNull

    @Column(unique = true)
    private String userName;

    @JsonIgnore
    private String password;

    @Column(unique = true)
    private int registrationNumber;
    @ManyToOne
    private Department department;

    private String passport;





}
