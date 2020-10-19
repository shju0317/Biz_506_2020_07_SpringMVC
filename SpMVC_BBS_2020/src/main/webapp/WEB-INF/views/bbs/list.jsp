<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>   
<script>
	document.addEventListener("DOMContentLoaded", function(){
		document.querySelector("#bbs-write").addEventListener("click",function(){
			document.location.href="${rootPath}/bbs/write"
		})
	})
</script> 
<table>
	<tr>
		<th>No</th>
		<th>작성일자</th>
		<th>작성시각</th>
		<th>작성자</th>
		<th>제목</th>
		<th>조회수</th>
	</tr>
	<tr>
		<td>No</td>
		<td>작성일자</td>
		<td>작성시각</td>
		<td>작성자</td>
		<td>제목</td>
		<td>조회수</td>
	</tr>
</table>
<button id="bbs-write">글쓰기</button>