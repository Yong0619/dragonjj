<%@page import="java.util.List"%>
<%@ include file="/include/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<div class="hdlist_hd">
	<h2 class="hdlist_h2">HOT & NEW</h2>
	<div class="sort">
		<form method="post" action="musicList.do">
			<select name="sort" class="sortbox" onchange="this.form.submit()">
				<!-- value값은 테이블의 열이름과 동일하게  -->
				<option value="artist desc" <c:if test="${ map.sort eq 'artist' }">selected</c:if>>가수</option>
				<option value="title" <c:if test="${ map.sort eq 'title' }">selected</c:if>>제목 (오름차순)</option>
				<option value="title desc"<c:if test="${ map.sort eq 'title desc' }">selected</c:if>>제목 (내림차순)</option>
				<option value="releasedate desc"<c:if test="${ map.sort eq 'releasedate desc' }">selected</c:if>>발매일 (최근)</option>
				<option value="releasedate"<c:if test="${ map.sort eq 'releasedate' }">selected</c:if>>발매일 (오래된)</option>
				<option value="purchasecount desc"<c:if test="${ map.sort eq 'purchasecount desc' }">selected</c:if>>많이 구매한 컨텐츠</option>		
			</select>
		</form>
	</div>
</div>
<!--  수정버튼 (관리자만 보이도록) -->
<c:choose>
	<c:when test="${ id != null && UserName == '관리자'}">
		<table id="hdmovietable">
			<tr>
				<td>수정</td>
				<td>포스터</td>
				<td>제목</td>
				<td>엘범</td>
				<td>가수</td>
				<td>가격</td>
			</tr>
			<c:forEach items="${ mulists }" var="mulists" varStatus="loop">
			<tr id="hddetail">
				<td id="btn"><button type="button"
						onclick="location.href='/project01/contents/musicEdit.do?idx=${ mulists.idx }&title=${ mulists.title }'">수정하기</button></td>
				<td
					onclick="location.href='/project01/contents/musicview.do?idx=${ mulists.idx }&&title=${ mulists.title }'"
					style="cursor: pointer;"><img src="../uploads/${ mulists.sfile }" id="hdmovieimg"></td>
				<td
					onclick="location.href='/project01/contents/musicview.do?idx=${ mulists.idx }&&title=${ mulists.title }'"
					style="cursor: pointer;">${ mulists.title }</td>
				<td
					onclick="location.href='/project01/contents/musicview.do?idx=${ mulists.idx }&&title=${ mulists.title }'"
					style="cursor: pointer;">${ mulists.album }</td>
				<td
					onclick="location.href='/project01/contents/musicview.do?idx=${ mulists.idx }&&title=${ mulists.title }'"
					style="cursor: pointer;">${ mulists.artist }</td>
				<td
					onclick="location.href='/project01/contents/musicview.do?idx=${ mulists.idx }&&title=${ mulists.title }'"
					style="cursor: pointer;">${ mulists.price }</td>
			</tr>
			</c:forEach>
		</table>
	</c:when>
	<%-- 관리자가 아니거나 로그인이 아닌경우 --%>
	<c:otherwise>
		<table id="hdmovietable">
			<tr>
				<td>발매일</td>
				<td>포스터</td>
				<td>제목</td>
				<td>엘범</td>
				<td>아티스트</td>
				<td>가격</td>
			</tr>
			<c:forEach items="${ mulists }" var="mulists" varStatus="loop">
			<tr
				onclick="location.href='/project01/contents/musicview.do?idx=${ mulists.idx }&&title=${ mulists.title }'"
				style="cursor: pointer;">
				<td>
					<fmt:parseDate value="${ mulists.releasedate }" var="releasedate" pattern="yyyy-MM-dd" />
					<fmt:formatDate value="${ releasedate }" pattern="yyyy.MM.dd" />	
				</td>
				<td><img src="../uploads/${ mulists.sfile }" id="hdmovieimg"></td>
				<td>${ mulists.title }</td>
				<td>${ mulists.album }</td>
				<td>${ mulists.artist }</td>
				<td>${ mulists.price }</td>
			</tr>
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
<div class="paging">
	${ map.pagingStr }
</div>
<%@ include file="/include/footer.jsp"%>