package com.revature.ers.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
	Employee getByUsernameAndPassword(String username, String password);
}
