package com.fdm.blogsite.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.blogsite.entity.Post;
import com.fdm.blogsite.entity.User;
import com.fdm.blogsite.service.PostService;

public class FinishAddPostServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String postTitle = req.getParameter("postTitle");
		String postContent = req.getParameter("postContent");
		PostService ps = (PostService) this.getServletContext().getAttribute("postService");
		HttpSession hs = req.getSession();
		User user = (User) hs.getAttribute("currentUser");
		ps.addPost(new Post(postTitle, postContent,user));
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/addPost.jsp");
		rd.forward(req,  resp);
	}
}
