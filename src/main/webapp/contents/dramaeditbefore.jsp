<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<h2 class="hdlist_h2">드라마 수정 목록</h2>
<form name="dramaEditForm" method="post" action="dramaedit.do"
	enctype="multipart/form-data" onsubmit="return validateForm(this)">
	<input type="hidden" name="title" value="${param.title}" /> 
	<input type="hidden" name="idx" value="${param.idx}" />
<!--  수정버튼 (관리자만 보이도록) -->
<c:choose>
	<c:when test="${ id != null && UserName == '관리자'}">
		<table id="hdmovietable">
			<tr>
				<td>방송일</td>
				<td>이미지</td>
				<td>제목</td>
				<td>에피소드</td>
				<td>수정</td>
			</tr>
			<c:forEach items="${ episodelist }" var="episodelist" varStatus="loop">
			<tr>
				<td
					onclick="location.href='/project01/contents/dramaview.do?idx=${ episodelist.idx }&&title=${ episodelist.title }'"
					style="cursor: pointer;">
					<fmt:parseDate value="${ episodelist.releasedate }" var="releasedate" pattern="yyyy-MM-dd" />
					<fmt:formatDate value="${ releasedate }" pattern="yyyy.MM.dd" />	
				</td>
				<td
					onclick="location.href='/project01/contents/dramaview.do?idx=${ episodelist.idx }&&title=${ episodelist.title }'"
					style="cursor: pointer;"><img src="../uploads/${ episodelist.sfile }"
					id="hdmovieimg"></td>
				<td
					onclick="location.href='/project01/contents/dramaview.do?idx=${ episodelist.idx }&&title=${ episodelist.title }'"
					style="cursor: pointer;">${ episodelist.title }</td>
				<td
					onclick="location.href='/project01/contents/dramaview.do?idx=${ episodelist.idx }&&title=${ episodelist.title }'"
					style="cursor: pointer;">${ episodelist.episode }</td>
		
				<td id="btn5"><button type="button"
						onclick="location.href='/project01/contents/dramaEdit.do?idx=${ episodelist.idx }&title=${ episodelist.title }'">수정하기</button></td>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<%-- 관리자가 아니거나 로그인이 아닌경우 --%>
	<c:otherwise>
		<h2 class="hdlist_h2">관리자로 로그인하세요.</h2>
	</c:otherwise>
</c:choose>
</form>
<%@ include file="/include/footer.jsp"%>