<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<div id="drama_se1">
	<h2>드라마 검색</h2>
</div>
<div id="dramasearchsection">
	<form method="get" action="dramasearch.do" class="searchsection">
		<select name="searchField" id="drama_se2">
			<!-- value값은 테이블의 열이름과 동일하게  -->
			<option value="title" <c:if test="${ map.searchField eq 'title' }">selected</c:if>>제목</option>
			<option value="cast" <c:if test="${ map.searchField eq 'cast' }">selected</c:if>>배우</option>
		</select>
		<input type="text" name="searchWord" id="dr_input1" value="${ map.searchWord }"/>
		<input type="submit" value="검색" id="dr_input2"/>
		<div class="sort searchsort">
			<select name="sort" class="sortbox" onchange="this.form.submit()">
				<!-- value값은 테이블의 열이름과 동일하게  -->
				<option value="title" <c:if test="${ map.sort eq 'title' }">selected</c:if>>제목 (오름차순)</option>
				<option value="title desc"<c:if test="${ map.sort eq 'title desc' }">selected</c:if>>제목 (내림차순)</option>
				<option value="releasedate desc"<c:if test="${ map.sort eq 'releasedate desc' }">selected</c:if>>방영일 (최근)</option>
				<option value="releasedate"<c:if test="${ map.sort eq 'releasedate' }">selected</c:if>>방영일 (오래된)</option>
				<option value="purchasecount desc"<c:if test="${ map.sort eq 'purchasecount desc' }">selected</c:if>>많이 구매한 컨텐츠</option>		
			</select>
		</div>
	</form>
</div>
<div id="drama_se3" class="sectiondiv2">
	<div>
		<h2>검색 결과</h2>
		
	</div>
	<table border="1" id="drama_se4">
	<tr>
		<td>방영연도</td>
		<td>포스터</td>
		<td>제목</td>
		<td>에피소드</td>
		<td>출연</td>
		<td>가격</td>
	</tr>
	<c:choose>
		<c:when test="${ empty drlists }">
		<tr>
			<td colspan="6">검색 결과가 없습니다.</td>
		</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${ drlists }" var="drlists" varStatus="loop">
				<tr onclick="location.href='/project01/contents/dramaview.do?idx=${ drlists.idx }&&title=${ drlists.title }&&episode=${ drlists.episode }'" style="cursor:pointer;">
					<td>
						<fmt:parseDate value="${ drlists.releasedate }" var="releasedate" pattern="yyyy-MM-dd" />
						<fmt:formatDate value="${ releasedate }" pattern="yyyy.MM.dd" />	
					</td>
					<td><img src="/project01/uploads/${ drlists.sfile }" id="drama_se4img"></td>
					<td>${ drlists.title }</td>
					<td>에피소드 ${ drlists.episode }</td>
					<td>${ drlists.cast }</td>
					<td>${ drlists.price }</td>
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