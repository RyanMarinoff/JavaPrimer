package com.revature.ers.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.ers.data.Employee;
import com.revature.ers.data.EmployeeService;
import com.revature.ers.data.LoginInfo;
import com.revature.ers.data.Manager;
import com.revature.ers.data.ManagerService;

@Controller
@RequestMapping(value = "/login")
@CrossOrigin(origins="http://localhost:4200")
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ManagerService managerService;
	
	@GetMapping
	public ResponseEntity<LoginInfo> login(HttpSession session) {
		LoginInfo loggedUser = (LoginInfo) session.getAttribute("loggedUser");
		if(loggedUser == null)
			return ResponseEntity.status(401).build();
		return ResponseEntity.ok(loggedUser);
	}
	
	@PostMapping
	public ResponseEntity<LoginInfo> login(@RequestParam("user") String username, 
			@RequestParam("pass") String password, HttpSession session) {
        Manager manager = managerService.getManager(username, password);
        Employee employee = employeeService.getEmployee(username, password);
        
		if(employee==null && manager==null) {
			return ResponseEntity.status(401).build();
		}
		LoginInfo loggedUser = new LoginInfo(employee, manager);
		session.setAttribute("loggedUser", loggedUser);
		return ResponseEntity.ok(loggedUser);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.noContent().build();
	}
}
