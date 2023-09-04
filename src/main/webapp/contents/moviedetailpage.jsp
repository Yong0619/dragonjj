<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<script type="text/javascript">
	function nonLogin() {
		alert("구매하시려면 로그인하세요")
		}
</script>
<div><iframe width='1360' height='600' src='${ dto.youtube }?
&autoplay=1&mute=1&cc_lang_pref=kr&cc_load_policy=1' frameborder='0' allowfullscreen>
</iframe></div>
<div id="title_h2">
	<h2>${ dto.title }</h2>
</div>
<div id="detail_div">
	<ul id="detail_ul">
		<li>
			<fmt:parseDate value="${ dto.releasedate }" var="releasedate" pattern="yyyy-MM-dd" />
			<fmt:formatDate value="${ releasedate }" pattern="yyyy.MM.dd" />			
		</li>
		<li>${ dto.time }</li>
		<li>${ dto.age }</li>
	</ul>
	<!--  구매버튼 로그인시 구매함 구매안함 로그인안함 구분 -->
	<c:choose>
		<c:when test="${ id != null }">
			<c:if test="${ result == 1 }">
				<button class="buy_btn" style="cursor: pointer;">
				<span></span>
				<span></span>
				<span></span>
				<span></span>
				시청하기</button>
			</c:if>
			<c:if test="${ result == 0 }">
				<form action="">
					<button type="button" onclick="location.href='moviepurchase.do?idx=${ dto.idx }&&title=${ dto.title }'" class="buy_btn" style="cursor: pointer;">
					<span></span>
					<span></span>
					<span></span>
					<span></span>
					구매 ${ dto.price }
					</button>
				</form>
			</c:if>
		</c:when>
		<c:otherwise>
			<button type="button" onclick="nonLogin()" class="buy_btn" style="cursor: pointer;">
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			구매 ${ dto.price }
			</button>
		</c:otherwise>
	</c:choose>
	<!-- 구매버튼부분 끝 -->
</div>
<div id="movie_info">
	<p>감독 <span>${ dto.director } </span></p>
	<p>출연 <span> ${ dto.cast }</span></p>
	<p>${ dto.content }</p>
</div>
<!-- 리뷰영역 -->
<c:choose>
	<c:when test="${ id != null }">
		<form action="moviereviewwrite.do">
			<input type="hidden" name="title" value="${ param.title }" />
			<input type="hidden" name="idx" value="${ param.idx }" />
			<div id="reviewbox1_h2">
				<h2>감상평</h2>
			</div>
			<table id="reviewbox1">
				<tr>
					<td>${ id }</td>
				</tr>
				<tr>
					<td><textarea rows="2" cols="100" name="content"></textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="등록" id="review_btn1"></td>
				</tr>
			</table>
		</form>
		<div id="reviewbox2">
			<table>
			<c:if test="${ empty review }">
				<tr>
					<td colspan="4">등록된 리뷰가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${ review }" var="review" varStatus="loop">
				<tr>
					<td>${ review.id }</td>
					<td>${ review.content }</td>
					<td>${ review.postdate }</td>
					<c:if test="${ id eq review.id }">
					<form action="reviewdelete.do">
						<input type="hidden" name="idx" value="${ review.idx }"/>
						<input type="hidden" name="title" value="${ review.title }"/>
						<td><button type="submit" id="review_btn2">X</button></td>
					</form>
					</c:if>
				</tr>	
			</c:forEach>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<div id="reviewbox3_h3">
			<h3>감상평을 남기시려면 <a href="/project01/member/loginForm.jsp">로그인</a>을 하세요.</h3>
		</div>
		<div id="reviewbox3">
			<table>
			<c:if test="${ empty review }">
				<tr>
					<td colspan="4">등록된 리뷰가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${ review }" var="review" varStatus="loop">
				<tr>
					<td>${ review.id }</td>
					<td>${ review.content }</td>
					<td>${ review.postdate }</td>
				</tr>	
			</c:forEach>
			</table>
		</div>
	</c:otherwise>
</c:choose>
<!-- 리뷰영역 끝 -->
<%@ include file="/include/footer.jsp" %>