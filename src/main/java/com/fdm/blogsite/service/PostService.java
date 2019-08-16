package com.fdm.blogsite.service;

import com.fdm.blogsite.dal.PostDAO;
import com.fdm.blogsite.entity.Post;

public class PostService {
	private PostDAO postDAO;

	public PostService(PostDAO postDAO) {
		super();
		this.postDAO = postDAO;
	}

	public void deletePost(int postId) {
		postDAO.removePost(postId);
	}
	
	public Post getPost(int postId) {
		return postDAO.getPost(postId);
	}
	
	public void addPost(Post post) {
		postDAO.addPost(post);
	}

}
