package com.sunny.blog.repository;

import com.sunny.blog.model.User;

// 자바 오브젝트 저장소, mapper 스캔하기 때문에 @Repository를 안써도 자동으로 뜸
public interface UserRepository {
	public void save(User user); // save 함수의 mapper가 없음
	public User login(User user); // persistance가 오브젝트로 User를 리턴하기 때문에 User로 받음
}
