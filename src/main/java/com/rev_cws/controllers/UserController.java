package com.rev_cws.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev_cws.models.ErsUser;
import com.rev_cws.services.UserService;

public class UserController {

	private UserService userService = new UserService();
	private ObjectMapper objMap = new ObjectMapper();

	public void getAllUsers(HttpServletResponse res) throws IOException {
		// System.out.println("Hitting getAllUsers inside UserController");
		List<ErsUser> list = userService.letsSeeTheUsers();
		String json = objMap.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}

	public void getOneUser(HttpServletRequest userRequest, HttpServletResponse res) throws IOException {
		// System.out.println("Hitting getOneUser inside UserController");
		ErsUser oneUser = userService.justTheSessionUser(userRequest);
		// System.out.println("Hitting getOneUser = " + oneUser);
		String json = objMap.writeValueAsString(oneUser);
		res.getWriter().print(json);
		res.setStatus(200);
	}
}