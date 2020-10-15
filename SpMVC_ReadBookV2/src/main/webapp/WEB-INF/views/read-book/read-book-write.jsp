<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/> 
<style>
	form#read-book-write{
		display: flex;
		padding: 5px;
	}
	form#read-book-write input,
	form#read-book-write button{
		flex: 1;
		margin: 5px 2px;
		padding: 8px;
		border: 1px solid rgb(102, 102, 153);;
		outline: none;
	}
	form#read-book-write input[name='r_comment']{
		flex: 5;
	}
	
	button#btn-save{
		margin: 5px;
		padding: 10px 18px;
		outline: none;
		border: 0;
		border-radius:3px;
		background-color: rgb(102, 102, 153);
		color: white;
	}
</style>   

<form:form id="read-book-write" action="${rootPath}/read/write" modelAttribute="readBookVO">
	<form:input path="r_book_seq" type="hidden" value="${BOOKVO.seq}"/>
	<form:input path="r_date" type="date" placeholder="읽은 날짜"/>
	<form:input path="r_stime" type="time" placeholder="읽기 시작한 시각"/>
	<form:input path="r_etime" type="time" placeholder="읽기 종료한 시각"/>
	<form:input path="r_comment" placeholder="읽은 소감"/>
	<button id="btn-save">저장</button>
</form:form>
<style>
	table#rbook{
		width: 95%;
		border: 1px solid #ddd;
		border-collapse: collapse;
		margin: 5px auto;
	}
	
	table#rbook tr{
		border-bottom: 1px solid #aaa;
	}
	
	table#rbook td, table#rbook th{
		padding: 10px;
		text-align: left;
	}
	
	table#rbook tr:nth-child(odd){
		background-color: #ddd;
	}
	
	table#rbook tr:nth-child(even){
		background-color: #fff;
	}
</style>
<table id="rbook">
	<tr>
		<th>읽은날짜</th>
		<th>시작</th>
		<th>종료</th>
		<th>소감</th>
	</tr>
	<c:forEach items="${READ_BOOK}" var="vo">
		<tr>
			<td>${vo.r_date}</td>
			<td>${vo.r_stime}</td>
			<td>${vo.r_etime}</td>
			<td>${vo.r_comment}</td>
		</tr>
	</c:forEach>
</table>