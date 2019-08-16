package com.fdm.blogsite.service;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdm.blogsite.dal.PostDAO;
import com.fdm.blogsite.dal.UserDAO;
import com.fdm.blogsite.entity.User;

public class HomeService {
	private UserDAO userDAO;

	public HomeService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public boolean authenticateUser(String userName, String password) {
		ArrayList<User> userList = (ArrayList<User>) userDAO.getUserList();
		Iterator<User> userListIterator = userList.iterator();
		while (userListIterator.hasNext()) {
			User user = userListIterator.next();
			if (user.getUserName().equals(userName) && user.getUserPasswd().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public User getUser(String userName) {
		User user = userDAO.getUser(userName);
		return user;
	}

}
