<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<div id="uploadpage">
	<div id="movie_up1">
		<h2>컨텐츠 등록</h2>
		<select onchange="selectCategory(this)" id="selectcate">
			<option value="mo">영화</option>
			<option value="dr">드라마</option>
			<option value="mu">음악</option>
		</select>
	</div>
	<div id="movieuploadsection" class="sectiondiv">
		<form name="movieUpload" method="post" action="movieUpload.do"
			enctype="multipart/form-data" onsubmit="return validateForm(this)">
			<input type="hidden" name="category" value="영화" />
			<table id="movie_up2">
				<tr>
					<td>제목</td>
					<td class="in"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>개봉연도</td>
					<td class="in"><input type="date" name="releasedate" max="2030-01-01" min="1900-01-01" value="2020-01-01"></td>
				</tr>
				<tr>
					<td>상영시간</td>
					<td class="in"><input type="text" name="time"></td>
				</tr>
				<tr>
					<td>시청연령</td>
					<td class="in"><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>감독</td>
					<td class="in"><input type="text" name="director"></td>
				</tr>
				<tr>
					<td>출연진</td>
					<td class="in"><input type="text" name="cast"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td class="in"><textarea type="text" name="content"></textarea></td>
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
					<td>유튜브 url</td>
					<td class="in"><input type="text" name="youtube"></td>
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
							onclick="location.href='/project01/index.jsp'">메인화면</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dramauploadsection" class="sectiondiv">
		<form name="dramaUpload" method="post" action="dramaUpload.do"
			enctype="multipart/form-data" onsubmit="return validateForm(this)">
			<input type="hidden" name="category" value="드라마" />
			<table id="drama_up2">
				<tr>
					<td>제목</td>
					<td class="in"><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>방영연도</td>
					<td class="in"><input type="date" name="releasedate" max="2030-01-01" min="1900-01-01" value="2020-01-01"></td>
				</tr>
				<tr>
					<td>에피소드</td>
					<td class="in"><input type="text" name="episode"></td>
				</tr>
				<tr>
					<td>시청연령</td>
					<td class="in"><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>출연진</td>
					<td class="in"><input type="text" name="cast"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td class="in"><textarea type="text" name="content"></textarea></td>
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
					<td>유튜브 url</td>
					<td class="in"><input type="text" name="youtube"></td>
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
							onclick="location.href='/project01/index.jsp'">메인화면</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="musicuploadsection" class="sectiondiv">
		<form name="musicUpload" method="post" enctype="multipart/form-data"
			action="musicUpload.do" onsubmit="return parseLine()">
			<input type="hidden" name="category" value="음악" />
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
					<td class="in"><input type="text" name="time"></td>
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
							onclick="location.href='/project01/index.jsp'">메인화면</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
<script type="text/javascript">
	function selectCategory(obj) {
		let selectCategory = $(obj).val();
		if (selectCategory == "mo") {
			document.querySelector("#movieuploadsection").style.display = 'block';
			document.querySelector("#dramauploadsection").style.display = 'none';
			document.querySelector("#musicuploadsection").style.display = 'none';
		} else if (selectCategory == "dr") {
			document.querySelector("#movieuploadsection").style.display = 'none';
			document.querySelector("#dramauploadsection").style.display = 'block';
			document.querySelector("#musicuploadsection").style.display = 'none';
		} else if (selectCategory == "mu") {
			document.querySelector("#movieuploadsection").style.display = 'none';
			document.querySelector("#dramauploadsection").style.display = 'none';
			document.querySelector("#musicuploadsection").style.display = 'block';
		}
	}
</script>
<%@ include file="/include/footer.jsp"%>