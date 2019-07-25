package com.wynk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.wynk.models.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Autowired
	private MongoOperations mongoOperation;
	
	final String COLLECTION = "Employee";
	
	public List<Employee> getEmployees() {
		return (List <Employee> ) mongoTemplate.findAll(Employee.class);
	}

	public Employee getEmployee(String employeeId) {
		Query query = new Query(Criteria.where("_id").is(employeeId));
        return mongoTemplate.findOne(query, Employee.class, COLLECTION);
	}

	public void deleteEmployee(Employee employee) {
		mongoTemplate.remove(employee);
	}

	public void updateEmployee(Employee employee, String employeeId) {
		employee.setId(employeeId);		
		mongoTemplate.save(employee);
	}

	public void createEmployee(Employee employee) {
		mongoTemplate.insert(employee);
	}

}
