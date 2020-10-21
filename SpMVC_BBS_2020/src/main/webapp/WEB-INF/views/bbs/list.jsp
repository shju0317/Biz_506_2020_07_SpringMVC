<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>   
<script>
	document.addEventListener("DOMContentLoaded", function(){
		document.querySelector("#bbs-write").addEventListener("click",function(){
			document.location.href="${rootPath}/bbs/write"
		})
		
		/*
		tag들이 서로 감싸는 관계로 layout이 만들어져 있을 때
		tag들에 click event핸들링이 설정되어 있으면
		어떤 특정 tag를 click했을 때 원하지 않는 event가 발생하는 경우가 있다.
		이러한 현상을 이벤트버블링이라고 한다.
		tag box의 가장 중간부분에 있는 tag를 클릭하면 안쪽부터 바깥쪽으로
		계속해서 이벤트가 전해지는 현상
		이러한 현상을 막기 위해 event.stopPropagation() 등의 함수를 사용하여
		버블링을 막아준다.
		
		이 버블링을 역으로 효과적으로 이용할 수 있는데
		td를 감싸고 있는 table에 click event를 설정하고
		td에서는 click event를 제거해주면
		
		결국 td를 click했을 때 해야할 일을 table의 click event에서
		통합으로 관리를 할 수 있다.
		복잡한 event코드같으면 td에서 처리하는 것이 효과적일 수도 있지만
		짧은 코드를 반복하지 않고 처리하기 위해서 table에서 처리를 한다.
		
		이러한 기법을 '이벤트 위임'이라고 한다.
		*/
	
	    document.querySelector("table").addEventListener("click", function (event) {
	        let tag_name = event.target.tagName;
	        //alert(tag_name);

	        if (tag_name == "TD") {
	        	
	        	//제목이 저장된 td에서 seq값 추출
				//let seq = event.target.dataset.seq;
				
				// td가 클릭되었으면 현재 클릭된 td와 가장 인접한 tr을 참조하겠다.
				// 클릭된 td를 기준으로 tr에서 seq값 추출
				let seq = event.target.closest("TR").dataset.seq;
				if(seq){
					//alert(seq);
					document.location.href="${rootPath}/bbs/detail/"+seq
				}
	        }
	      });
	})
	
	/*
	$(function(){
		$(".bbs-tr").click(function(){
			let seq = $(this).data("seq")
			document.location.href="{rootPath}/bbs/detail"+seq;
		})
	})
	*/
</script> 
<style>
	td.bbs-tr{
		cursor : pointer;
	}
	
	ttd.bbs-tr:hover {
		background-color: #ddd;
	}
</style>
<table class="table table-striped table-bordered table-hover">
	<thead>
	<tr>
		<th>No</th>
		<th>작성일자</th>
		<th>작성시각</th>
		<th>작성자</th>
		<th>제목</th>
		<th>조회수</th>
	</tr>
	</thead>
	<tbody>
		<c:if test="${empty BBS_LIST}">
			<tr><td colspan="6">데이터가 없습니다</td></tr>
		</c:if>
		<c:forEach items="${BBS_LIST}" var="vo" varStatus="i">
			<tr class="bbs-tr" data-seq="${vo.b_seq}">
				<td>${i.count}</td>
				<td>${vo.b_date}</td>
				<td>${vo.b_time}</td>
				<td>${vo.b_writer}</td>
				<td data-seq="${vo.b_seq}" class="bbs-subject">
				${vo.b_subject}
				<img src="${rootPath}/upload/${vo.b_file}" width="50px">
				</td>
				<td>${vo.b_count}</td>
			</tr>
		</c:forEach>	
	</tbody>
</table>
<button id="bbs-write">글쓰기</button>