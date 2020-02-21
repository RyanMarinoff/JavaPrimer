package com.revature.ers.data;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class Employee extends User {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id")
	private Manager manager;

	public Employee() {
		super();
	}
	
	public Employee(Integer id) {
		super(id);
	}

	public Employee(Integer id, String username, String password) {
		super(id, username, password);
	}
	
	public Employee(Integer id, String username, String password, String email, String first, String last, Manager manager) {
		super(id, username, password, email, first, last);
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(manager);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(manager, other.manager);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");		
		builder.append(this.getId());
		builder.append(", username=");
		builder.append(this.getUsername());
		builder.append(", password=");
		builder.append(this.getPassword());
		builder.append(", email=");
		builder.append(this.getEmail());
		builder.append(", first=");
		builder.append(this.getFirst());
		builder.append(", last=");
		builder.append(this.getLast());
		builder.append(", manager=");
		builder.append(manager);
		builder.append("]");
		return builder.toString();
	}

	
}
