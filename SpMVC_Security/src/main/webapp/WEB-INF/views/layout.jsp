<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
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
		padding: 0;
	}
	
	html,body{
		width: 100%;
		height: 100%;
	}
	
	body{
		display: flex;
		flex-direction:column;
	}
	
	header{
		padding: 2rem;
		background-color: #c7aabc;
		text-align: center;
		color: #513e5c;
		text-transform:uppercase;
	}
	
	nav#main-nav ul{
		list-style: none;
		display: flex;
		background-color: #02334a;
	}
	
	nav#main-nav li{
		padding: 8px 16px;
		margin: 0px 5px;
		color: white;
		border: 2px solid #02334a;
		text-transform:uppercase;
	}
	
	nav#main-nav li:hover{
		border-bottom: 2px solid #a9bcc6;
		cursor: pointer;
	}
	
	nav#main-nav li:nth-child(3){
		margin-left: auto;
	}
	
	footer{
		background-color: #c7aabc;
		color: #513e5c;
		text-align: center;
		padding: 0.5rem;
	}
</style>  
</head>
<body>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="menu"/>
	<tiles:insertAttribute name="content"/>
	<tiles:insertAttribute name="footer"/>
</body>
</html>