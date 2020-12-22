package com.rev_cws.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rev_cws.models.ErsUserRole;
import com.rev_cws.utils.ConnectionUtil;

public class UserRoleDAOImpl implements UserRoleDAO {

	@Override
	public ErsUserRole findRoleById(String givenId) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String userRoleSQL = "SELECT * FROM ers_user_role WHERE role_id = ?;";
			PreparedStatement statement = conn.prepareStatement(userRoleSQL);
			statement.setString(1, givenId);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				ErsUserRole oneUserRole = new ErsUserRole();
				
				oneUserRole.setRoleID(givenId);
				oneUserRole.setRoleDesc(result.getString("role_desc"));
				
				return oneUserRole;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}

	@Override
	public ErsUserRole findRoleByDesc(String givenDesc) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String userRoleSQL = "SELECT * FROM ers_user_role WHERE role_desc = ?;";
			PreparedStatement statement = conn.prepareStatement(userRoleSQL);
			statement.setString(1, givenDesc);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				ErsUserRole oneUserRole = new ErsUserRole();
				
				oneUserRole.setRoleID(result.getString("role_id"));
				oneUserRole.setRoleDesc(givenDesc);

				return oneUserRole;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}
}