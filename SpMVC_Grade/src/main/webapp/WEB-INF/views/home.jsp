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
	
	table#grade-list{
		width: 80%;
		margin: 10px auto;
		border-collapse: collapse;
		border: 1px solid #ccc;
	}
	
	th, td{
		border: 1px solid #ccc;
	}
	
	th{
		background-color: green;
		color: white;
	}
</style>
</head>
<body>
<h3>grade list</h3>
<table id="grade-list">
	<tr>
		<th>학번</th>
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
		<th>기타</th>
	</tr>	
	<c:if test="${empty GRADE_LIST}">
		<tr><td colspan="8">📄데이터가 없습니다</td></tr>
	</c:if>
	<c:forEach items="${GRADE_LIST}" var="grade">
		<tr>
			<td><a href="${rootPath}/update?id=${grade.id}">${grade.g_sid}</a></td>
			<td>${grade.g_name}</td>
			<td>${grade.g_kor}</td>
			<td>${grade.g_eng}</td>
			<td>${grade.g_math}</td>
			<td>${grade.g_total}</td>
			<td>${grade.g_avg}</td>
			<td><a href="${rootPath}/delete?id=${grade.id}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<div>
	<a href="${rootPath}/input">성적입력</a>
</div>
</body>
</html>