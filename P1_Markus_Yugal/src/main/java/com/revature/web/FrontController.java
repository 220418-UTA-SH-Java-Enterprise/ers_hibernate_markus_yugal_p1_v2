package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontController extends HttpServlet{
	
	private static final long serialVersionUID = 6362989780138068502L;
	private static Logger log = Logger.getLogger(FrontController.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// save the URI and rewrite it to determine what functionality the user is requesting based on URL
		final String URI = request.getRequestURI().replace("/P1_Markus_Yugal/", "");
		log.info("User URI is: " + URI);
		
		switch(URI) {
		//TODO: need to do getById & getByName methods in doGet
		//TODO: use doPut/doPatch for update
		//TODO: use doDelete for delete
		case "users": // query the DB and return a list of all users
			log.info("getting user list...");
			RequestHelper.processAllUsers(request, response);
			break;
		case "user":
			log.info("search user by name or id. URI: " + URI);
			RequestHelper.processUserBySearchParam(request, response);
			break;
		default:
			log.info("showing error message...");
			RequestHelper.processError(request, response);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// save the URI and rewrite it to determine what functionality the user is requesting based on URL
		final String URI = request.getRequestURI().replace("/P1_Markus_Yugal/", "");
		log.info("User URI is: " + URI);
		
		switch(URI) {
		//TODO: use register method here
		case "login": 
			log.info("logging in user...");
			RequestHelper.processLogin(request, response);
			break;
		case "register": 
			log.info("registering new user...");
			RequestHelper.processRegistration(request, response);
			break;
		case "reimbursement":
			log.info("adding new reimbursement request...");
			RequestHelper.processReimbursement(request, response);
			break;
		default:
			log.info("showing error message...");
			RequestHelper.processError(request, response);
			break;
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// save the URI and rewrite it to determine what functionality the user is requesting based on URL
		final String URI = request.getRequestURI().replace("/P1_Markus_Yugal/", "");
		
		switch(URI) {
		//TODO: use register method here
		case "update": 
			log.info("logging in user...");
			RequestHelper.processUserUpdate(request, response);
			break;
		default:
			log.info("showing error message...");
			RequestHelper.processError(request, response);
			break;
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// save the URI and rewrite it to determine what functionality the user is requesting based on URL
		final String URI = request.getRequestURI().replace("/P1_Markus_Yugal/", "");
		
		switch(URI) {
		//TODO: use register method here
		case "delete": 
			log.info("logging in user...");
			RequestHelper.processUserDelete(request, response);
			break;
		default:
			log.info("showing error message...");
			RequestHelper.processError(request, response);
			break;
		}
	}
}