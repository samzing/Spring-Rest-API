package com.wynk.dao;

import java.util.List;

import com.wynk.models.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	public Employee getEmployee(String employeeId);
	public void deleteEmployee(Employee employee); 
	public void updateEmployee(Employee employee, String employeeId);
	public void createEmployee(Employee employee);
}
