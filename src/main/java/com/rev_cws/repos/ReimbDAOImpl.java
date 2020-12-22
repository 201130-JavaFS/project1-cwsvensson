package com.rev_cws.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev_cws.models.ErsReimb;
import com.rev_cws.utils.ConnectionUtil;

public class ReimbDAOImpl implements ReimbDAO {
	
	private UserDAO   userDao   = new UserDAOImpl();
	private StatusDAO statusDao = new StatusDAOImpl();
	private TypeDAO   typeDao   = new TypeDAOImpl();

	@Override
	public List<ErsReimb> findAllReimb() {
		
		// System.out.println("Hitting findAllUsers inside UserDAOImpl");
		try (Connection conn = ConnectionUtil.getConnection()) {

			//System.out.println("findAllReimb - Trying to get all reimbusements");
			String reimbSQL = "SELECT * FROM ers_reimb;";

			Statement statement = conn.createStatement();

			List<ErsReimb> reimbList = new ArrayList<>();

			ResultSet reimbResult = statement.executeQuery(reimbSQL);
			//int cntUsers = 0;

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
				}
				oneReimb.setErsStatusId(statusDao.findStatusById(reimbResult.getInt("reimb_status_id")));
				oneReimb.setErsTypeId(typeDao.findTypeById(reimbResult.getInt("reimb_type_id")));
				
				
				
				reimbList.add(oneReimb);
			}
			//System.out.println("findAllUsers - " + cntUsers + " users found");
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
	public ErsReimb findReimbByReimbAuthor(int authorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
