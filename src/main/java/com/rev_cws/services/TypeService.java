package com.rev_cws.services;

import java.util.List;

import com.rev_cws.models.ErsReimbType;
import com.rev_cws.repos.TypeDAO;
import com.rev_cws.repos.TypeDAOImpl;

public class TypeService {
	
	private TypeDAO typeDao = new TypeDAOImpl();
	
	public List<ErsReimbType> letsSeeTheTypes() {
		System.out.println("Hitting letsSeeTheTypes inside TypeService");
		return typeDao.findAllTypes();
	}
}