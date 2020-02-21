package com.revature.ers.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserDAO<T extends User> extends JpaRepository<T, Integer> {
	T getByUsernameAndPassword(String username, String password);
}