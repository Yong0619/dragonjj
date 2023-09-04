<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<style>
#musicuploadsection {
	display: block !important;
}
</style>
<div id="uploadpage">
	<div id="movie_up1">
		<h2>컨텐츠 수정</h2>
	</div>
	<div id="musicuploadsection" class="sectiondiv">
		<form name="musicUpload" method="post" enctype="multipart/form-data"
			action="musicEdit.do" onsubmit="return parseLine()">
			<input type="hidden" name="category" value="음악" />
			<input type="hidden" name="idx" value="${ param.idx }" />
			<table id="music_up2">
				<tr>
					<td>앨범</td>
					<td class="in"><input type="text" name="album" value="${ mulist.album }"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td class="in"><input type="text" name="title" value="${ mulist.title }"></td>
				</tr>
				<tr>
					<td>아티스트</td>
					<td class="in"><input type="text" name="artist" value="${ mulist.artist }"></td>
				</tr>
				<tr>
					<td>발매일</td>
					<td class="in"><input type="date" name="releasedate" max="2030-01-01" min="1900-01-01" value="2020-01-01"></td>
				</tr>
				<tr>
					<td>재생시간</td>
					<td class="in"><input type="text" name="time" value="${ mulist.time }"></td>
				</tr>
				<tr>
					<td>가사</td>
					<td class="in"><textarea type="text" name="lyrics">${ mulist.lyrics }</textarea></td>
				</tr>
				<tr>
					<td>장르</td>
					<td class="in"><input type="text" name="genre" value="${ mulist.genre }"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td class="in"><input type="text" name="price" value="${ mulist.price }"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td class="in"><input type="text" name="category" value="${ mulist.category }"></td>
				</tr>
				<tr>
					<td>유튜브 url</td>
					<td class="in"><input type="text" name="youtube" value="${ mulist.youtube }"></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td class="in"><input type="file" name="ofile" /></td>
				</tr>
				<tr id="btn_row">
					<td colspan="2" id="btn">
						<button type="submit">작성완료</button>
						<button type="reset">취소</button>
						<button type="button"
							onclick="location.href='/project01/index.do'">메인화면</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>