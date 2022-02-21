package com.example.Employee_Payroll_Service.repository;

import com.example.Employee_Payroll_Service.employeemodel.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeAppRepository extends JpaRepository<EmployeeModel, Integer> {

}