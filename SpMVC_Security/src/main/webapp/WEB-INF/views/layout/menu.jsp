<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%/* 
spring security에서 ROLE정보를 확인하여
권한에 따라 메뉴를 다르게 보이도록 하는 용도로 사용하는 taglib
*/%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<script>
	// 현재 화면의 DOM이 load된 후
	// DOMContentLoaded와 비슷한 event로 load event가 있는데
	// load event는 좀 오래전에 지정된 event이다.
	// 원래 이 event는 window.onLoad() event를 감싸는 핸들링이다.
	// 최근의 JS에서는 별로 사용을 권하지 않는 event이다.
	window.addEventListener("load", function(){
		document.querySelector("#menu-home").addEventListener("click",function(){
			document.location.href = "${rootPath}/"
		})
		
		document.querySelector("#menu-center").addEventListener("click",function(){
			document.location.href = "${rootPath}/admin"
		})
		
		document.querySelector("#menu-join").addEventListener("click",function(){
			// alert("회원가입");
			document.location.href = "${rootPath}/user/join"
		})
		
		document.querySelector("#menu-login").addEventListener("click",function(){
			document.location.href = "${rootPath}/user/login"
		})
		
		document.querySelector("#menu-mypage").addEventListener("click",function(){
			document.location.href = "${rootPath}/user/mypage"
		})
	})
</script>
<nav id="main-nav">
	<ul>
		<li id="menu-home">home</li>
		<li id="menu-center">center</li>
		<%/*
			isAnonymous()
			현재 화면에서 로그인한 세션정보를 찾을 수 없으면
			회원가입,로그인 메뉴를 보여라
		*/%>
		<sec:authorize access="isAnonymous()">
			<li id="menu-join">회원가입</li>
			<li id="menu-login">로그인</li>
		</sec:authorize>
		<%/* 
			isAuthenticated()
			현재 화면에서 권한에 관계없이 로그인한 세선 정보가 있으면
			마이페이지, 로그아웃 메뉴를 보여라
		*/%>
		<sec:authorize access="isAuthenticated()">
			<li id="menu-mypage">마이페이지</li>
			<li id="menu-logout">로그아웃</li>
		</sec:authorize>
		<%/* 
			hasRole("ROLE_ADMIN')
			로그인 세션정보가 있고, ROLE(권한)정보가 ADMIN이면
		*/%>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li id="">관리자</li>
		</sec:authorize>
		<%/* 
			hasRole("ROLE_USER')
			로그인 세션정보가 있고, ROLE(권한)정보가 USER이면
		*/%>
		<sec:authorize access="hasRole('USER')">
			<li id="">일반 사용자</li>
		</sec:authorize>
		<%/* 
			hasRole("ROLE_GUEST')
			로그인 세션정보가 있고, ROLE(권한)정보가 GUEST이면
		*/%>
		<sec:authorize access="hasRole('GUEST')">
			<li id="">손님</li>
		</sec:authorize>
	</ul>
</nav>