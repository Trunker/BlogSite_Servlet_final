package com.fdm.blogsite.entity;

import java.awt.List;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	private String postTitle;
	private String postDate;
	private String postContent;
	private String postCategory;
	private String postTag;
	
	@ManyToOne
	private User user;
	
	public Post(String postTitle, String postContent, User user) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.user=user;
	}
	
	
	public Post() {
	}
	
	public int getPostId() {
		return postId;
	}
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
	}

	public String getPostTag() {
		return postTag;
	}

	public void setPostTag(String postTag) {
		this.postTag = postTag;
	}

}
