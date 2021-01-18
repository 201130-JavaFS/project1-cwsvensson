package com.rev_cws.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rev_cws.models.ErsUser;
import com.rev_cws.repos.UserDAO;
import com.rev_cws.repos.UserDAOImpl;

public class UserService {
	
	private UserDAO userDao = new UserDAOImpl();
	
	public List<ErsUser> letsSeeTheUsers() {
		// System.out.println("Hitting letsSeeTheUsers inside UserService");
		return userDao.findAllUsers();
	}

	public ErsUser justTheSessionUser(HttpServletRequest userRequest) {
		// System.out.println("Hitting justTheSessionUser inside UserService");
		
		String thisUser = null;
		HttpSession thisSession = userRequest.getSession(false);
		if (thisSession != null) {
			thisUser = (String) thisSession.getAttribute("sessionUsername");
		}
		// System.out.println("Inside UserService - Username = " + thisUser);
		
		return userDao.findUserByUserName(thisUser);
	}
}