package com.rev_cws.services;

//import java.util.List;

import com.rev_cws.models.ErsUser;
import com.rev_cws.repos.UserDAO;
import com.rev_cws.repos.UserDAOImpl;
import com.rev_cws.utils.EncryptDecrypt;

public class LoginService {

	private UserDAO userDao = new UserDAOImpl();

	public boolean login(String username, String password) {

		System.out.println("Hitting findUserByUserName inside LoginService");
		ErsUser oneUser = userDao.findUserByUserName(username);
		
		String foundPassword = oneUser.getUserPassword();
		System.out.println("LoginService: retrieved password = " + foundPassword);
		
		String encryptedPassword = "";
		try {
			encryptedPassword = EncryptDecrypt.encrypt(password);
			System.out.println("Checking against: '"+password+"' and '"+encryptedPassword+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (password.equals(foundPassword) || encryptedPassword.equals(foundPassword) ) {
			System.out.println("LoginService: Good password.");
			
			if (password.equals(foundPassword)) {
				System.out.println("LoginService.login - Trying to update non encrypted password");
				if (!(userDao.updatePassword(username, encryptedPassword))) {
					System.out.println("Warning - DB password not updated");
				}
			}
			return true;
		}
		return false;
	}

}