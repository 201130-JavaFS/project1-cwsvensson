package com.rev_cws.services;

import java.util.List;

import com.rev_cws.models.ErsReimbStatus;
import com.rev_cws.repos.StatusDAO;
import com.rev_cws.repos.StatusDAOImpl;

public class StatusService {
	
	private StatusDAO statusDao = new StatusDAOImpl();
	
	public List<ErsReimbStatus> letsSeeTheStatuses() {
		// System.out.println("Hitting letsSeeTheTypes inside TypeService");
		return statusDao.findAllStatuses();
	}
}