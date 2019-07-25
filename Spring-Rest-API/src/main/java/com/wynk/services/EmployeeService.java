package com.wynk.services;

import java.util.List;
import com.wynk.models.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public Employee getEmployee(String employeeId);
	public void deleteEmployee(Employee employee); 
	public void updateEmployee(Employee employee, String employeeId);
	public void createEmployee(Employee employee);
	
}
