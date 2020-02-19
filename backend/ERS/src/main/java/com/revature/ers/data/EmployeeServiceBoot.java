package com.revature.ers.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceBoot implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee getEmployee(String username, String password) {
		Employee employee = employeeDAO.getByUsernameAndPassword(username, password);
		entityManager.detach(employee); // so that user cannot delete itself from database
		return employee;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDAO.getOne(id);
	}

	@Override
	public Set<Employee> getEmployees() {
		return new HashSet<>(employeeDAO.findAll());
	}

	@Override
	public void deleteEmployee(Employee employee) {
		employeeDAO.delete(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	public void newEmployee(Employee employee) {
		employeeDAO.save(employee);
	}

}
