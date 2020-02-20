package com.revature.ers.data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
	//ID, USERNAME, PASSWORD, EMAIL, FNAME, LNAME, MANAGER_ID
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee")
	@SequenceGenerator(name = "employee", sequenceName = "employee_seq", allocationSize = 1)
	private Integer id;
	private String username;
	private String password;
	private String email;
	@Column(name = "fname")
	private String first;
	@Column(name = "lname")
	private String last;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private Employee manager;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer id) {
		super();
		this.id = id;
	}
	public Employee(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Employee(Integer id, String username, String password, String email, String first, String last,
			Employee manager) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.first = first;
		this.last = last;
		this.manager = manager;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, first, id, last, manager, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(first, other.first) && Objects.equals(id, other.id)
				&& Objects.equals(last, other.last) && Objects.equals(manager, other.manager)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append(", first=");
		builder.append(first);
		builder.append(", last=");
		builder.append(last);
		builder.append(", manager=");
		builder.append(manager);
		builder.append("]");
		return builder.toString();
	}
	
	
}
