package com.fdm.blogsite.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.fdm.blogsite.dal.PostDAO;
import com.fdm.blogsite.dal.UserDAO;
import com.fdm.blogsite.service.PostService;
import com.fdm.blogsite.service.HomeService;
import com.fdm.blogsite.service.RegisterService;

public class Listener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("blogPersistence");

		UserDAO userDAO = new UserDAO(emf);
		PostDAO postDAO = new PostDAO(emf);

		HomeService homeService = new HomeService(userDAO);
		RegisterService registerService = new RegisterService(userDAO);
		PostService postService = new PostService(postDAO);
		sce.getServletContext().setAttribute("homeService", homeService);
		sce.getServletContext().setAttribute("registerService", registerService);
		sce.getServletContext().setAttribute("postService", postService);
	}

}
