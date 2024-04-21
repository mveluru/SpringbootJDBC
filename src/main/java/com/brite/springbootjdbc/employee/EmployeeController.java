package com.brite.springbootjdbc.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/emp")
public class EmployeeController {

    private EmployeeService empService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.empService = employeeService;
    }

    @GetMapping(path = "message")
    public @ResponseBody String empmessage() {
        return "Employee Test Message on port 8084";
    }

    @GetMapping(path = "/empid/{id}")
    public @ResponseBody Optional<Employee> findEmployeeById(@PathVariable Integer id) {
        return Optional.ofNullable(this.empService.findEmployeeById(id));

    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAllEmployee() {
        return empService.getemployees();
    }

    @PutMapping(path = "/update")
    public @ResponseBody String updateEmployee(@RequestBody Employee employee) {
        return empService.updateEmployee(employee);
    }


    @PostMapping(path = "/newemp")
    public @ResponseBody String addEmployee(@RequestBody Employee employee) {
        return empService.addEmployee(employee);
    }


    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteEmployee(@PathVariable Integer id) {
        return empService.deleteEmployee(id);
    }


}
