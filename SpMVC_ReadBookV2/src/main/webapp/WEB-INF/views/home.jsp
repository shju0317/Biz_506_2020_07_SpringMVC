<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Read Book 2020</title>
<link href="${rootPath}/static/css/index.css?ver=2020-09-25-006" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	// js파일에서 el tag의 ${rootPath}값을 참조하기 위해서
	// rootPath를 전역변수로 선언해둔다.
	var rootPath = "${rootPath}"
	
	// main-nav.js 파일에서 el tag 변수값을 사용할 수 없기 때문에
	// 별도로 2개의 변수를 선언하고,
	// 각각 headerName과 token 값을 저장해준다.
	// *.js 파일에서는 백팃을 사용하여 해당 변수를 사용할 수 있다.
	var csrf_header = "${_csrf.headerName}"
	var csrf_token = "${_csrf.token}"
</script>
<script src="${rootPath}/static/js/main-nav.js?ver=2020-10-07-003"></script>
</head>
<body>
	<header>
		<h1>Read Book</h1>
	</header>
	<nav id="main-nav">
		<ul>
			<li id="menu-home">Read Book</li>
			<li id="menu-books">도서정보</li>
			<li id="menu-read-book">독서록</li>
			<li>네이버검색</li>

			<sec:authorize access="isAnonymous()">
				<li id="menu-join">회원가입</li>
				<li id="menu-login">로그인</li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li id="menu-mypage">마이페이지</li>
				<li id="menu-logout">로그아웃</li>
			</sec:authorize>
			<sec:authorize access="hasRole('ADMIN')">
				<li>관리자</li>
			</sec:authorize>
		</ul>
	</nav>
	<section id="main-section">
		<c:choose>
			<c:when test="${BODY == 'BOOK-LIST'}">
				<%@ include file="/WEB-INF/views/books/book-list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'BOOK-WRITE'}">
				<%@ include file="/WEB-INF/views/books/book-write.jsp"%>
			</c:when>
			<c:when test="${BODY == 'BOOK-DETAIL'}">
				<%@ include file="/WEB-INF/views/books/book-detail.jsp"%>
			</c:when>
			<c:when test="${BODY == 'MEMBER-JOIN'}">
				<%@ include file="/WEB-INF/views/member/member-write.jsp"%>
			</c:when>
			<c:when test="${BODY == 'MEMBER-JOIN-NEXT'}">
				<%@ include file="/WEB-INF/views/member/member-write2.jsp"%>
			</c:when>
			<c:when test="${BODY == 'MEMBER-UPDATE'}">
				<%@ include file="/WEB-INF/views/member/member-update.jsp"%>
			</c:when>
			<c:when test="${BODY == 'MEMBER-UPDATE-NEXT'}">
				<%@ include file="/WEB-INF/views/member/member-update2.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main-body.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
	<footer>
		<address>&copy; shju0317@naver.com ღ'ᴗ'ღ 2020</address>
	</footer>
</body>
</html>
