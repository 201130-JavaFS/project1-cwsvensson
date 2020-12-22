package com.rev_cws.repos;

import com.rev_cws.models.ErsUserRole;

public interface UserRoleDAO {
	
	public ErsUserRole findRoleById(String givenId);
	public ErsUserRole findRoleByDesc(String givenDesc);

}