package com.revature.ers.data;

import java.util.Set;

public interface ManagerService {
	public Manager getManager(String username, String password);
	public Manager getManagerById(Integer id);
	public Set<Manager> getManagers();
	public void deleteManager(Manager manager);
	public void updateManager(Manager manager);
	public void newManager(Manager manager);
}
