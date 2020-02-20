package com.revature.ers.data;

public class Manager extends Employee {
	Manager(Employee employee) {
		this.setId(employee.getId());
		this.setUsername(employee.getUsername());
		this.setPassword(employee.getPassword());
		this.setEmail(employee.getEmail());
		this.setFirst(employee.getFirst());
		this.setLast(employee.getLast());
	}
}
