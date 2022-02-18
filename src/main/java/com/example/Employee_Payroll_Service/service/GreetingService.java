package com.example.Employee_Payroll_Service.service;

import com.example.Employee_Payroll_Service.employeemodel.EmployeeModel;
import org.springframework.stereotype.Service;



@Service
public class GreetingService {

    public String getWelcomeMsg(EmployeeModel employee) {
        return "Welcome " + employee.getFirstName() + " " + employee.getLastName();
    }
}
