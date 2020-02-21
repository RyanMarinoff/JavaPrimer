package com.revature.ers.data;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceBoot implements ManagerService {
	@Autowired
	private ManagerDAO managerDAO;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Manager getManager(String username, String password) {
		Manager manager = managerDAO.getByUsernameAndPassword(username, password);
		entityManager.detach(manager);
		return manager;
	}

	@Override
	public Manager getManagerById(Integer id) {
		Optional<Manager> om = managerDAO.findById(id);
		return om.isPresent() ? om.get() : null;
	}

	@Override 
	public Set<Manager> getManagers() {
		return new HashSet<>(managerDAO.findAll());
	}

	@Override
	public void deleteManager(Manager manager) {
		managerDAO.delete(manager);
		
	}

	@Override
	public void updateManager(Manager manager) {
		managerDAO.save(manager);
	}

	@Override
	public void newManager(Manager manager) {
		managerDAO.save(manager);
	}

}
