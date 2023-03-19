
 package com.employees_management_system.employees_management_system.controller;

import com.employees_management_system.employees_management_system.dto.EmployeeRequest;
import com.employees_management_system.employees_management_system.model.Department;
import com.employees_management_system.employees_management_system.model.Employee;
import com.employees_management_system.employees_management_system.service.DepartmentService;
import com.employees_management_system.employees_management_system.service.EmployeeService;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

 @RestController
//@RequestMapping("/employees")
public class EmployeeController {
     @Autowired
     EmployeeService employeeService;

     @Autowired
     DepartmentService departmentService;

     @RequestMapping("/score")
     public String goHome(){
         return  "Home Page";
     }

     private static final String UPLOAD_DIRECTORY = "C:\\uploads\\";

     @PostMapping("/create")
     public ResponseEntity addEmployee(@RequestPart("employee") EmployeeRequest request,
                                       @RequestPart("file") MultipartFile passport) {

         try {

             return  ResponseEntity.ok(employeeService.addEmployee(request, passport));
         } catch (Exception e) {
             e.printStackTrace();
         }

         return null;
     }


     @GetMapping("/department/employee")
     public List<Employee> getEmployeesByDepartment() {
         return null;

     }

     // GET EMPLOYEE BY ID

     @GetMapping("/get/{id}")

     public Optional<Employee> getEmployeeById(@PathVariable Integer id) {

         return employeeService.getEmployee(id);
     }

     @PutMapping("/update/{id}")
     public void updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
         employeeService.updateEmployee(employee, id);

     }

     @DeleteMapping("/delete/{id}")
     public void deleteEmployee(@PathVariable Integer id) {

         employeeService.deleteEmployee(id);
     }

// LIST OF EMPLOYEES IN A PARTICULAR DEPARTMENT
     @GetMapping("/departments/{id}")
     public ResponseEntity<List<Employee>> getEmployeeByDepartment(@PathVariable Integer id) throws IllegalAccessException {
         Department department = departmentService.findById(id).
                 orElseThrow(() -> new IllegalAccessException("Department not found"));

         return ResponseEntity.ok(employeeService.findAllEmployeesByDepartment(department));


     }
    // GET AN EMPLOYEE IN PARTICULAR DEPARTMENT
    @GetMapping("/{employeeId}/departments/{deptId}")
        public ResponseEntity<Optional<Employee>> findEmployeeByDepartment (@PathVariable Integer employeeId , @PathVariable Integer deptId )
            throws IllegalAccessException, NotFoundException {

             Department d = departmentService.
                      getById(deptId).orElseThrow(()-> new IllegalAccessException("No department available"));

            return ResponseEntity.ok(employeeService.findEmployeeByDepartment(d, employeeId));
    }


 }
