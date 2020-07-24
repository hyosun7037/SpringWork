package com.sunny.blog.config.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.sunny.blog.config.handler.exception.MyRoleException;
import com.sunny.blog.config.handler.exception.MySessionException;

@ControllerAdvice //IcO 등록됨, Exception을 낚아 채는 컨트롤러
@RestController // 데이터 응답
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = MySessionException.class) // 일종의 GetMapping
	public String sessionException(Exception e) {
		// 인증 안됨
		return "<h1>인증없어요 나가세요</h1>";
	}
	
	@ExceptionHandler(value = MyRoleException.class) // 일종의 GetMapping
	public String roleException(Exception e) {
		// 권한 없음
		return "<h1>권한없어요 나가세요</h1>";
	}
}
