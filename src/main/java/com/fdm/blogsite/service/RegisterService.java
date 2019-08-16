package com.fdm.blogsite.service;


import com.fdm.blogsite.dal.UserDAO;
import com.fdm.blogsite.entity.User;

public class RegisterService {
	private UserDAO userDAO;

	public RegisterService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public void registerUser(String userName, String userPassword) {
		User user = new User(userName, userPassword, 0);
		userDAO.addUser(user);
	}

	public User getUser(String userName) {
		User user = userDAO.getUser(userName);
		return user;
	}

	public boolean validate(String userName) {
		User user = userDAO.getUser(userName);
		if (user != null) {
			return false;
		} else {
			return true;
		}
	}

}
