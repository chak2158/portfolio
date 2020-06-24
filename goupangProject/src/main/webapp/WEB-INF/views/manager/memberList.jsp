<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<!DOCTYPE html>

<html>
<head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

<title>memberList</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="top_header_left">
					<h2 style="margin-top: 50px; color: red;">Dev</h2>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="top_header_middle">

					<a href="${pageContext.request.contextPath}/admin"
						style="color: black;"><h1 style="margin-top: 30px;">Member
							List</h1></a>

					<!-- <div class="input-group" style="margin: 20px;"> -->
					<form
						action="${pageContext.request.contextPath}/manager/memberSelectList"
						modelAttribute="memberName" class="input-group"
						style="margin: 20px;">
						<input type="text" value="${member.memberName}" name="memberName"
							style="width: 250px;" placeholder="아이디를 입력해주세요"></input> <input type="submit" value="검색" style="width: 50px; padding: 0;"></input>
					</form>

				</div>
			</div>
			<div class="col-lg-3">
				<div class="top_right_header">
					<ul class="top_right">

						<a href="${pageContext.request.contextPath}/manager/logout"
							style="color: black;">로그아웃</a>


					</ul>
				</div>
			</div>
		</div>
	</div>
	<table border="2px solid black" style="margin: 0 auto;">
		<tr style="text-align: center;">
			<th><input type="checkbox" name="allCheck" id="allCheck" ><label
				for="allCheck">모두 선택</label></input></th>


			<th>회원 번호</th>
			<th>이메일</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>탈퇴날짜</th>
			<th>권한설정</th>
			<th>수정 / 삭제</th>
		</tr>


		<c:forEach var="member" items="${memberList}">
			<form
				action="${pageContext.request.contextPath}/manager/memberList2?curPage=${curPage}"
				modelAttribute="member">
				<tr>
					<td><input type="checkbox" name="chBox" class="chBox"
						data-memberNo="${member.memberNo}" /> <label for="chBox">${member.memberNo}</label></td>

					<td><input type="text" value="${member.memberNo}"
						name="memberNo" id="memberNo" readonly=readonly
						style="width: 100%; background-color: #bdbdbd;" ></input></td>
					<td>${member.memberEmail}</td>
					<td>${member.memberName}</td>
					<td>${member.memberPhone}</td>
					<td>${member.memberAddr}</td>
					<td>${member.memberLeaveDate}</td>
					<td><input type="text" placeholder="${member.memberGrant}"
						name="memberGrant" style="width: 100%;"></input></td>
					<td><input type="submit" value="수정" class="btn btn-secondary"
						style="font-size: 10px; padding: 10px 10px"></input>
						<button type="button"
							onclick="deleteSeller('${pageContext.request.contextPath}/manager/memberDelete?memberNo=${member.memberNo}')"
							class="btn btn-secondary"
							style="font-size: 10px; padding: 10px 10px">삭제</button></td>
				</tr>
			</form>

		</c:forEach>
		<tr>
			<td>
				<button type="button" id="selectDelete_btn"
					class="btn btn-secondary"
					style="font-size: 12px; position: relative;">선택 삭제</button>
			</td>
		</tr>
	</table>


	<div>
		<div style="font-size: 1.2em; text-align: center;">
			<c:if test="${pagination.curRange ne 1 }">
				<a href="#" onClick="fn_paging(1)">[처음]</a>
			</c:if>
			<c:if test="${pagination.curPage ne 1}">
				<a href="#" onClick="fn_paging('${pagination.prevPage }')">[이전]</a>
			</c:if>
			<c:forEach var="pageNum" begin="${pagination.startPage }"
				end="${pagination.endPage }">
				<c:choose>
					<c:when test="${pageNum eq  pagination.curPage}">
						<span style="font-weight: bold;"><a href="#"
							onClick="fn_paging('${pageNum }')">${pageNum }</a></span>
					</c:when>
					<c:otherwise>
						<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if
				test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
				<a href="#" onClick="fn_paging('${pagination.nextPage }')">[다음]</a>
			</c:if>
			<c:if
				test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
				<a href="#" onClick="fn_paging('${pagination.pageCnt }')">[끝]</a>
			</c:if>
		</div>

		<div style="text-align: center;">총 게시글 수 : ${pagination.listCnt }
			/ 총 페이지 수 : ${pagination.pageCnt } / 현재 페이지 : ${pagination.curPage }
			/ 현재 블럭 : ${pagination.curRange } / 총 블럭 수 : ${pagination.rangeCnt }</div>
		<div style="text-align: center;">
			<input type="button" value="관리자 홈으로"
				onclick="location.href='${pageContext.request.contextPath}/admin';"
				class="btn btn-secondary" style="font-size: 13px;">
		</div>
	</div>
	<script type="text/javascript">
		$("#allCheck").click(function() {
			var chk = $("#allCheck").prop("checked");
			if (chk) {
				$(".chBox").prop("checked", true);
			} else {
				$(".chBox").prop("checked", false);
			}
		});
		$(".chBox").click(function() {
			$("#allCheck").prop("checked", false);
		});
		$("#selectDelete_btn")
				.click(
						function() {
							var confirm_val = confirm("정말 삭제하시겠습니까?");

							if (confirm_val) {
								var checkArr = new Array();

								$("input[class='chBox']:checked").each(
										function() {
											checkArr.push($(this).attr(
													"data-memberNo"));
										});
								$
										.ajax({
											url : "${pageContext.request.contextPath}/manager/selectDelete",
											type : "post",
											data : {
												chbox : checkArr
											},
											success : function() {
												location.href = "${pageContext.request.contextPath}/manager/memberList";
											}
										});
							}
						});
		function deleteSeller(url) {
			if (confirm("정말 삭제합니까?")) {
				location.href = url;
			}
		};

		function fn_paging(curPage) {
			location.href = "${pageContext.request.contextPath}/manager/memberList?curPage="
					+ curPage;
		};
	</script>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>