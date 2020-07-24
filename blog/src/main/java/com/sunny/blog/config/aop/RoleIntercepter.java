package com.sunny.blog.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sunny.blog.config.handler.exception.MyRoleException;
import com.sunny.blog.config.handler.exception.MySessionException;
import com.sunny.blog.model.User;

// 인증 관리
public class RoleIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); // request를 받아 올 수 있기 때문에 HttpSession사용 가능
		User principal = (User)session.getAttribute("principal");
		
		if(principal == null) {
			System.out.println("RoleInterceptor : 인증이 안됨");
			throw new MySessionException(); // 요청한 쪽으로 던지기, (JVM이 낚아채기 전에)
		}else {
			if(!principal.getRole().equals("ROLE_ADMIN")) {
				System.out.println("RoleInterceptor : 권한이 없음");
				throw new MyRoleException();
			}
		}
		return true;
	}
}
