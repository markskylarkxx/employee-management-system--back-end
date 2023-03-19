package com.employees_management_system.employees_management_system.service;

import com.employees_management_system.employees_management_system.model.Department;
import com.employees_management_system.employees_management_system.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {



    @Autowired
    DepartmentRepository departmentRepository;
 

   

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }


    public void updateDepartment(Integer id, Department department) {

     departmentRepository.save(department);

    }


    public Department getDepartmentById(Integer id) {
        Optional<Department> optional = departmentRepository.findById(id);
        Department department = null;
        if (optional.isPresent()){
            department = optional.get();
        }else {
            throw  new RuntimeException("department not found for id " + id);
        }
        return  department;
    }


    public Optional<Department> findById(Integer id) {
        return departmentRepository.findById(id);
    }


    public Optional<Department> getById(Integer id) {
        return  departmentRepository.findById(id);
    }
}
