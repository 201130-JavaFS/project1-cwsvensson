package com.rev_cws.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev_cws.models.ErsUser;
import com.rev_cws.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	private UserRoleDAO userRoleDao = new UserRoleDAOImpl();

	@Override
	public List<ErsUser> findAllUsers() {
		
		// System.out.println("Hitting findAllUsers inside UserDAOImpl");
		try (Connection conn = ConnectionUtil.getConnection()) {

			//System.out.println("findAllUsers - Trying to get all users");
			String userSQL = "SELECT * FROM ers_user;";

			Statement statement = conn.createStatement();

			List<ErsUser> userList = new ArrayList<>();

			ResultSet userResult = statement.executeQuery(userSQL);
			//int cntUsers = 0;

			while (userResult.next()) {
				ErsUser oneUser = new ErsUser(userResult.getInt("user_id"), 
						                      userResult.getString("user_name"),
						                      userResult.getString("user_password"), 
						                      userResult.getString("user_fname"), 
						                      userResult.getString("user_lname"),
						                      userResult.getString("user_email"),
						                      null);
				if (userResult.getString("user_role_id") != null) {
					oneUser.setErsUserRoleId(userRoleDao.findRoleById(userResult.getString("user_role_id")));
				}
				//cntUsers++;
				userList.add(oneUser);
			}
			//System.out.println("findAllUsers - " + cntUsers + " users found");
			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ErsUser findUserById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			System.out.println("findUserById - Trying to get one user");
			String userSQL = "SELECT * FROM ers_user WHERE user_id = ?;";

			PreparedStatement sqlStatement = conn.prepareStatement(userSQL);
			sqlStatement.setInt(1, id);
			ResultSet userResult = sqlStatement.executeQuery();
			
			if (userResult.next()) {
			  ErsUser oneUser = new ErsUser(userResult.getInt("user_id"),
					                        userResult.getString("user_name"),
					                        userResult.getString("user_password"),
					                        userResult.getString("user_fname"),
					                        userResult.getString("user_lname"),
					                        userResult.getString("user_email"),
					                        null);
			  if (userResult.getString("user_role_id") != null) {
				  oneUser.setErsUserRoleId(userRoleDao.findRoleById(userResult.getString("user_role_id")));
			  }
			return oneUser;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ErsUser findUserByUserName(String userName) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			System.out.println("findUserByUserName - Trying to get one user");
			String userSQL = "SELECT * FROM ers_user WHERE user_name = ?;";

			PreparedStatement sqlStatement = conn.prepareStatement(userSQL);
			sqlStatement.setString(1, userName);
			ResultSet userResult = sqlStatement.executeQuery();
			
			if (userResult.next()) {
			  ErsUser oneUser = new ErsUser(userResult.getInt("user_id"),
					                        userResult.getString("user_name"),
					                        userResult.getString("user_password"),
					                        userResult.getString("user_fname"),
					                        userResult.getString("user_lname"),
					                        userResult.getString("user_email"),
					                        null);
			  if (userResult.getString("user_role_id") != null) {
				  oneUser.setErsUserRoleId(userRoleDao.findRoleById(userResult.getString("user_role_id")));
			  }
			return oneUser;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updatePassword(String userName, String newPassword) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			System.out.println("updatePassword - Trying to update one user's password");
			String userSQL = "UPDATE ers_user Set user_password = ? WHERE user_name = ?;";

			PreparedStatement sqlStatement = conn.prepareStatement(userSQL);
			sqlStatement.setString(1, newPassword);
			sqlStatement.setString(2, userName);
			sqlStatement.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
