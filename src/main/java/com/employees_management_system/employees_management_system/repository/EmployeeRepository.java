package com.employees_management_system.employees_management_system.repository;

import com.employees_management_system.employees_management_system.model.Department;
import com.employees_management_system.employees_management_system.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

   // List<Employee> findEmployeeByAddress(String address);
   //select d from Department d;

    @Query("select e from Employee e where e.department = :dept")
    List<Employee> findEmployeesByDept(@PathParam("dept") Department dept);


    @Query("select  e from  Employee  e where e.id = :id and e.department = :dept")
    Optional < Employee> findEmployeeByDept(@PathParam("dept") Department dept, @PathParam("id") Integer id);
//
//    @Query("select  e from  Employee  e where e.id = :id and e.department = :depts")
//    Optional < Employee> findEmployeeByDepts(@PathParam("depts") Department dept, @PathParam("id") Integer id);


}
