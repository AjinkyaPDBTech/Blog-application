package com.blogger.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name = "post_title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "post_content", length = 10000)
	private String content;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "added_date")
	private Date addedDate;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
}
