package com.revature.ers.data;

import java.util.Objects;

public class LoginInfo {
	private Employee employee;
	private Manager manager;
	public LoginInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginInfo(Employee employee, Manager manager) {
		super();
		this.employee = employee;
		this.manager = manager;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employee, manager);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginInfo other = (LoginInfo) obj;
		return Objects.equals(employee, other.employee) && Objects.equals(manager, other.manager);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginInfo [employee=");
		builder.append(employee);
		builder.append(", manager=");
		builder.append(manager);
		builder.append("]");
		return builder.toString();
	}
	
	
}
