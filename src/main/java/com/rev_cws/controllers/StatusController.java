package com.rev_cws.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev_cws.models.ErsReimbStatus;
import com.rev_cws.services.StatusService;

public class StatusController {

	private StatusService statusService = new StatusService();
	private ObjectMapper objMap = new ObjectMapper();

	public void getAllTypes(HttpServletResponse res) throws IOException {
		System.out.println("Hitting getAllTypes inside TypeController");
		List<ErsReimbStatus> list = statusService.letsSeeTheStatuses();
		String json = objMap.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
}