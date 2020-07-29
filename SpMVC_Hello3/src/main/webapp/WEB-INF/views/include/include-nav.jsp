<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
	#header{
		background-color : skyblue;
		color : white;
		padding : 1.5rem;
		text-align : center;
	}
	
	#nav{
		background-color : skyblue;
	}
	
	ul{
		margin : 0;
	}
	
	li{
		display : inline-block;
		padding : 5px;
		background-color : skyblue;
		color : white;
		cursor : pointer;
	}
	
	li:hover{
		background-color : teal;
		color : white;
	}
	
	a{
		color : white;
		text-decoration : none;
	}
</style>

<div id="header">
<h3>반갑습니다</h3>
<p>나의 spring MVC project v1</p>
</div>

<div id="nav">
	<ul>
		<li><a href="http://localhost:8080/hello/">home</a></li>
		<li><a href="home2">나의집</a></li>
		<li><a href="home3">너의집</a></li>
		<li><a href="home4">우리집</a></li>
		<li><a href="home5">친구집</a></li>
	</ul>
</div>

