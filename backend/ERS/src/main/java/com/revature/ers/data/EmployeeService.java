package com.revature.ers.data;

import java.util.Set;

public interface EmployeeService {
	public Employee getEmployee(String username, String password);
	public Employee getEmployeeById(Integer id);
	public Set<Employee> getEmployees();
	public void deleteEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void newEmployee(Employee employee);
}
