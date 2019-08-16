package com.fdm.blogsite.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.blogsite.entity.Post;
import com.fdm.blogsite.entity.User;
import com.fdm.blogsite.service.HomeService;

public class HomeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		if (userName.equals("") || password.equals("")) {
			req.setAttribute("errorMessageOfLogin", "name and password should not be null");
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/index.jsp");
			rd.forward(req, resp);
		}
		HomeService ua = (HomeService) this.getServletContext().getAttribute("homeService");
		boolean result = ua.authenticateUser(userName, password);

		if (result) {
			User user = ua.getUser(userName);
			List<Post> postList = (List<Post>) user.getPostList();
			HttpSession hs = req.getSession();

			hs.setAttribute("currentUser", user);
			hs.setAttribute("postList", postList);
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/home.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("errorMessageOfLogin", "Please enter valid name and password");
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/index.jsp");
			rd.forward(req, resp);
		}
	}
}
