package com.rev_cws.services;

import java.util.List;

import com.rev_cws.models.ErsReimb;
import com.rev_cws.models.ReimbDTO;
import com.rev_cws.repos.ReimbDAO;
import com.rev_cws.repos.ReimbDAOImpl;


public class ReimbService {
	
	private ReimbDAO reimbDao = new ReimbDAOImpl();
	
	public List<ErsReimb> letsSeeTheReimbRequests() {
		// System.out.println("Hitting letsSeeTheReimbRequests inside ReimbService");
		return reimbDao.findAllReimb();
	}

	public List<ErsReimb> letsSeeOneUsersReimbRequests(int URI_subId) {
		// System.out.println("Hitting letsSeeOneUsersReimbRequests inside ReimbService");
		return reimbDao.findReimbByEmployee(URI_subId);
	}
	
	public boolean letsPostOneReimbRequest(ReimbDTO reimbDTO) {
		// System.out.println("Hitting letsPostOneReimbRequest inside ReimbService");
		return reimbDao.postReimb(reimbDTO);
	}
	
}