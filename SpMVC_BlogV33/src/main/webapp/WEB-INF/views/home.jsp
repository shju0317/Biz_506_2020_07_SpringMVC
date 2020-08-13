<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<section id="main">
		<article id="button">
			<button><a href="${rootPath}/blog/input">블로그 작성</button>
		</article>
		<article id="blog_body">
			<section class="blog_title">
				<h3>윤동주 - 자화상</h3>
			</section>
			<section class="blog_text">
				<h5>
				산모퉁이를 돌아 논가 외딴 우물을 홀로
				찾아가선 가만히 들여다봅니다.
				</h5>
				<h5>
				우물 속에는 달이 밝고 구름이 흐르고
				</h5>
				<h5>
				하늘이 펼치고 파아란 바람이 불고 가을이 있습니다.
				</h5>
				<h5>
				그리고 한 사나이가 있습니다.
				어쩐지 그 사나이가 미워져 돌아갑니다.
				</h5>
				<h5>
				돌아가다 생각하니 그 사나이가 가엾어집니다. 
				</h5>
				<h5>
				도로 가 들여다보니 사나이는 그대로 있습니다.
				</h5>
				<h5>
				다시 그 사나이가 미워져 돌아갑니다.
				</h5>
				<h5>
				돌아가다 생각하니 그 사나이가 그리워집니다.
				</h5>
				<h5>
				우물 속에는 달이 밝고 구름이 흐르고 하늘이 펼치고 파아란 바람이 불고 가을이 있고 추억처럼 사나이가 있습니다.
				</h5>
			</section>
		</article>
	</section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>