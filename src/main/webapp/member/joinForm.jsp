<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script type="text/javascript">
	function validateForm(form) {
		if(form.id.value.length < 5 || form.id.value.length > 12){
			alert("아이디는 5자 이상 12자 이하로 작성해주세요.");
			form.id.focus();
			return false;
		}
		if(form.inputpass.value == "") {
			alert("비밀번호를 입력하세요");
			form.inputpass.focus();
			return false;
		} 
		if(form.inputpass.value.length < 8) {
			alert("비밀번호는 8자 이상 입력해주세요");
			form.inputpass.focus();
			return false;
		}
		let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[~?!@#$%^&*_-]).{8,}$/
		if(!reg.test(form.inputpass.value)) {
			alert("비밀번호는 8자 이상, 숫자 및 대,소문자 그리고 특수문자를 모두 포함해야 합니다.");
			form.inputpass.focus();
			return false;
		}
		if(/(\w)\1\1\1/.test(form.inputpass.value)) {
			alert("비밀번호는 같은 문자를 4번 연속 사용할 수 없습니다.");
			form.inputpass.focus();
			return false;
		}
		if(form.inputpass.value.search(" ") != -1) {
			alert("비밀번호는 공백을 포함할 수 없습니다.");
			form.inputpass.focus();
			return false;
		}
		if(form.inputpassConfirm.value == "") {
			alert("비밀번호를 확인 해주세요");
			form.inputpassConfirm.focus();
			return false;
		} 
		if(form.inputpass.value != form.inputpassConfirm.value) {
			alert("비밀번호가 일치하지 않습니다");
			form.inputpass.focus();
			return false;
		} 
	}
</script>
<div id="join1">
	<h2>JOIN</h2>
</div>
<div id="joinsection" class="sectiondiv">
<form name="joinForm" method="post" action="join.do"
onsubmit="return validateForm(this)">
	<table id="join2">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" required="required"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="inputpass" placeholder="password 입력" required="required"/></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input type="password" name="inputpassConfirm" placeholder="password 확인" required="required"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" required="required"/></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td>
				<label for="date">
					<input type="date" name="date" max="2030-01-01" min="1900-01-01" value="2000-01-01" required="required">
				</label>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" required="required"/> @ <select
				name="domain" required="required">
					<option value="">선택</option>
					<option value="naver.com">네이버</option>
					<option value="google.com">구글</option>
			</select></td>
		</tr>
		<tr>
			<td>주소</td>
			<td>
				<input type="text" id="sample4_postcode" placeholder="우편번호" name="postnumber" required="required">
				<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="address" required="required"> 
				<span id="guide" style="color: #999; display: none"></span> 
				<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="address1" required="required"> 
				<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<script>
					//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
					function sample4_execDaumPostcode() {
						new daum.Postcode(
								{
									oncomplete : function(data) {
										// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

										// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
										// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
										var roadAddr = data.roadAddress; // 도로명 주소 변수
										var extraRoadAddr = ''; // 참고 항목 변수

										// 법정동명이 있을 경우 추가한다. (법정리는 제외)
										// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
										if (data.bname !== ''
												&& /[동|로|가]$/g.test(data.bname)) {
											extraRoadAddr += data.bname;
										}
										// 건물명이 있고, 공동주택일 경우 추가한다.
										if (data.buildingName !== ''
												&& data.apartment === 'Y') {
											extraRoadAddr += (extraRoadAddr !== '' ? ', '
													+ data.buildingName
													: data.buildingName);
										}

										// 우편번호와 주소 정보를 해당 필드에 넣는다.
										document
												.getElementById('sample4_postcode').value = data.zonecode;
										document
												.getElementById("sample4_roadAddress").value = roadAddr;



										var guideTextBox = document
												.getElementById("guide");
										// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
										if (data.autoRoadAddress) {
											var expRoadAddr = data.autoRoadAddress
													+ extraRoadAddr;
											guideTextBox.innerHTML = '(예상 도로명 주소 : '
													+ expRoadAddr + ')';
											guideTextBox.style.display = 'block';
										} else {
											guideTextBox.innerHTML = '';
											guideTextBox.style.display = 'none';
										}
									}
								}).open();
					}
				</script>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="btn">
				<button type="submit">등록</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
</form>
</div>

<%@ include file="/include/footer.jsp"%>
