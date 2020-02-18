package com.revature.rmarinoff.ersback.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee")
	@SequenceGenerator(name="employee", sequenceName="employee_seq", allocationSize=1)
	private Integer id;
	private String username;
	private String password;
	private String email;
	@Column(name = "fname")
	private String first;
	@Column(name = "lname")
	private String lname;
	
	private Employee manager;
}
