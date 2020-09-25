package com.biz.book.model;

import java.util.Collection;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Alias("UserDetail")
@Getter
@Setter
public class UserDetailsVO implements UserDetails {
	
	/*
	 * http 프로토콜을 통해서 VO를 주고 받을 때
	 * 데이터가 JSON형태로 이동이 되는데
	 * 일렬로 나열된 문자열 형태로 네트워크를 통해서 이동한다
	 * 이때 이러한 기능을 쉽게 구현하기 위해서 serialize라는 인터페이스를 implements 한다.
	 * serialize된 VO클래스에는 serialVersionUID라는 값을 설정해주어야 경고가 나지 않는다.
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String username;
	private String password;
	
	private boolean isEnabled;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	
	// List<GrantedAuthority>
	private Collection<? extends GrantedAuthority> authorities;
	
	// 프로젝트에서 필요한 별도의 필드변수 선언
	private String email;
	private String phone;
	private String address;
}
