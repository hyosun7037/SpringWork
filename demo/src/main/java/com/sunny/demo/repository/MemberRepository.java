package com.sunny.demo.repository;

import java.util.List;

import com.sunny.demo.model.Member;

public interface MemberRepository {
	public Member findById(int id);
	public List<Member> findAll();
}
