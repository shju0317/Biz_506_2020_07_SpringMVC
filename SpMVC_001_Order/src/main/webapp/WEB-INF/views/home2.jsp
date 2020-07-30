<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>나의 홈페이지</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css"> 
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section>
		<h3>반갑습니다</h3>
		<p>나는 ${page} 입니다.</p>
	</section>
	<section>
		<img src="resources/images/jupiter.jpg" alt = "목성 이미지" width="200px">
	</section>
	<footer>
		<address>CopyRight &copy; shju0317@naver.com</address>
	</footer>
</body>
</html>