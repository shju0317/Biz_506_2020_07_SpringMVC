package com.biz.sec.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/*
 * spring security의 authentication-manager에서 사용할
 * authentication-provider 클래스를 커스터마이징하기
 */
public class AuthProviderImpl implements AuthenticationProvider{

	// spring-security를 통하여 login을 수행했을 때 호출되는 method
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 사용자 ID를 추출하기
		// String username = (String)authentication.getPrincipal();
		// String username = authentication.getPrincipal().toString();
		String username = authentication.getName();
				
		// 사용자 ID 검사하기
		if(!username.equals("admin")) {
			
			String msg = String.format("✔ [ %s ] ID를 확인하세요", username);
			
			/*
			 * throw new Exception(message)
			 * throw: 강제로 exception을 발생시켜라 
			 * 
			 * spring security login이 진행되는 도중에
			 * 어떤 문제가 발생을 하면
			 * 메시지를 만들고 강제로 exception을 발생시키면
			 * spring security에게 메시지를 전달하는 효과가 나타난다.
			 * 
			 * authenticate() method는 실행을 멈추고
			 * spring security가 메시지를 수신하여 다시 login 화면을 열고
			 * 메시지를 보여준다.
			 */
			throw new InternalAuthenticationServiceException(msg);
			// throw new UsernameNotFoundException(msg);
		}
		
		// 사용자 비밀번호 추출하기
		String password = authentication.getCredentials().toString();

		
		return null;
	}

	// 현재 만들어진 AuthProviderImpl을 spring-security에서 사용가능하도록 설정
	// return값을 true로 하여 사용가능한 상태로 변환
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
