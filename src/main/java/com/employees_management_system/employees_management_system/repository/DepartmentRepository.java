package com.employees_management_system.employees_management_system.repository;

import com.employees_management_system.employees_management_system.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface DepartmentRepository  extends CrudRepository<Department, Integer> {

}
