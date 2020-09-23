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
</head>
<body>
<style>
	*{
		box-sizing: border-box;
		padding: 0;
		margin: 0;
	}
	
	html, body{
		width: 100%;
		height: 100%;
	}
	
	body{
		overflow: auto;
	}
	
	form#books{
		width: 60%;
		margin: 10px auto;
	}
	
	form#books input{
		/*
		만약 input box와 button 등 여러 tag를 한줄에 나란히 놓으면서
		input box의 width를 임의로 설정하고 싶으면
		display를 inline-block으로 설정하자
		
		block으로 설정하면 width는 임의로 설정할 수 있지만
		다른 tag를 오른쪽에 위치하게 할 수 없다
		
		기본값인 inline이면 widht를 설정할 수 없다.
		*/
		display: inline-block;
		width: 90%;
		border: 1px solid #ddd;
		margin: 5px auto;
		padding: 8px;
	}
	
	form#books fieldset{
		border:2px dashed rgb(0,100,200);
		border-radius: 10px;
	}
	
	form#books #title{
		width: 80%;
	}
	
	form#books div.button-box{
		width: 91%;
		text-align: right;
	}
	
	form#books button{
		border: none;
		outline: 0;
		
		padding: 0.5rem 12px;
		border-radius: 5px;
	}
	
	form#books button#naver-search{
		background-color: green;
		color: white;
	}
	
	form#books button#btn-save{
		background-color: blue;
		color: white;
	}
	
	form#books button:hover{
		box-shadow: 3px 3px rgba(0,0,0,0.3);
	}
	
	section#book-modal{
		display: none;
		align-items: center;
		justify-content: center;
		position: fixed;
		top: 0;
		left: 0;
		height: 100%;
		width: 100%;
		background-color: rgba(0,0,0,0.4);
	}
	
	section#book-modal div{
		width: 60%;
		height: 70%;
		background-color: rgba(255,255,255,1);
		border: 2px solid rgba(255,0,255,1);
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#naver-search").click(function(){
			let title = $("title").val()
			if(title == ""){
				alert("도서명을 입력한 후 검색하세요:)")
				$("#title").focus()
				return false
			}
			
			// ajax를 사용하여 서버에 네이버 검색 요청
			$.ajax({
				url : "${rootPath}/naver/search",
				method : "POST",
				data : {"search-text" : title},
				success : function(result){
					
				},
				error : function(error){
					alert("서버 통신 오류 :(")	
				}
			})
			
			$("section#book-modal").css("display","flex")
		})
		
		$("#book-modal").click(function(){
			$("#book-modal").css("display","none")
		})
	})
</script>
<h3>도서정보 등록</h3>
<form method="POST" id="books">
	<fieldset>
		<legend>도서정보 입력</legend>
		<input name="seq" id="seq" placeholder="일련번호"/>
		<input name="title" id="title" placeholder="도서명"/>
		<button id="naver-search" type="button">네이버 검색</button>
		<input name="link"  id="link" placeholder="상세링크"/>
		<input name="image"  id="image" placeholder="이미지"/>
		<input name="author"  id="author" placeholder="저자"/>
		<input name="price"  id="price" placeholder="가격"/>
		<input name="discount"  id="discount" placeholder="할인"/>
		<input name="publisher"  id="publisher" placeholder="출판사"/>
		<input name="isbn"  id="isbn" placeholder="isbn"/>
		<input name="description"  id="description" placeholder="세부설명"/>
		<input name="pubdate"  id="pubdate" placeholder="출간일자"/>
		<input name="buydate"  id="buydate" placeholder="구입일자"/>
		<input name="buyprice"  id="buyprice" placeholder="구입금액"/>
		<input name="buystore"  id="buystore" placeholder="구입처"/>
		<div class="button-box">
			<button id="btn-save" type="button">저장</button>
		</div>
	</fieldset>
</form>
<section id="book-modal">
	<div id="search-result"></div>
</section>
</body>
</html>