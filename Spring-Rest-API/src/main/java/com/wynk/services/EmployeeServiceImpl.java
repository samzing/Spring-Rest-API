package com.wynk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wynk.dao.EmployeeDao;
import com.wynk.models.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getEmployees() {
		List<Employee> employees = employeeDao.getEmployees();
		return employees;
	}

	public Employee getEmployee(String employeeId) {
		Employee employee = employeeDao.getEmployee(employeeId);
		return employee;
	}
	
	public void deleteEmployee(Employee employee) {
		employeeDao.deleteEmployee(employee);
	}

	public void updateEmployee(Employee employee, String employeeId) {
		employeeDao.updateEmployee(employee,employeeId);
	}

	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

}
