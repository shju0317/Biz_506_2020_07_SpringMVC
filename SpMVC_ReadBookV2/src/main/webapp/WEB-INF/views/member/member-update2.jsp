<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/member-write.css?ver=2020-09-28"/>

<%/*
member-write.jsp에서 Controller를 호출하고
Controller에서 member-write2.jsp를 열어서 회원가입을 두 화면에 나누어서 실행한다.
이 때 member-write.jsp에 입력한 항목은
@SessionAttributes()와 @ModelAttribute()로 설정되어있기 때문에
마치 한개의 form에 모든 input box가 있고, 한번 모든 값을 입력한 것과 똑같은 효과를 낸다.
*/%>
<form:form modelAttribute="memberVO" id="member-write" action="${rootPath}/member/update_comp">
	<fieldset>
		<legend>회원정보 수정</legend>
		<div>
			<label>회원명</label>
			<form:input path="m_name"/>
		</div>
		<div>
			<label>이메일</label>
			<form:input path="m_email"/>
		</div>
		<div>
			<label>전화번호</label>
			<form:input path="m_tel"/>
		</div>
		<div>
			<label>주소</label>
			<form:input path="m_address"/>
		</div>
		<div id="btn_box">
			<button type="button" id="btn_home">홈으로</button>
			<button type="submit" id="btn_save">정보수정</button>
		</div>
	</fieldset>
</form:form>