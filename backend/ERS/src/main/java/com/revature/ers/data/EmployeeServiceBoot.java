package com.revature.ers.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceBoot implements EmployeeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceBoot.class);
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Employee getEmployee(String username, String password) {
		Employee employee = employeeDAO.getByUsernameAndPassword(username, password);
		LOGGER.debug("*******get employee: " + username + " " + password + " - " + employee);		

		entityManager.detach(employee); // forces any change to require a login
		return employee;
	}
	
	@Override
	public Manager getManager(String username, String password) {
		Employee employee = getEmployee(username, password);
		if(employee.getManager() != null) {
			return null;
		}
		Manager manager = new Manager(employee);
		LOGGER.debug("*******get manager after if: " + username + " " + password + " - " + manager);		

		return manager;
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
