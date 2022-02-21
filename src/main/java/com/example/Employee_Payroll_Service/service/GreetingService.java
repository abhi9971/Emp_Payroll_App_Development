package com.example.Employee_Payroll_Service.service;

import com.example.Employee_Payroll_Service.dto.EmployeeDTO;
import com.example.Employee_Payroll_Service.employeemodel.EmployeeModel;
import com.example.Employee_Payroll_Service.repository.EmployeeAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GreetingService {

    @Autowired
    EmployeeAppRepository repo;

    public EmployeeModel creatDataBase(EmployeeDTO dto) {
        EmployeeModel newEmployee = new EmployeeModel(dto);
        repo.save(newEmployee);
        return newEmployee;
    }

    public String getWelcomeMsg(EmployeeModel employee) {
        return "Welcome " + employee.getFirstName() + " " + employee.getLastName();
    }
    public EmployeeModel findEmployee(Integer id) {
        EmployeeModel newEmployeeModel= repo.getById(id);
        return newEmployeeModel;
    }
    public EmployeeModel updateEmpolyeeByid(Integer id, EmployeeDTO dto) {
        EmployeeModel newEmployeeModel = new EmployeeModel(id,dto);
        repo.save(newEmployeeModel);
        return newEmployeeModel;
    }
    public void deleteEmployee(Integer id) {
        repo.deleteById(id);
    }
}