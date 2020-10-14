<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Spring Framework~!!</title>
<style>
	*{
		box-sizing: border-box;
		margin: 0;
	}
 	form{
 		width: 40%;
 		height: 50%;
 		background-color: #b8e3ea;
 		box-shadow: 5px 5px 5px #a9bcc6;
 		margin: 20px auto;
 		padding: 10px auto;
 		justify-content: center;
 		text-align: center;
 	}
 	
 	form h2{
 		color: #513e5c;
 		padding: 10px;
 	}
 	
 	div#login-wrapper{
 		display:block;
 	 	justify-content: center;
 		align-items: center;
 	}
 	
 	form input{
 		display: block;
 		color: #02334a;
 		margin: 5px auto;
 		width: 300px;
 		height: 40px;
 		border: 1px solid #c7aabc;
 		background-color: #c7aabc;
 		color: #02334a;
 		padding: 5px;

 	}
 	
 	form button{
 		padding: 3px 10px;
 		margin-top:10px;
 		border: none;
 		background-color: #02334a;
 		color: white;
 		box-shadow: 2px 2px 1px #a9bcc6;
 		width: 300px;
 		height: 2rem;
 		font-size: 15px;
 	}
 
 	h4#login-fail{
 		margin: 5px auto;
 		color: red;
 		padding: 8px;
 	}
</style>
</head>
<body>
<form action="${rootPath}/login" method="POST">
	<h2>로그인</h2>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		<h4 id="login-fail">${SPRING_SECURITY_LAST_EXCEPTION.message}</h4>
		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
	</c:if>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div id="login-wrapper">
	<input name="username" placeholder="ID">
	<input name="password" type="password" placeholder="PASSWORD">
	<button>로그인</button>
	</div>
</form>
</body>
</html>