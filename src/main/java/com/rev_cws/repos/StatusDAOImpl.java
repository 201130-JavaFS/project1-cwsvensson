package com.rev_cws.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev_cws.models.ErsReimbStatus;
import com.rev_cws.utils.ConnectionUtil;

public class StatusDAOImpl implements StatusDAO {

	@Override
	public List<ErsReimbStatus> findAllStatuses() {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String reimbStatusSQL = "SELECT * FROM ers_reimb_status;";
			Statement statement = conn.createStatement();
			List<ErsReimbStatus> statusList = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(reimbStatusSQL);
			
			while (result.next()) {
				ErsReimbStatus oneReimbStatus = new ErsReimbStatus();
				
				oneReimbStatus.setStatusId(result.getInt("status_id"));
				oneReimbStatus.setStatusDesc(result.getString("status_desc"));
				
				statusList.add(oneReimbStatus);;
			}
			return statusList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}
	
	@Override
	public ErsReimbStatus findStatusById(int givenId) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String reimbStatusSQL = "SELECT * FROM ers_reimb_status WHERE status_id = ?;";
			PreparedStatement statement = conn.prepareStatement(reimbStatusSQL);
			statement.setInt(1, givenId);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				ErsReimbStatus oneReimbStatus = new ErsReimbStatus();
				
				oneReimbStatus.setStatusId(givenId);
				oneReimbStatus.setStatusDesc(result.getString("type_desc"));
				
				return oneReimbStatus;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}

	@Override
	public ErsReimbStatus findStatusByDesc(String givenDesc) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String reimbStatusSQL = "SELECT * FROM ers_reimb_status WHERE status_desc = ?;";
			PreparedStatement statement = conn.prepareStatement(reimbStatusSQL);
			statement.setString(1, givenDesc);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				ErsReimbStatus oneReimbStatus = new ErsReimbStatus();
				
				oneReimbStatus.setStatusId(result.getInt("status_id"));
				oneReimbStatus.setStatusDesc(givenDesc);

				return oneReimbStatus;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}
}
