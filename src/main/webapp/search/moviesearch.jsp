<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<div id="movie_se1">
	<h2>영화 검색</h2>
</div>
<div id="moviesearchsection">
	<form method="get" action="moviesearch.do" class="searchsection">
		<select name="searchField" id="movie_se2">
			<!-- value값은 테이블의 열이름과 동일하게  -->
			<option value="title" <c:if test="${ map.searchField eq 'title' }">selected</c:if>>제목</option>
			<option value="cast" <c:if test="${ map.searchField eq 'cast' }">selected</c:if>>배우</option>
		</select>
	<input type="text" name="searchWord" id="mo_input1" value="${ map.searchWord }"/>
	<input type="submit" value="검색" id="mo_input2"/>
	<div class="sort searchsort">
		<select name="sort" class="sortbox" onchange="this.form.submit()">
			<!-- value값은 테이블의 열이름과 동일하게  -->
			<option value="title" <c:if test="${ map.sort eq 'title' }">selected</c:if>>제목 (오름차순)</option>
			<option value="title desc"<c:if test="${ map.sort eq 'title desc' }">selected</c:if>>제목 (내림차순)</option>
			<option value="releasedate desc"<c:if test="${ map.sort eq 'releasedate desc' }">selected</c:if>>개봉일 (최근)</option>
			<option value="releasedate"<c:if test="${ map.sort eq 'releasedate' }">selected</c:if>>개봉일 (오래된)</option>
			<option value="purchasecount desc"<c:if test="${ map.sort eq 'purchasecount desc' }">selected</c:if>>많이 구매한 컨텐츠</option>		
		</select>
	</div>
	</form>
</div>
<div id="movie_se3" class="sectiondiv2">
	<h2>검색 결과</h2>
	<table border="1" id="movie_se4">
	<tr>
		<td>개봉일</td>
		<td>포스터</td>
		<td>제목</td>
		<td>출연</td>
		<td>가격</td>
	</tr>
	<c:choose>
		<c:when test="${ empty molists }">
		<tr>
			<td colspan="5">검색 결과가 없습니다.</td>
		</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${ molists }" var="molists" varStatus="loop">
				<tr onclick="location.href='/project01/contents/movieview.do?idx=${ molists.idx }&&title=${ molists.title }'" style="cursor:pointer;">
					<td>
						<fmt:parseDate value="${ molists.releasedate }" var="releasedate" pattern="yyyy-MM-dd" />
						<fmt:formatDate value="${ releasedate }" pattern="yyyy.MM.dd" />	
					</td>
					<td><img src="/project01/uploads/${ molists.sfile }" id="movie_se4img"></td>
					<td>${ molists.title }</td>
					<td>${ molists.cast }</td>
					<td>${ molists.price }</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
	<div class="paging">
		${ map.pagingStr }
	</div>
</div>
<%@ include file="/include/footer.jsp"%>