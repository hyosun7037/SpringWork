package com.sunny.securityex01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // IoC Bean(객체)를 등록, 오브젝트는 메모리에 X, 인스턴스와 같은 의미
@EnableWebSecurity // 필터 체인 관리 시작, 전체 필터를 관리할 수 있는 설정
@EnableGlobalMethodSecurity(prePostEnabled = true) 
// 특정 주소 접근시 컨트롤러 접근시 권한 및 인증을 미리 체크할지 설정
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/**", "/admin/**") //이 주소를 제외한 모든 것들은 인증이 필요하다는 의미
			.authenticated()
			.anyRequest()
			.permitAll()
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/loginProc") // 이 주소로 들어오면 Authentication으로 들어감
			.defaultSuccessUrl("/"); // 성공하면 이 주소로 리다이렉션됨
	}
}
