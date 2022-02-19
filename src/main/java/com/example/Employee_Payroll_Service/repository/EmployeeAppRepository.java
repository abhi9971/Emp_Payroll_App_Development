package com.example.Employee_Payroll_Service.repository;

import com.example.Employee_Payroll_Service.employeemodel.EmployeeModel;

import java.util.Optional;

public interface EmployeeAppRepository extends JpaRepository<EmployeeModel, Integer>{

    
}
