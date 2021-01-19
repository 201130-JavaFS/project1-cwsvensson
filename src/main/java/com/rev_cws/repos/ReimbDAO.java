package com.rev_cws.repos;

import java.util.List;

import com.rev_cws.models.ErsReimb;
import com.rev_cws.models.ReimbDTO;
import com.rev_cws.models.ReimbUpdateDTO;

public interface ReimbDAO {

	public List<ErsReimb>  findAllReimb(int uri_resolverId);
	public ErsReimb findReimbById(int id);
	public List<ErsReimb> findReimbByEmployee(int authorId);
	public boolean postReimb(ReimbDTO reimbDTO);
	public boolean updateReimb(ReimbUpdateDTO reimbUpdateDTO);
}