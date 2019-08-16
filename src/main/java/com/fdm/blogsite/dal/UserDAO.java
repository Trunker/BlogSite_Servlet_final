package com.fdm.blogsite.dal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.fdm.blogsite.entity.User;

public class UserDAO implements UserInterface {

	private EntityManagerFactory emf;

	public UserDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void addUser(User user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
		em.close();
	}

	public List getUserList() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT u FROM User u", User.class // use java class not table
		);
		List userList = query.getResultList();
		em.close();
		return userList;
	}

	public void removeUser(int userId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User u = em.find(User.class, userId);
		et.begin();
		em.remove(u);
		et.commit();
		em.close();
	}

	public void modifyUserPassword(int userId, String newPassword) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		User user = em.find(User.class, userId); 
		et.begin();
		user.setUserPasswd(newPassword);
		et.commit();
		em.close();
	}

	public User getUser(int userId) {
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, userId);
		em.close();
		return user;
	}

	public User getUser(String userName) {
		EntityManager em = emf.createEntityManager();
		User temUser = null;
		Query query = em.createQuery("SELECT n FROM User n WHERE n.userName = '" + userName + "'", User.class);
		try {
			temUser = (User) query.getSingleResult();
		} catch (NoResultException nre) {
			//log
		} finally {
			em.close();
		}
		return temUser;
	}

}
