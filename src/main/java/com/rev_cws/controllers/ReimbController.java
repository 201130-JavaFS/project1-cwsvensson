package com.rev_cws.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev_cws.models.ErsReimb;
import com.rev_cws.models.ReimbDTO;
import com.rev_cws.services.ReimbService;

public class ReimbController {
	
	private ReimbService reimbService = new ReimbService();
	private ObjectMapper objMap = new ObjectMapper();

	public void getAllReimbs(HttpServletResponse res) throws IOException {
		// System.out.println("Hitting getAllReimbs inside ReimbController");
		List<ErsReimb> list = reimbService.letsSeeTheReimbRequests();
		String json = objMap.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}

	public void getOneUsersReimbs(HttpServletResponse userResponse, int URI_subId) throws IOException {
		// System.out.println("Hitting getOneUsersReimbs inside ReimbController");
		List<ErsReimb> list = reimbService.letsSeeOneUsersReimbRequests(URI_subId);
		String json = objMap.writeValueAsString(list);
		userResponse.getWriter().print(json);
		userResponse.setStatus(200);
	}

	public void postNewTicket(HttpServletRequest userRequest, HttpServletResponse userResponse) throws IOException {
		//System.out.println("Hitting postNewTicket inside ReimbController");
		
		if (userRequest.getMethod().equals("POST")) {
			
			BufferedReader reader = userRequest.getReader();
			StringBuilder buildTheStringBuilder = new StringBuilder();
			String line = reader.readLine();
			
			while (line != null) {
				buildTheStringBuilder.append(line);
				line = reader.readLine();
			}

			String body = new String(buildTheStringBuilder);
			ReimbDTO reimbDTO = objMap.readValue(body, ReimbDTO.class);
			
			System.out.println("ReimbController: postNewTicket - reimbDTO: " + reimbDTO);
			
			if (reimbService.letsPostOneReimbRequest(reimbDTO)) {
				userResponse.setStatus(200);
				userResponse.getWriter().print("Reimbursement Post Successful");
			
			} else {
				userResponse.setStatus(401);
				userResponse.getWriter().print("Reimbursement Post failed");
			}
		}
	}
}