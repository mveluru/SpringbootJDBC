package com.brite.springbootjdbc.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    protected String addEmployee(Employee employee){
        return employeeRepo.addEmployee(employee);
    }

    protected  Employee findEmployeeById(Integer id){
        return employeeRepo.getEmployeebyId(id);
    }

    protected List<Employee> getemployees(){
        return employeeRepo.getemployees();

    }

    protected String updateEmployee(Employee employee){
        return employeeRepo.updateEmploye(employee);
    }

    protected String deleteEmployee(Integer id){
        return employeeRepo.deleteEmployee(id);
    }



}
