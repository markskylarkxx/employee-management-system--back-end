package com.employees_management_system.employees_management_system.controller;

import com.employees_management_system.employees_management_system.model.Department;
import com.employees_management_system.employees_management_system.model.Employee;
import com.employees_management_system.employees_management_system.service.DepartmentService;
import com.employees_management_system.employees_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/department ")

    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);

    }

    //  Get all employees in a particular department
//    @GetMapping("/departments/{id}/employees")
//    public List<Employee> getEmployeeByDepartment(@PathVariable Integer id){
//Optional<Department> department = departmentService.findById(id);
//    if (!department.isPresent()){
//       //throw error
//        throw  new RuntimeException("No employee present");
//    }else
//        return
//
//    }


    @GetMapping("/department/{id}")
    public Department getDepartmentId(@PathVariable Integer id){

        return  departmentService.getDepartmentById(id);
    }
   @PutMapping("/department/{id}")

    public void updateDepartment(@PathVariable Integer id, @RequestBody Department department){
        departmentService.updateDepartment(id, department);
   }


}
