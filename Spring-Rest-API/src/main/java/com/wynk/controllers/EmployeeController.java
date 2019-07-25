package com.wynk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wynk.models.Employee;
import com.wynk.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> FetchEmployees() {
		List<Employee> employees = employeeService.getEmployees();

		if (employees == null) {
			return new ResponseEntity<>(employees, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") String employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.deleteEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String employeeId,
			@RequestBody Employee employee) {
		Employee isExist = employeeService.getEmployee(employeeId);
		if (isExist == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		employeeService.updateEmployee(employee,employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}
