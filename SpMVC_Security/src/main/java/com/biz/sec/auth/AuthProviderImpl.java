package com.biz.sec.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.biz.sec.model.UserVO;

import lombok.extern.slf4j.Slf4j;

/*
 * spring security의 authentication-manager에서 사용할
 * authentication-provider 클래스를 커스터마이징하기
 */

@Slf4j
public class AuthProviderImpl implements AuthenticationProvider{

	// spring-security를 통하여 login을 수행했을 때 호출되는 method
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 사용자 ID를 추출하기
		// String username = (String)authentication.getPrincipal();
		// String username = authentication.getPrincipal().toString();
		String username = authentication.getName();
		
		// username = "adming" or "user1" or "guest"
		boolean bUser = username.equals("admin");
		bUser |= username.equals("user1");
		bUser |= username.equals("guest");
				
		// 사용자 ID 검사하기
		if(!bUser) {
			
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
		
		if(!password.equals("1234")) {
			throw new BadCredentialsException("✔ 비밀번호를 확인해주세요");
		}
		
		UserVO userVO = new UserVO();
		log.debug("USER VO: " + userVO.toString());
		
		if(!userVO.isEnabled()) {
			throw new DisabledException("사용자 정보를 사용할 수 없습니다");
		}
		
		if(!userVO.isAccountNonLocked()) {
			throw new LockedException("사용자계정이 잠겨있습니다" + "관리자에게 문의하세요");
		}
		
		if(!userVO.isAccountNonExpired()) {
			throw new AccountExpiredException("사용자계정이 만료되었습니다");
		}
		
		if(!userVO.isCredentialsNonExpired()) {
			throw new CredentialsExpiredException("사용자계정의 접근권한이 없습니다");
		}
		
		// ROLE 정보 테스트
		// 사용자ID에 부여된 ROLE list를 만들어서 추가하고
		// jsp 등에서 사용해보자
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		
		if(username.equals("admin")) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}else if(username.equals("user1")) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}else {
			authList.add(new SimpleGrantedAuthority("ROLE_GUEST"));
		}
				
		
		// 로그인만 성공을 하고 ROLE 정보 인가정보들이 모두 false인 사용자 데이터를 생성하고
		// login 성공 메시지를 만들기
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(new UserVO(), null, authList);
		
		return token;
	}

	// 현재 만들어진 AuthProviderImpl을 spring-security에서 사용가능하도록 설정
	// return값을 true로 하여 사용가능한 상태로 변환
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
