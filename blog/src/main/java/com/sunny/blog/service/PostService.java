package com.sunny.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunny.blog.controller.dto.PostDetailRespDto;
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
	
	@Transactional(readOnly = true)
	public List<Post> 목록보기() { 
		return postRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public PostDetailRespDto 상세보기(int id) {  // 작성자도 받아야함
		return postRepository.findById(id);
	} 
	
	@Transactional
	public void 삭제하기(int id) {  // 작성자도 받아야함
		postRepository.deleteOne(id);
	} 
	
	@Transactional
	public void 수정하기(Post post) {  // 작성자도 받아야함
		postRepository.update(post);
	} 
}
