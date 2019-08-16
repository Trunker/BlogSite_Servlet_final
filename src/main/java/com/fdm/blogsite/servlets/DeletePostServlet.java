package com.fdm.blogsite.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.blogsite.entity.Post;
import com.fdm.blogsite.entity.User;
import com.fdm.blogsite.service.PostService;

public class DeletePostServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PostService postService = (PostService) this.getServletContext().getAttribute("postService");
		int postId =Integer.parseInt(req.getParameter("postId"));
		postService.deletePost(postId);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/home.jsp");
		rd.forward(req, resp);
	}

}
