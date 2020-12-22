package com.rev_cws.repos;

import java.util.List;

import com.rev_cws.models.ErsReimbType;

public interface TypeDAO {
	
	public List<ErsReimbType> findAllTypes();
	public ErsReimbType findTypeById(int givenId);
	public ErsReimbType findTypeByDesc(String givenDesc);

}