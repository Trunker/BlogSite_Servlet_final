package com.fdm.blogsite.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.blogsite.entity.Post;
import com.fdm.blogsite.service.PostService;

public class PostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int postId = Integer.parseInt(req.getParameter("postId"));
		PostService postService =(PostService) this.getServletContext().getAttribute("postService");
		Post post = postService.getPost(postId);
		req.setAttribute("post", post);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/post.jsp");
		rd.forward(req, resp);
		
	}
	
	

}
