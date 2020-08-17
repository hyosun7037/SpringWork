package com.sunny.logtest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	
	@NotBlank(message = "유저네임이 공백일 수 없습니다.")
	@Max(value = 10, message ="유저네임의 길이가 10자를 초과할 수 없습니다.")
	private String username;
	
	@NotBlank(message = "패스워드가 공백일 수 없습니다.")
	private String password;
	
	@NotBlank(message = "이메일이 공백일 수 없습니다.")
	@Email
	private String email;
}
