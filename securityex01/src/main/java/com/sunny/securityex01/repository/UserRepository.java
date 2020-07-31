package com.sunny.securityex01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunny.securityex01.model.User;

// JpaRespository를 상속하면 자동 컴포넌트 스캔됨
public interface UserRepository extends JpaRepository<User, Integer>{
	// JAP Naming 전략
	// SELECT * FROM user WHERE username = 1?
	User findByUsername(String username);
	// 함수이름을 만들면 자동으로 쿼리가 동작
	
//	@Query(value = "select * from user", nativeQuery = true)
//	User find아무함수();
}
