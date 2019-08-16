package com.fdm.blogsite.dal;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fdm.blogsite.entity.User;

public interface UserInterface {
	
	public void addUser(User user) ;
	public void removeUser(int userId) ;
	public void modifyUserPassword(int userId, String newPassword);
	public User getUser(int userId);
	public List getUserList();
}
