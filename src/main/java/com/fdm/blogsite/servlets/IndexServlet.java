package com.fdm.blogsite.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/index.jsp"); //send back a jsp
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s = req.getParameter("logout");
		if(s!=null) {
			req.getSession().invalidate();
		}
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/index.jsp");
		rd.forward(req, resp);
	}
	 
	
	
	
}