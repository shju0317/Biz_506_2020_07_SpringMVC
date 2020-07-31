<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section>
		<h3>반갑습니다</h3>
		<p>나는 ${name} 입니다.<br/>&nbsp;반갑습니다</p>
		<p id="p1">& nbsp ; 는 Non-Breaking space 의 약자로 web page에서 문서를 작성할 때<br/>
		단어와 단어 사이에 강제로 빈칸을 추가하고자 할때 사용하는 특수문자<br/>
		web page에서는 space(공백)문자는 개수에 관계없이 1개만  표시되기 때문에<br/>
		단어와 단어 사이에 많은 개수의 빈칸을 넣고 싶으면 $ nbsp ; 특수코드를 넣는다.</p>
		<hr/>
		<p id="p2">& nbsp ; 는 Non-Breaking space 의 약자로 web page에서 문서를 작성할 때<br/>
		단어와 단어 사이에 강제로 빈칸을 추가하고자 할때 사용하는 특수문자<br/>
		web page에서는 space(공백)문자는 개수에 관계없이 1개만  표시되기 때문에<br/>
		단어와 단어 사이에 많은 개수의 빈칸을 넣고 싶으면 $ nbsp ; 특수코드를 넣는다.</p>
		<hr/>
		<p id="p3">& nbsp ; 는 Non-Breaking space 의 약자로 web page에서 문서를 작성할 때<br/>
		단어와 단어 사이에 강제로 빈칸을 추가하고자 할때 사용하는 특수문자<br/>
		web page에서는 space(공백)문자는 개수에 관계없이 1개만  표시되기 때문에<br/>
		단어와 단어 사이에 많은 개수의 빈칸을 넣고 싶으면 $ nbsp ; 특수코드를 넣는다.</p>
		<p>
			<pre>
				우리는 대한민국    사람입니다.
				Republic of Korea
				&nbsp; 우리나라만세
			</pre>
		</p>
	</section>
	<section>
		<img src="resources/images/jupiter.jpg" alt = "목성 이미지" width="200px">
	</section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>