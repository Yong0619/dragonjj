<%@page import="contents.ContentsDTO"%>
<%@page import="contents.ContentsDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<h2>영화</h2>
<div id="movieDivs" class="slider">
	<c:forEach items="${ molist }" var="molist" varStatus="loop">
	<div>
		<a href="/project01/contents/movieview.do?idx=${ molist.idx }&&title=${ molist.title }">
			<img src="/project01/uploads/${ molist.sfile }">
			<p>${ molist.title }</p>
		</a>
	</div>
	</c:forEach>
</div>
<div>
	<h2>드라마</h2>
	<div id="dramaDivs" class="slider">
		<c:forEach items="${ drlist }" var="drlist" varStatus="loop">
		<div>
			<a href="/project01/contents/dramaview.do?idx=${ drlist.idx }&&title=${ drlist.title }
			&&episode=${ drlist.episode }">
				<img src="/project01/uploads/${ drlist.sfile }">
				<p>${ drlist.title }</p>
			</a>
		</div>
		</c:forEach>
	</div>
</div>
<div>
	<h2>음악</h2>
	<div id="musicDivs" class="musicslider">
		<c:forEach items="${ mulist }" var="mulist" varStatus="loop">
		<div>
			<a href="/project01/contents/musicview.do?idx=${ mulist.idx }&&title=${ mulist.title }">
				<img src="/project01/uploads/${ mulist.sfile }">
				<p>${ mulist.title }</p>
			</a>
		</div>
		</c:forEach>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>