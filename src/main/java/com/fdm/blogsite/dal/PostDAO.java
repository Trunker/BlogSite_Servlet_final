package com.fdm.blogsite.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdm.blogsite.entity.Post;

public class PostDAO implements PostInterface {
	private EntityManagerFactory emf;

	public PostDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public void addPost(Post post) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(post);
		et.commit();
		em.close();
	}

	public void removePost(int postId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Post post = em.find(Post.class, postId);
		et.begin();
		em.remove(post);
		et.commit();
		em.close();
	}

	public void modifyPostTitle(int postId, String title) {
		EntityManager em = emf.createEntityManager();
		Post post = em.find(Post.class, postId);
		EntityTransaction et = em.getTransaction();
		et.begin();
		post.setPostTitle(title);
		et.commit();
		em.close();
	}

	public List<Post> getPostList() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("Select p from Post p", Post.class);
		List posts = query.getResultList();
		em.close();
		return posts;
	}

	public void modifyPostDate(int postId, String date) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Post post = em.find(Post.class, postId);
		et.begin();
		post.setPostDate(date);
		et.commit();
		em.close();
	}

	public void modifyPostCategory(int postId, String category) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Post post = em.find(Post.class, postId);
		et.begin();
		post.setPostCategory(category);
		et.commit();
		em.close();
	}

	public void modifyPostTag(int postId, String tag) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Post post = em.find(Post.class, postId);
		et.begin();
		post.setPostTag(tag);
		et.commit();
		em.close();
	}

	public void modifyPostContent(int postId, String content) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Post post = em.find(Post.class, postId);
		et.begin();
		post.setPostContent(content);
		et.commit();
		em.close();
	}

	public Post getPost(int postId) {
		EntityManager em = emf.createEntityManager();
		Post post = em.find(Post.class, postId);
		em.close();
		return post;
	}
}
