package com.rev_cws.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev_cws.models.ErsReimbType;
import com.rev_cws.utils.ConnectionUtil;

public class TypeDAOImpl implements TypeDAO {
	
	@Override
	public List<ErsReimbType> findAllTypes() {
		try (Connection conn = ConnectionUtil.getConnection()){
		
			String reimbTypeSQL = "SELECT * FROM ers_reimb_type;";
			Statement statement = conn.createStatement();
			List<ErsReimbType> typeList = new ArrayList<>();
			
			ResultSet result = statement.executeQuery(reimbTypeSQL);
			
			while (result.next()) {
				ErsReimbType oneReimbType = new ErsReimbType();
				
				oneReimbType.setTypeId(result.getInt("type_id"));
				oneReimbType.setTypeDesc(result.getString("type_desc"));
				
				typeList.add(oneReimbType);;
			}
			return typeList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}

	@Override
	public ErsReimbType findTypeById(int givenId) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String reimbTypeSQL = "SELECT * FROM ers_reimb_type WHERE type_id = ?;";
			PreparedStatement statement = conn.prepareStatement(reimbTypeSQL);
			statement.setInt(1, givenId);
			
			ResultSet result = statement.executeQuery();
			
			if (result.next()) {
				ErsReimbType oneReimbType = new ErsReimbType();
				
				oneReimbType.setTypeId(givenId);
				oneReimbType.setTypeDesc(result.getString("type_desc"));
				
				return oneReimbType;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}

	@Override
	public ErsReimbType findTypeByDesc(String givenDesc) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String reimbTypeSQL = "SELECT * FROM ers_reimb_type WHERE type_desc = ?;";
			PreparedStatement statement = conn.prepareStatement(reimbTypeSQL);
			statement.setString(1, givenDesc);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				ErsReimbType oneReimbType = new ErsReimbType();
				
				oneReimbType.setTypeId(result.getInt("type_id"));
				oneReimbType.setTypeDesc(givenDesc);

				return oneReimbType;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			// if no result, it will return null //
		return null;
	}
}
