package com.biz.book.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.biz.book.model.AuthorityVO;
import com.biz.book.model.UserDetailsVO;

import lombok.extern.slf4j.Slf4j;

/*
 * member table에서 user정보를 select하여 권한을 관리하는 클래스
 * 
 * (spring security에서 사용자 인증, 권한 부여 절차)
 * 사용자가 login form에 username, password를 입력한 후 로그인을 시도하면
 * 1. AuthenticationProvider 인터페이스를 구현한 AuthProviderImpl 객체를 찾는다.
 * 2. authenticate() method를 호출한다. 이때 sprint security는 authentication객체에
 * 	  로그인한 username, password를 실어서 전달한다.
 * 3. authentication 객체에서 principal(username), credential(password)값을 getter하여
 * 	  username과 password를 추출한다.
 * 4. UserDetailService 인터페이스를 구현한 UserDetailServiceImpl 객체를 호출하여
 * 	  UserDetails 정보를 요청한다.
 * 5. UserDetailServiceImpl은 username에 해당하는 사용자 정보를 user(member) table에서
 * 	  select하여 return한다. 이때 username에 해당하는 사용자 정보가 없으면
 *    UsernameNotFoundException을 발생시켜 spring security에게 사용자 정보가 없음을 통보한다.
 * 6. UserDetailServiceImpl로부터 return받은 UserDetails에 담겨있는 password와
 *    사용자가 login한 password를 비교한다.
 *    만약 password가 다르면 BadCredentialsException을 강제로 발생시켜 spring security에게 통보한다. 
 * 7. username과 password가 확인되었다. 이제 사용자 정보에 enable값을 검사하여 
 * 	  사용가능한 정보인지를 알아본다.
 */
@Slf4j
public class AuthProviderImpl implements AuthenticationProvider {
	
	@Autowired
	@Qualifier("userDetailServiceV1")
	private UserDetailsService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	/*
	 * 사용자가 로그인을 수행했을 때 username과 password를 주입받아서
	 * 정상적인 사용자인가를 검사하는 method
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		// 로그인한 사용자의 username과 password를 authentication 객체로부터 getter
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		// 로그인 인증하는 부분
		// 1. UserDetailService에 username을 전달하고 DB로부터 사용자정보를
		//    select한 결과를 userVO에 받는다.
		UserDetailsVO userVO = (UserDetailsVO) userService.loadUserByUsername(username);
		
		// 2. 비밀번호 검사
		// 비밀 번호를 암호화하지 않았을 경우 문자열 비교하기
//		if(!password.equals(userVO.getPassword())){ // 비밀번호 일치하지 않으면
//			throw new BadCredentialsException("비밀번호 오류");
//		}
		
		// PasswordEncoder로 암호화된 비밀번호 비교하기
		/*
		 * 사용자가 입력한 password 평문 문자열을 내부에서
		 * 암호화하여 DB에 저장되어 있는 암호화된 비번(userV).getPassword())을
		 * 비교하여 일치하는지 검사한다.
		 */
		if(!passwordEncoder.matches(password, userVO.getPassword())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않음 :(");
		};
		
		// 3. 유효한 사용자 정보인가
		if(!userVO.isEnabled()) {
			throw new BadCredentialsException(username + " 사용자 정보 사용불가");		
		}
		
		// 4. (임시) 사용자의 권한 리스트를 생성
		
		// 가. 임시로 사용자의 권한 리스트를 생성하기 위하여
		// AuthorityVO를 담은 List를 생성하고
		// 권한(ROLE)값을 지정하여 add()
//		List<AuthorityVO> authList = new ArrayList<AuthorityVO>();
//		authList.add(AuthorityVO.builder().authority("ROLE_ADMIN").build());
//		authList.add(AuthorityVO.builder().authority("ROLE_USER").build());
		
		// 나. spring security의 hasRole() method에서 사용할 자료형으로 변환
//		List<GrantedAuthority> rollList = new ArrayList<GrantedAuthority>();
		
//		for(AuthorityVO auth : authList) {
//			rollList.add(new SimpleGrantedAuthority(auth.getAuthority()));
//		}
		
		
		// 로그인한 사용자에게 인증 token을 발행
		// 사용자의 detail정보와 roll정보를 token에 같이 심어놓는다.
		return new UsernamePasswordAuthenticationToken(userVO, null, userVO.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		// supports()의 return값이 false이면 ...Token을 사용하지 않겠다는 의미
		// 반드시 true로 해줘야 한다.
		return true;
	}
	
}
