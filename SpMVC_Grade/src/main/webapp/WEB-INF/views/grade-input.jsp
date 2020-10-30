<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>📑SpMVC_Grade</title>
<style>
	h3{
		text-align: center;
	}
	
	form div{
		width: 70%;
		margin: 10px auto;
	}
	
	form label, input{
		display: inline-block;
		margin: 5px 3px;
		padding :5px;
	}
	
	form label{
		width:30%;
		text-align: right;
	}
	
	form input{
		width: 50%;
	}
	
	form div:last-child{
		text-align: right;
		border: none;
		outlint: none;
		padding: 3px;
	}
	
	button{
		width: 50px;
		padding: 5px 7px;
		border: none;
		outline: none;
		background-color: green;
		border-radius: 5px;
	}
</style>
</head>
<body>
<h3>성적 입력</h3>
<form method="POST">
	
	<div>
		<label>학번</label>
		<input name="g_sid" value="${GRADE.g_sid}"/>
	</div>
	<div>
		<label>이름</label>
		<input name="g_name" value="${GRADE.g_name}"/>
	</div>
	<div>
		<label>국어</label>
		<input name="g_kor" value="${GRADE.g_kor}"/>
	</div>
	<div>
		<label>영어</label>
		<input name="g_eng" value="${GRADE.g_eng}"/>
	</div>
	<div>
		<label>수학</label>
		<input name="g_math" value="${GRADE.g_math}"/>
	</div>
	<div>
		<label>총점</label>
		<input name="g_total" value="${GRADE.g_total}"/>
	</div>
		<div>
		<label>평균</label>
		<input name="g_avg" value="${GRADE.g_avg}"/>
	</div>
	<div>
		<button>저장</button>
	</div>
</form>
</body>
</html>