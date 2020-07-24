package com.sunny.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunny.blog.model.Post;
import com.sunny.blog.repository.PostRepository;


@Service // IOC
public class PostService {

	@Autowired
	private PostRepository postRepository; // DI
	
	@Transactional
	public void 글쓰기(Post post) { 
		postRepository.save(post); 
	}
}
