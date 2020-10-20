<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<style>
	form#write-form{
		width: 80%;
		margin: 10px auto;
	}
	
	form#write-form fieldset{
		border: 1px solid #485123;
		border-radius: 7px;
	}
	form#write-form legend{
		color: #485123;
		margin: 5px;
		padding: 5px;
	}
	
	form#write-form label{
		display: inline-block;
		width: 20%;
		padding: 4px;
		margin: 4px;
		color: #485123;
		text-align: right;
		font-weight: bold;
	}
	
	form#write-form input{
		display: inline-block;
		width: 70%;
		padding: 4px;
		margin: 4px;
	}
	
	form#write-form textarea{
		width: 70%;
	}
	
	div.button-box{
		text-align:right;
	}
	
	form#write-form .button-box button{
		color: white;
		border: none;
		border-radius: 5px;
		outline: 0;
		cursor: pointer;
		padding: 10px 16px;
		margin: 5px;
	}
	
	form#write-form button:hover{
		box-shadow: 2px 2px 2px rgba(0,0,0,0.5);
	}
	
	button#list{
		background-color:#485123;
	}
	
	button#save{
		background-color:#eadd46;
	}
</style>
<script>
	$(function(){
		var toolbar = [
			['style',['bold','italic','underline'] ],
			['fontsize',['fontsize']],
			['font Style',['fontname']],
			['color',['color']],
			['para',['ul','ol','paragraph']],
			['height',['height']],
			['table',['table']],
			['insert',['link','hr','picture']],
			['view',['fullscreen','codeview']]	
		]
		
		$("#b_content").summernote({
			lang:"ko-KR", width:"80%", height:"250px",toolbar: toolbar
				});
	})
</script>
<form id="write-form" method="POST" enctype="multipart/form-data">
	<fieldset>
	<legend>글쓰기</legend>
	<div>
		<label>작성일자</label>
		<input name="b_date">
	</div>
	<div>
		<label>작성시각</label>
		<input name="b_time">
	</div>
	<div>
		<label>글쓴이</label>
		<input name="b_writer">
	</div>
	<div>
		<label>제목</label>
		<input name="b_subject">
	</div>
	<div>
		<label></label>
		<textarea id="b_content" rows="5" cols="25" name="b_content"></textarea>
	</div>
	<div>
		<label>이미지</label>
		<input type="file" name="file" accept="image/*">
	</div>
	<div class="button-box">
		<button type="button" id="list">리스트</button>
		<button type="submit" id="save">저장</button>
	</div>
	</fieldset>	
</form>