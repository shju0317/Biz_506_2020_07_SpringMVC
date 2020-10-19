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
<title>💕BBS 2020💕</title>
<style>
	*{
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	
	html, body{
		width: 100%;
		height: 100%;
	}
	
	body{
		display: flex;
		flex-direction: column;
	}

	header{
		background-color: #485123;
		color: #fff9f1;
		padding: 1.2rem;
		text-align: center;
	}
	
	nav ul{
		list-style: none;
		display: flex;
		background-color: #eadd46;
		color: #596a71;
	}
	
	nav ul li{
		display: inline-block;
		margin: 0 10px;
		padding: 6px 12px;
		cursor: pointer;
	}
	
	nav ul li:hover{
		background-color: #ddd;
		color: #485123;
	}
	
	/*
		body를 flex로 선언하고
		content가 위치하는 box에 flex값을 1로 선언하면
		화면에 가득차는 layout이 만들어진다.
		
		html, body의 height를 100%로 설정해주어야 한다.
		overflow:auto로 설정을 하면 내용이 화면을 넘어갈 때 자동으로 스크롤바 생성
	*/
	section#content{
		flex: 1;
		overflow: auto;
	}
	
	footer{
		background-color: #596a71;
		color: white;
		text-align: center;
		padding: 0.7rem;
	}
</style>
</head>
<body>
	<%/*
	tiles:insertAttribute
	다른 jsp파일을 부착하는 용도의 설정값
	여기에 name으로 설정된 부분에 tile.xml 파일에서 지정한 jsp파일이 부착된다
	*/%>
	<tiles:insertAttribute name="header"/>
	<tiles:insertAttribute name="nav"/>
	<section id="contents">
		<tiles:insertAttribute name="contents"/>
	</section>	
	<tiles:insertAttribute name="footer"/>
</body>
</html>