package com.rev_cws.repos;

import java.util.List;

import com.rev_cws.models.ErsReimb;

public interface ReimbDAO {

	public List<ErsReimb>  findAllReimb();
	public ErsReimb findReimbById(int id);
	public ErsReimb findReimbByReimbAuthor(int authorId);
}