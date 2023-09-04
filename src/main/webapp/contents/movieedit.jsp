<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>

<div id="uploadpage">
	<div id="movie_up1">
		<h2>컨텐츠 수정</h2>
	</div>
	<div id="movieuploadsection" class="sectiondiv">
		<form name="movieUpload" method="post" action="movieEdit.do"
			enctype="multipart/form-data" onsubmit="return validateForm(this)">
			<input type="hidden" name="idx" value="${ param.idx }" />
			<table id="movie_up2">
				<tr>
					<td>제목</td>
					<td class="in"><input type="text" name="title" value="${ molist.title }"></td>
				</tr>
				<tr>
					<td>개봉일</td>
					<td class="in"><input type="date" name="releasedate" max="2030-01-01" min="1900-01-01" value="2023-01-01" /></td>
				</tr>
				<tr>
					<td>상영시간</td>
					<td class="in"><input type="text" name="time" value="${ molist.time }"></td>
				</tr>
				<tr>
					<td>시청연령</td>
					<td class="in"><input type="text" name="age" value="${ molist.age }"></td>
				</tr>
				<tr>
					<td>감독</td>
					<td class="in"><input type="text" name="director" value="${ molist.director }"></td>
				</tr>
				<tr>
					<td>출연진</td>
					<td class="in"><input type="text" name="cast" value="${ molist.cast }"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td class="in"><textarea type="text" name="content">${ molist.content }</textarea></td>
				</tr>
				<tr>
					<td>장르</td>
					<td class="in"><input type="text" name="genre" value="${ molist.genre }"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td class="in"><input type="text" name="price" value="${ molist.price }"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td class="in"><input type="text" name="category" value="${ molist.category }"></td>
				</tr>
				<tr>
					<td>유튜브 url</td>
					<td class="in"><input type="text" name="youtube" value="${ molist.youtube }"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td class="in"><input type="file" name="ofile"></td>
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
	<div id="dramauploadsection" class="sectiondiv">
		<form name="dramaUpload" method="post" action="dramaEdit.do"
			enctype="multipart/form-data" onsubmit="return validateForm(this)">
			<input type="hidden" name="category" value="드라마" />
			<input type="hidden" name="idx" value="${ param.idx }" />
			<table id="drama_up2">
				<tr>
					<td>제목</td>
					<td class="in"><input type="text" name="title" value="${ drlist.title }"></td>
				</tr>
				<tr>
					<td>방영연도</td>
					<td class="in"><input type="date" name="releasedate" max="2030-01-01" min="1900-01-01" value="2020-01-01"></td>
				</tr>
				<tr>
					<td>에피소드</td>
					<td class="in"><input type="text" name="episode" value="${ drlist.episode }"></td>
				</tr>
				<tr>
					<td>시청연령</td>
					<td class="in"><input type="text" name="age" value="${ drlist.age }"></td>
				</tr>
				<tr>
					<td>출연진</td>
					<td class="in"><input type="text" name="cast" value="${ drlist.cast }"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td class="in"><textarea type="text" name="content">${ drlist.content }</textarea></td>
				</tr>
				<tr>
					<td>장르</td>
					<td class="in"><input type="text" name="genre" value="${ drlist.genre }"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td class="in"><input type="text" name="price" value="${ drlist.price }"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td class="in"><input type="text" name="category" value="${ drlist.category }"></td>
				</tr>
				<tr>
					<td>유튜브 url</td>
					<td class="in"><input type="text" name="youtube" value="${ drlist.youtube }"></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td class="in"><input type="file" name="ofile"></td>
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
	<div id="musicuploadsection" class="sectiondiv">
		<form name="musicUpload" method="post" enctype="multipart/form-data"
			action="musicEdit.do" onsubmit="return parseLine()">
			<input type="hidden" name="category" value="음악" />
			<input type="hidden" name="idx" value="${ param.idx }" />
			<table id="music_up2">
				<tr>
					<td>앨범</td>
					<td class="in"><input type="text" name="album"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td class="in"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>아티스트</td>
					<td class="in"><input type="text" name="artist"></td>
				</tr>
				<tr>
					<td>발매연도</td>
					<td class="in"><input type="date" name="releasedate" max="2030-01-01" min="1900-01-01" value="2020-01-01"></td>
				</tr>
				<tr>
					<td>재생시간</td>
					<td class="in"><input type="text" name="playtime"></td>
				</tr>
				<tr>
					<td>가사</td>
					<td class="in"><textarea type="text" name="lyrics"></textarea></td>
				</tr>
				<tr>
					<td>장르</td>
					<td class="in"><input type="text" name="genre"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td class="in"><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td class="in"><input type="text" name="category"></td>
				</tr>
				<tr>
					<td>유튜브 url</td>
					<td class="in"><input type="text" name="youtube"></td>
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