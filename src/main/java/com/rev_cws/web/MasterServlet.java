package com.rev_cws.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import com.rev_cws.controllers.AvengersController;
import com.rev_cws.controllers.LoginController;
import com.rev_cws.controllers.ReimbController;
import com.rev_cws.controllers.StatusController;
import com.rev_cws.controllers.TypeController;
import com.rev_cws.controllers.UserController;

public class MasterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private UserController  userControl = new UserController();
	private TypeController  allTypeControl = new TypeController();
	private StatusController  allStatusControl = new StatusController();
	private LoginController loginControl  = new LoginController();
	private ReimbController allReimbControl  = new ReimbController();
	

	protected void doGet(HttpServletRequest userRequest, HttpServletResponse userResponse)
				throws ServletException, IOException {
		
		userResponse.setContentType("application/json");
		
		// By default tomcat will send back a successful status code if it finds a
		// servlet method.
		// Because all requests will hit this method, we are defaulting to not found and
		// will override for success requests.
		
		userResponse.setStatus(404);
		//System.out.println("Starting URI = " + req.getRequestURI());
		String URI = userRequest.getRequestURI().replace("/Reimbursement/", "");
		int URI_subId = 0;
		
		System.out.println("URI is now = " + URI);
		
		try {
			if (URI.length() > 15 &&  URI.substring(0,16).equals("oneUsersTickets/")) {
				URI = URI.replace("oneUsersTickets/", "");
				try {
					URI_subId = Integer.parseInt(URI);
				} catch (NumberFormatException e) {
	
				}
				URI = "oneUsersTickets";
				// System.out.println("URI = "+ URI + ", URI_subId = " + URI_subId);
				
			}
		} catch (Exception e) {	
		}
		
		try {
			if (URI.length() > 10 &&  URI.substring(0,11).equals("allTickets/")) {
				URI = URI.replace("allTickets/", "");
				try {
					URI_subId = Integer.parseInt(URI);
				} catch (NumberFormatException e) {
	
				}
				URI = "allTickets";
				System.out.println("URI = "+ URI + ", URI_subId = " + URI_subId);
			}
		} catch (Exception e) {
			
		}
		
		//-------------------------------------------//
		//   Find out which Servlet gets the data.   //
		//-------------------------------------------//
		
		switch (URI) {
			
		case "allLogins":
			if (userRequest.getSession(false) != null) {
				userControl.getAllUsers(userResponse);
			} else {
				userResponse.setStatus(403);
			}
			break;

		case "oneLogin":
			if (userRequest.getSession(false) != null) {
				userControl.getOneUser(userRequest, userResponse);
			} else {
				userResponse.setStatus(403);
			}
			break;
			
		case "allTickets":
			if (userRequest.getSession(false) != null) {
				allReimbControl.getAllReimbs(userResponse, URI_subId);
			} else {
				userResponse.setStatus(403);
			}
			break;
						
		case "oneUsersTickets":
			if (userRequest.getSession(false) != null) {
				allReimbControl.getOneUsersReimbs(userResponse, URI_subId);
			} else {
				userResponse.setStatus(403);
			}
			break;
						
		case "allTypes":
			if (userRequest.getSession(false) != null) {
				allTypeControl.getAllTypes(userResponse);
			} else {
				userResponse.setStatus(403);
			}
			break;
			
		case "allStatuses":
			if (userRequest.getSession(false) != null) {
				allStatusControl.getAllStatuses(userResponse);
			} else {
				userResponse.setStatus(403);
			}
			break;
			
		case "newTicket":
			if (userRequest.getSession(false) != null) {
				allReimbControl.postNewTicket(userRequest, userResponse);
			} else {
				userResponse.setStatus(403);
			}
			break;
			
		case "processTicket":
			if (userRequest.getSession(false) != null) {
				allReimbControl.updateTicket(userRequest, userResponse);
			} else {
				userResponse.setStatus(403);
			}
			break;
			
		case "login":
			loginControl.login(userRequest, userResponse);
			
			break;
			
		case "logout":
			loginControl.logout(userRequest, userResponse);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}