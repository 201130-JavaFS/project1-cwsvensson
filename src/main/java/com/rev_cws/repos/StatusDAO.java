package com.rev_cws.repos;

import java.util.List;

import com.rev_cws.models.ErsReimbStatus;

public interface StatusDAO {
	
	public List<ErsReimbStatus> findAllStatuses();
	public ErsReimbStatus findStatusById(int givenId);
	public ErsReimbStatus findStatusByDesc(String givenDesc);

}