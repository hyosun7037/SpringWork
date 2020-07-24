package com.sunny.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunny.blog.controller.dto.CommonRespDto;
import com.sunny.blog.model.User;
import com.sunny.blog.service.UserService;

@Controller
public class UserController { 
	// 요청시 컨트롤러가 뜸, userService는 컨트롤러보다 더 미리 떠있기 때문에 DI 가능
	// 톰캣 시작시 service 메모리에 뜸
	// 요청시 request 메모리에 뜸

	@Autowired
	private UserService userService; // 전역으로 관리
	
	
	@PostMapping("/auth/joinProc")
	public @ResponseBody CommonRespDto<?> joinProc(@RequestBody User user) { 
		// 제네릭 타입 모를 때 ? 사용 가능
		// key=value 데이터만 받을 수 있음 그래서 @RequestBody를 적어줘야함
		// 응답을 데이터로 받기 위해서 @ResponseBody사용
		userService.회원가입(user);
		return new CommonRespDto<String>(1,"회원가입완료");
		// 타입 결정나면 그때 적어주기 String
	}
	
	@PostMapping("/auth/loginProc")
	public @ResponseBody CommonRespDto<?> loginProc(@RequestBody User user, HttpSession session){
		User persistUser = userService.로그인(user);
		
		if(ObjectUtils.isEmpty(persistUser)) { // 빈 객체, 임시, 나중에 수정예정
			System.out.println("없음");
			return new CommonRespDto<String>(-1, "로그인 실패");
		}else {
			// 세션 등록해야함
			System.out.println("있음");
			session.setAttribute("principal", persistUser);
			return new CommonRespDto<String>(1, "로그인 성공");
		}
	}
}
