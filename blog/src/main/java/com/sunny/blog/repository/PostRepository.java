package com.sunny.blog.repository;

import java.util.List;

import com.sunny.blog.controller.dto.PostDetailRespDto;
import com.sunny.blog.model.Post;

// 자바 오브젝트 저장소, mapper 스캔하기 때문에 @Repository를 안써도 자동으로 뜸
public interface PostRepository {
	public void save(Post post); // save 함수의 mapper가 없음
	public List<Post> findAll();
	public PostDetailRespDto findById(int id);
	public Post findOne(int id); // 삭제시 사용할 함수
	public void deleteOne(int id);
	public void update(Post post);
} 
