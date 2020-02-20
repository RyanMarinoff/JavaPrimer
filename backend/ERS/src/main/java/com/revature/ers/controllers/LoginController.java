package com.revature.ers.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.ers.data.Employee;
import com.revature.ers.data.EmployeeService;
import com.revature.ers.data.LoginInfo;
import com.revature.ers.data.Manager;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/login")
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ResponseEntity<LoginInfo> login(HttpSession session) {
		LoginInfo loggedUser = (LoginInfo) session.getAttribute("loggedUser");
		if(loggedUser == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(loggedUser);
	}
	
	@PostMapping
	public ResponseEntity<LoginInfo> login(@RequestParam("user") String username, 
			@RequestParam("password") String password, HttpSession session) {
		LOGGER.debug("*******get manager statements: " + username + " " + password + " - " + session);		
        Manager manager = employeeService.getManager(username,  password);
		Employee employee = null;
		LOGGER.debug("*******before work if statements: " + username + " " + password + " - " + session);		
		if(manager == null) {
			LOGGER.debug("****Within if manaager == null: " + username + " " + password + " - " + session);
			employee = employeeService.getEmployee(username, password);
		}
		if(employee==null && manager==null) {
			LOGGER.debug("****Within if employee==null and manager==null: " + username + " " + password + " - " + session);
			return ResponseEntity.status(401).build();
		}
		LOGGER.debug("*******after if statements: " + username + " " + password + " - " + session);
		LoginInfo loggedUser = new LoginInfo(employee, manager);
		session.setAttribute("loggedUser", loggedUser);
		LOGGER.debug("*******before return of logged user: " + username + " " + password + " - " + session);
		return ResponseEntity.ok(loggedUser);
	}
}
