package com.example.Employee_Payroll_Service.controller;

import java.util.concurrent.atomic.AtomicInteger;

import com.example.Employee_Payroll_Service.employeemodel.EmployeeModel;
import com.example.Employee_Payroll_Service.employeemodel.WelcomeGreeting;
import com.example.Employee_Payroll_Service.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeAppController {

    @Autowired
    GreetingService service;

    @Autowired
    EmployeeModel employee;

    private static AtomicInteger counter =  new AtomicInteger();

    @GetMapping("")
    public WelcomeGreeting welcomeEmployee(@RequestBody EmployeeModel employee) {
        EmployeeModel newEmp = new EmployeeModel("StartOperation",employee);
        return new WelcomeGreeting(counter.incrementAndGet(),service.getWelcomeMsg(newEmp));
    }

    @PostMapping("/post")
    public WelcomeGreeting welcomeEmployeeAndToDataBase(@RequestBody EmployeeModel employee) {
        EmployeeModel newEmp = new EmployeeModel("StartOperation",employee);
        return new WelcomeGreeting(counter.incrementAndGet(),service.getWelcomeMsg(newEmp));
    }

    @PutMapping("/put")
    public WelcomeGreeting welcomeEmployeePutData(@RequestBody EmployeeModel employee) {
        EmployeeModel newEmp = new EmployeeModel("StartOperation",employee);
        return new WelcomeGreeting(employee.getId(),service.getWelcomeMsg(newEmp));
    }

    @PostMapping("/create")
    public String creatEmpPayrollDB(@RequestBody EmployeeModel employee) {
        service.creatDataBase(employee);
        return "Employee added";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeByid(@PathVariable Integer id){
        return new ResponseEntity<EmployeeModel>(service.findEmployee(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeByid(@PathVariable Integer id,@RequestBody EmployeeModel employee){
        return new ResponseEntity<EmployeeModel>(service.updateEmpolyeeByid(id,employee,"UpdateEmployee"),HttpStatus.OK);
    }
}
