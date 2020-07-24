package com.sunny.viewresolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //IoC
public class IndexController {
	
	@GetMapping({"","/"})
	public String index(Model model) {
		String name = "cos";
		int num = 10;
		String password = "1234";
		model.addAttribute("name", name); //("스트링", 오브젝트 타입)
		model.addAttribute("num", num); //("스트링", 오브젝트 타입)
		model.addAttribute("password", password); //("스트링", 오브젝트 타입)
		// 파일경로--> viewresolver/src/main/resources/templates/index.mustache
		return "home";
	}
	
	@GetMapping("/model/data")
	public String modelData(Model model){ // DI 하기
		Member member = Member.builder()
						.id(1)
						.username("ssar")
						.phone("01012345678")
						.build();
		model.addAttribute("member", member); // 가지고 view 페이지로 이동 (mustache)
		return "modelData";
	}
	
	@GetMapping("/model/array")
	public String modelArray(Model model){ // DI 하기
		Member member1 = Member.builder()
						.id(1)
						.username("ssar")
						.phone("01012345678")
						.build();
		
		Member member2 = Member.builder()
				.id(2)
				.username("cos")
				.phone("01012345678")
				.build();
		
		List<Member> members = new ArrayList<>();
		members.add(member1);
		members.add(member2);
		model.addAttribute("members", members); // 가지고 view 페이지로 이동 (mustache)
		model.addAttribute("user", true);
		return "modelArray"; //modelArray로 데이터 또는 파일을 가지고이동
	}
	
	@GetMapping("/layout")
	public String layout() {
		return "layout";
	}
	
	
}