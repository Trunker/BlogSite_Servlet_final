package com.fdm.blogsite.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.blogsite.dal.UserDAO;
import com.fdm.blogsite.entity.User;
import com.fdm.blogsite.service.RegisterService;

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/register.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String userPassword = req.getParameter("userPassword");
		if (userName.equals("") || userPassword.equals("") ) {
			req.setAttribute("errorMessage", "User name and Password should not be null");
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/register.jsp");
			rd.forward(req, resp);
		} else {
			RegisterService rs=  (RegisterService) this.getServletContext().getAttribute("registerService");
			
			if (rs.getUser(userName)!=null) {
				req.setAttribute("errorMessage", "This name has been used! Please choose another name");
				RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/register.jsp");
				rd.forward(req, resp);
			} else {
				rs.registerUser(userName, userPassword);
				User user = rs.getUser(userName);
				req.setAttribute("currentUser", user);
				RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/home.jsp");
				rd.forward(req, resp);
			}
		}
	}
}
