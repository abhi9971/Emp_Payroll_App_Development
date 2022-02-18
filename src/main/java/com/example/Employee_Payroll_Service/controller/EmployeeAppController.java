package com.example.Employee_Payroll_Service.controller;

import java.util.concurrent.atomic.AtomicInteger;

import com.example.Employee_Payroll_Service.employeemodel.EmployeeModel;
import com.example.Employee_Payroll_Service.employeemodel.WelcomeGreeting;
import com.example.Employee_Payroll_Service.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeAppController {

    @Autowired
    GreetingService service;

    private static final String template = "Hello %S %S";
    private static AtomicInteger counter =  new AtomicInteger();

    @GetMapping("")
    public WelcomeGreeting welcomeEmployee(@RequestBody EmployeeModel employee) {
        EmployeeModel newEmp = new EmployeeModel(employee);
        return new WelcomeGreeting(counter.incrementAndGet(),service.getWelcomeMsg(newEmp));
    }

    @PostMapping("/post")
    public WelcomeGreeting welcomeEmployeeAndToDataBase(@RequestBody EmployeeModel employee) {
        EmployeeModel newEmp = new EmployeeModel(employee);
        return new WelcomeGreeting(counter.incrementAndGet(),service.getWelcomeMsg(newEmp));
    }

    @PutMapping("/put")
    public WelcomeGreeting welcomeEmployeePutData(@RequestBody EmployeeModel employee) {
        EmployeeModel newEmp = new EmployeeModel(employee);
        return new WelcomeGreeting(employee.getId(),service.getWelcomeMsg(newEmp));
    }
}
