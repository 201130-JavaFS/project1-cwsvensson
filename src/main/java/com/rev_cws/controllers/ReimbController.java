package com.rev_cws.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev_cws.models.ErsReimb;
import com.rev_cws.services.ReimbService;

public class ReimbController {
	
	private ReimbService reimbService = new ReimbService();
	private ObjectMapper objMap = new ObjectMapper();

	public void getAllTypes(HttpServletResponse res) throws IOException {
		System.out.println("Hitting getAllTypes inside TypeController");
		List<ErsReimb> list = reimbService.letsSeeTheReimbRequests();
		String json = objMap.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
}