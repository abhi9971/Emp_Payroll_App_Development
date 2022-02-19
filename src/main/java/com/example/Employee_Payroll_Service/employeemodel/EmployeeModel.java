package com.example.Employee_Payroll_Service.employeemodel;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class EmployeeModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String profilepic;
    private String department;
    private long salary;
    private LocalDate date;
    private String notes;


    public EmployeeModel() {
        super();
    }


    public EmployeeModel(Integer id, EmployeeModel employee,String operation) {
        super();
        this.id = id;
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.profilepic = employee.getLastName();
        this.department = employee.getDepartment();
        this.salary = employee.getSalary();
        this.date = employee.getDate();
        this.notes = employee.getNotes();
    }


    public EmployeeModel(Integer id, String firstName, String lastName, String profilepic, String department,
                         long salary, LocalDate date, String notes) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilepic = profilepic;
        this.department = department;
        this.salary = salary;
        this.date = date;
        this.notes = notes;
    }


    public EmployeeModel(String httpOperation,EmployeeModel employee) {
        super();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
    }


    public EmployeeModel(Integer id, EmployeeModel employee) {
        super();
        this.id = employee.id;
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();;
    }


    public EmployeeModel(EmployeeModel employee) {
        super();
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.profilepic = employee.getLastName();
        this.department = employee.getDepartment();
        this.salary = employee.getSalary();
        this.date = employee.getDate();
        this.notes = employee.getNotes();
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getProfilepic() {
        return profilepic;
    }
    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}