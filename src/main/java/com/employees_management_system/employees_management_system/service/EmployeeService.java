package com.employees_management_system.employees_management_system.service;

import com.employees_management_system.employees_management_system.dto.EmployeeRequest;
import com.employees_management_system.employees_management_system.model.Department;
import com.employees_management_system.employees_management_system.model.Employee;
import com.employees_management_system.employees_management_system.repository.EmployeeRepository;
import com.employees_management_system.employees_management_system.util.PasswordUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentService departmentService;

    public List<Employee> getEmployeeByDepartment() {

        return (List<Employee>) employeeRepository.findAll();
    }


   public Optional <Employee> getEmployee(Integer id){
        return employeeRepository.findById(id);
   }

    public Employee addEmployee(EmployeeRequest request, MultipartFile passport) throws Exception {
        String imageUploadPath = FileUploadService.uploadFile(passport);

try {
    Department dept = departmentService.getDepartmentById(request.getDeptId());
    Employee employee = Employee.builder().address(request.getAddress()).dob(request.getDob()).gender(request.getGender())
            .grade(request.getGrade()).firstName(request.getFirstName()).hobby(request.getHobby()).lastName
                    (request.getLastName()).passport(imageUploadPath).phoneNumber(request.getPhoneNumber()).registrationNumber
                    (request.getRegistrationNumber()).userName(request.getUserName()).password(this.generatePassword()).department(dept).build();
    return employeeRepository.save(employee);
}catch (DataIntegrityViolationException e){
   e.getMessage();
}

       return Employee.builder().build();
        }



    public void updateEmployee(Employee employee, Integer id) {
        employeeRepository.save(employee);

    }

    public void deleteEmployee(Integer id) {

         employeeRepository.deleteById(id);
    }

    private String generatePassword() {
        PasswordUtils utils = new PasswordUtils();

        String pass = utils.getUppercaseChars(2).getLowercaseChars(2)
                .getSymbols(2).getDigits(2).shuffle().buildPassword();
        return pass;
    }

    public List<Employee>   findAllEmployeesByDepartment(Department department) {
        return employeeRepository.findEmployeesByDept(department);

    }


//    public Optional<Employee> findEmployeeByDepartment(Department d, Integer id)  {
//
//        return employeeRepository.findEmployeeByDept(d, id);
//    }



//    public Optional<Employee> findEmployeeByDepartment(Department d, Integer id) {
//
//        Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByDept(d, id);
//
//        if (optionalEmployee.isPresent()) {
//            return Optional.of(optionalEmployee.get());
//        } else {
//            throw new RuntimeException("No employee found for that department");
//
//        }
//
//    }
public Optional<Employee> findEmployeeByDepartment(Department d, Integer id) throws NotFoundException {
    Optional<Employee> optionalEmployee = employeeRepository.findEmployeeByDept(d, id);
    if (optionalEmployee.isPresent()){
        return employeeRepository.findEmployeeByDept(d, id);
    }else {
        throw  new NotFoundException("Employee not found in the department");
    }

  }
}
