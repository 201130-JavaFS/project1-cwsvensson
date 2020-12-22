package com.rev_cws.services;

import java.util.List;

import com.rev_cws.models.ErsUser;
import com.rev_cws.repos.UserDAO;
import com.rev_cws.repos.UserDAOImpl;

public class UserService {
	
	private UserDAO userDao = new UserDAOImpl();
	
	public List<ErsUser> letsSeeTheUsers() {
		System.out.println("Hitting letsSeeTheUsers inside UserService");
		return userDao.findAllUsers();
	}
}