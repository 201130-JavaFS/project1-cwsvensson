package com.rev_cws.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import com.rev_cws.controllers.AvengersController;
import com.rev_cws.controllers.LoginController;
import com.rev_cws.controllers.TypeController;
import com.rev_cws.controllers.UserController;

public class MasterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private UserController allUserControl = new UserController();
	private TypeController allTypeControl = new TypeController();
	private LoginController loginControl  = new LoginController();
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
				throws ServletException, IOException {
		
		res.setContentType("application/json");
		
		// By default tomcat will send back a successful status code if it finds a
		// servlet method.
		// Because all requests will hit this method, we are defaulting to not found and
		// will override for success requests.
		
		res.setStatus(404);
		System.out.println("Starting URI = " + req.getRequestURI());
		final String URI = req.getRequestURI().replace("/Reimbursement/", "");
		System.out.println("URI is now = " + URI);
		
		switch (URI) {
			
		case "allLogins":
			if (req.getSession(false) != null) {
				allUserControl.getAllUsers(res);
			} else {
				res.setStatus(403);
			}
			break;
			
		case "allTypes":
			if (req.getSession(false) != null) {
				allTypeControl.getAllTypes(res);
			} else {
				res.setStatus(403);
			}
			break;
			
		case "login":
			loginControl.login(req,res);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}