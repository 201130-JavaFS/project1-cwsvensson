package com.rev_cws.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev_cws.models.ErsReimbType;
import com.rev_cws.services.TypeService;

public class TypeController {

	private TypeService userService = new TypeService();
	private ObjectMapper objMap = new ObjectMapper();

	public void getAllTypes(HttpServletResponse res) throws IOException {
		System.out.println("Hitting getAllTypes inside TypeController");
		List<ErsReimbType> list = userService.letsSeeTheTypes();
		String json = objMap.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
}
