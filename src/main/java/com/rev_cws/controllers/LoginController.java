package com.rev_cws.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev_cws.models.LoginDTO;
import com.rev_cws.services.LoginService;

public class LoginController {

	private ObjectMapper objMap       = new ObjectMapper();
	private LoginService loginService = new LoginService();

	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {

		if (req.getMethod().equals("POST")) {

			// Same as Hello Jackson
			BufferedReader reader = req.getReader();

			StringBuilder buildTheStringBuilder = new StringBuilder();

			String line = reader.readLine();

			while (line != null) {
				buildTheStringBuilder.append(line);
				line = reader.readLine();
			}

			String body = new String(buildTheStringBuilder);

			LoginDTO lDTO = objMap.readValue(body, LoginDTO.class);

			if (loginService.login(lDTO.username, lDTO.password)) {
				HttpSession thisSession = req.getSession();

				thisSession.setAttribute("sessionUsername", lDTO);
				thisSession.setAttribute("loggedin", true);

				res.setStatus(200);
				res.getWriter().print("Login Successful");

			} else {
				// getSession uses an existing session, if already there
				
				HttpSession thisSession = req.getSession(false);
				if (thisSession != null) {
					thisSession.invalidate(); // logs a bad user out
				}
				res.setStatus(401);
				res.getWriter().print("Login failed");
			}
		}
	}
}