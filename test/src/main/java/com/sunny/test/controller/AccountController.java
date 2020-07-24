package com.sunny.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.test.dto.SendRequestDto;
import com.sunny.test.dto.WithDrawRequestDto;
import com.sunny.test.model.Account;
import com.sunny.test.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountServie;
	
	@GetMapping("/account")
	public @ResponseBody List<Account> findAll(){ // 전체계좌보기
		return accountServie.계좌정보보기(); // 데이터 리턴
	}

	
	@PutMapping("/send")
	public @ResponseBody String send(SendRequestDto dto) {
		accountServie.송금(dto);
		return "<h1>송금이 완료되었습니다.</h1>";
	}
	
	@PutMapping("/withdraw")
	public @ResponseBody String withdraw(WithDrawRequestDto dto) {
		accountServie.인출(dto);
		return "<h1>인출이 완료되었습니다.</h1>";
	}
}
