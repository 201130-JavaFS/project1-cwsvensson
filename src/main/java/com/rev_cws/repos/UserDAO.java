package com.rev_cws.repos;

import java.util.List;

import com.rev_cws.models.ErsUser;


public interface UserDAO {

	public List<ErsUser> findAllUsers();
	public ErsUser findUserById(int id);
	public ErsUser findUserByUserName(String userName);
	public boolean updatePassword(String userName, String newPassword);
}
