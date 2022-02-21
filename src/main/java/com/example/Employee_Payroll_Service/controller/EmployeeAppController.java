package com.example.Employee_Payroll_Service.controller;



import com.example.Employee_Payroll_Service.dto.EmployeeDTO;
import com.example.Employee_Payroll_Service.dto.ResponseDTO;
import com.example.Employee_Payroll_Service.employeemodel.EmployeeModel;

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
    @GetMapping("")
    public String welcomeEmployee() {
        return "Welcome to Employee Payroll App";
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> welcomeEmployeeAndToDataBase(@RequestBody EmployeeDTO dto) {
        ResponseDTO responseDTO = new ResponseDTO("Employee Added : ",service.creatDataBase(dto));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeByid(@PathVariable Integer id){
        return new ResponseEntity<EmployeeModel>(service.findEmployee(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeByid(@PathVariable Integer id,@RequestBody EmployeeDTO dto){
        ResponseDTO responseDTO = new ResponseDTO("Employee Updated : ",service.updateEmpolyeeByid(id, dto));
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployeeByid(@PathVariable Integer id){
        service.deleteEmployee(id);
        return "Employee data deleted";
    }
}
