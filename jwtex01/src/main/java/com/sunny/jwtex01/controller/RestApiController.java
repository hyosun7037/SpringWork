package com.sunny.jwtex01.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.jwtex01.model.User;

import lombok.RequiredArgsConstructor;

@RequestMapping("api/v1")
@RestController
@RequiredArgsConstructor
// @CrossOrigin //CORS 허용
public class RestApiController {
	
	// 모든사람이 접근 가능
	@GetMapping("home")
	public String home() {
		return "<h1>home</h1>";
	}
	
	// 매니저가 접근 가능
	@GetMapping("manage/reports")
	public String reports() {
		return "<h1>reports</h1>";
	}
	
	// 관리자가 접근가능
	@GetMapping("admin/users")
	public List<User> users(){
		return null;
	}
}
