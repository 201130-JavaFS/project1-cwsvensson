package com.rev_cws.repos;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev_cws.models.ErsReimb;
import com.rev_cws.models.ReimbDTO;
import com.rev_cws.utils.ConnectionUtil;

public class ReimbDAOImpl implements ReimbDAO {
	
	private UserDAO   userDao   = new UserDAOImpl();
	private StatusDAO statusDao = new StatusDAOImpl();
	private TypeDAO   typeDao   = new TypeDAOImpl();

	@Override
	public List<ErsReimb> findAllReimb() {
		
		System.out.println("Hitting findAllReimb inside ReimbDAOImpl");
		try (Connection conn = ConnectionUtil.getConnection()) {

			System.out.println("findAllReimb - Trying to get all reimbusements");
			String reimbSQL = "SELECT * FROM ers_reimb;";

			Statement statement = conn.createStatement();

			List<ErsReimb> reimbList = new ArrayList<>();

			ResultSet reimbResult = statement.executeQuery(reimbSQL);
			int cntRecords = 0;

			while (reimbResult.next()) {
				ErsReimb oneReimb = new ErsReimb(reimbResult.getInt("reimb_id"), 
										 	    reimbResult.getBigDecimal("reimb_amount"),
											    reimbResult.getTimestamp("reimb_submitted"), 
											    reimbResult.getTimestamp("reimb_resolved"), 
											    reimbResult.getString("reimb_desc"),
											    reimbResult.getString("reimb_receipt"));
											   
				oneReimb.setErsUserAuthorId(userDao.findUserById(reimbResult.getInt("reimb_author_id")));
				
				if (reimbResult.getString("reimb_resolver_id") != null) {
					oneReimb.setErsUserResolverId(userDao.findUserById(reimbResult.getInt("reimb_resolver_id")));
				} else {
					oneReimb.setErsUserResolverId(userDao.findUserById(0));
				}
				
				oneReimb.setErsStatusId(statusDao.findStatusById(reimbResult.getInt("reimb_status_id")));
				oneReimb.setErsTypeId(typeDao.findTypeById(reimbResult.getInt("reimb_type_id")));
				
				reimbList.add(oneReimb);
				cntRecords++;
			}
			System.out.println("findAllReimb - " + cntRecords + " reimb records found");
			return reimbList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ErsReimb findReimbById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ErsReimb> findReimbByEmployee(int userId) {
		System.out.println("Hitting findReimbByEmployee inside ReimbDAOImpl");
		try (Connection conn = ConnectionUtil.getConnection()) {

			System.out.println("findReimbByEmployee - Trying to get all reimbusements for user = " + userId);
			
			String reimbSQL = "SELECT * FROM ers_reimb WHERE ers_reimb.reimb_author_id = ?;";
			PreparedStatement sqlStatement = conn.prepareStatement(reimbSQL);
			sqlStatement.setInt(1, userId);
			
			List<ErsReimb> reimbList = new ArrayList<>();

			ResultSet reimbResult = sqlStatement.executeQuery();
			int cntRecords = 0;

			while (reimbResult.next()) {
				ErsReimb oneReimb = new ErsReimb(reimbResult.getInt("reimb_id"),
						reimbResult.getBigDecimal("reimb_amount"), reimbResult.getTimestamp("reimb_submitted"),
						reimbResult.getTimestamp("reimb_resolved"), reimbResult.getString("reimb_desc"),
						reimbResult.getString("reimb_receipt"));

				oneReimb.setErsUserAuthorId(userDao.findUserById(reimbResult.getInt("reimb_author_id")));

				if (reimbResult.getString("reimb_resolver_id") != null) {
					oneReimb.setErsUserResolverId(userDao.findUserById(reimbResult.getInt("reimb_resolver_id")));
				} else {
					oneReimb.setErsUserResolverId(userDao.findUserById(0));
				}

				oneReimb.setErsStatusId(statusDao.findStatusById(reimbResult.getInt("reimb_status_id")));
				oneReimb.setErsTypeId(typeDao.findTypeById(reimbResult.getInt("reimb_type_id")));

				reimbList.add(oneReimb);
				cntRecords++;
			}
			System.out.println("findAllReimb - " + cntRecords + " reimb records found");
			return reimbList;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean postReimb(ReimbDTO reimbDTO) {
		System.out.println("Hitting postReimb inside ReimbDAOImpl");
		
		int insertCnt = 0;
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("Attempting to add: " + reimbDTO);
			
			String reimbSQL = "INSERT INTO ers_reimb " +
			        "(reimb_amount, reimb_desc, reimb_author_id, reimb_status_id, reimb_type_id) " + 
					"VALUES (?, ?, ?, ?, ?);";
			
			System.out.println("postReimb - reinbSQL = " + reimbSQL);
					
			PreparedStatement sqlStatement = conn.prepareStatement(reimbSQL);
			
			sqlStatement.setBigDecimal(1, new BigDecimal(reimbDTO.reimbAmountFE));  // All data points are String from the JSON
			sqlStatement.setString(2, reimbDTO.reimbDescFE);
			sqlStatement.setInt(3, Integer.parseInt(reimbDTO.reimbAuthorFE));
			sqlStatement.setInt(4, Integer.parseInt(reimbDTO.reimbStatusFE));
			sqlStatement.setInt(5, Integer.parseInt(reimbDTO.reimbTypeFE));
			System.out.println("postReimb - sqlStatement = " + sqlStatement);
			
			insertCnt = sqlStatement.executeUpdate();
			System.out.println("postReimb - insertCnt = " + insertCnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (insertCnt == 1);
	}
	
}
