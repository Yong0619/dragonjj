<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<div id="music_se1">
	<h2>음악 검색</h2>
</div>
<div id="musicsearchsection">
	<form method="get" action="musicsearch.do" class="searchsection">
		<select name="searchField" id="music_se2">
			<!-- value값은 테이블의 열이름과 동일하게  -->
			<option value="title"<c:if test="${ map.searchField eq 'title' }">selected</c:if>>제목</option>
			<option value="lyrics"<c:if test="${ map.searchField eq 'lyrics' }">selected</c:if>>가사</option>
			<option value="artist"<c:if test="${ map.searchField eq 'artist' }">selected</c:if>>가수</option>
		</select>
	<input type="text" name="searchWord" id="mu_input1" value="${ map.searchWord }"/>
	<input type="submit" value="검색" id="mu_input2"/>
	<div class="sort searchsort">
		<select name="sort" class="sortbox" onchange="this.form.submit()">
			<!-- value값은 테이블의 열이름과 동일하게  -->
			<option value="title" <c:if test="${ map.sort eq 'title' }">selected</c:if>>제목 (오름차순)</option>
			<option value="title desc"<c:if test="${ map.sort eq 'title desc' }">selected</c:if>>제목 (내림차순)</option>
			<option value="artist desc"<c:if test="${ map.sort eq 'artist desc' }">selected</c:if>>가수 (내림차수)</option>
			<option value="artist"<c:if test="${ map.sort eq 'artist' }">selected</c:if>>가수 (오름차순)</option>
			<option value="purchasecount desc"<c:if test="${ map.sort eq 'purchasecount desc' }">selected</c:if>>많이 구매한 컨텐츠</option>		
		</select>
	</div>
	</form>
</div>
<div id="music_se3" class="sectiondiv2">
	<h2>검색 결과</h2>
	<table border="1" id="music_se4">
	<tr>
		<td>발매일</td>
		<td>엘범</td>
		<td>제목</td>
		<td>아티스트</td>
		<td>가격</td>
	</tr>
	<c:choose>
		<c:when test="${ empty mulists }">
		<tr>
			<td colspan="5">검색 결과가 없습니다.</td>
		</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${ mulists }" var="mulists" varStatus="loop">
				<tr onclick="location.href='/project01/musicpage/musicview.do?idx=${ mulists.idx }&&title=${ mulists.title }'" style="cursor:pointer;">
					<td>
						<fmt:parseDate value="${ mulists.releasedate }" var="releasedate" pattern="yyyy-MM-dd" />
						<fmt:formatDate value="${ releasedate }" pattern="yyyy.MM.dd" />	
					</td>
					<td><img src="/project01/uploads/${ mulists.sfile }"></td>
					<td>${ mulists.title }</td>
					<td>${ mulists.artist }</td>
					<td>${ mulists.price }</td>
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
