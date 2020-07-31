package com.sunny.securityex01.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sunny.securityex01.model.User;

import lombok.Data;

// Authentication 객체에 저장할 수 있는 유일한 타입이다.  --> 세션이 담김
@Data
public class PrincipalDetails implements UserDetails {
	
	private User user;
	
	public PrincipalDetails(User user) {
		super();
		this.user = user;
	}

   @Override
   public String getPassword() {
      return user.getPassword();
   }

   @Override
   public String getUsername() {
      return user.getUsername();
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;  // 계정 만료 X ---> true
   }

   @Override
   public boolean isAccountNonLocked() { 
      return true;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }

   @Override
   public boolean isEnabled() {
      return true;
   }
   
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return null; // 어떤 권한을 가졌는지 묻는 것
   }

}