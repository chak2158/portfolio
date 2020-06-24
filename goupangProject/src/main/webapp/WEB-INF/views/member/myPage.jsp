<%@ page contentType="text/html; charset=utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<style>
.tdName{
	background-color: #f2f2f2;
}
/* hr{
 /* border-color: #000000; */
 border-top: 0.1em solid #000000;
} */
</style>
</head>
<body>
	 <!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	 <!--================End Top Header Area =================-->
<%@ include file="/WEB-INF/views/include/menu.jsp"%>
          <!--================Left Menu Area =================-->
          <br><br>
		<%@ include file="/WEB-INF/views/include/leftMenuStart.jsp"%>
		
	<div class="container">
	<div class="row">
		
		<div class="col-lg-11">
		내정보
			<br>
			<!-- <hr> -->
			<table class="table">
				
					<tr><td class="tdName">회원 이름</td><td>${member.memberName}</td></tr>
					<tr><td class="tdName">이메일(아이디)</td><td>${member.memberEmail}</td></tr>
					<tr><td class="tdName">회원 등급</td><td>
					<c:if test="${authInfo.grant == 0}">정지 회원</c:if>
					<c:if test="${authInfo.grant == 1}">일반 회원</c:if>
					<c:if test="${authInfo.grant == 2}">셀러</c:if>
					<c:if test="${authInfo.grant == 3}">관리자</c:if>
					</td></tr>
					<tr><td class="tdName">전화번호</td><td>${member.memberPhone}</td></tr>
					<tr><td class="tdName">주소</td><td>${member.memberAddr}</td></tr>
					<tr><td></td><td style="text-align: right"><a href="#">정보수정</a> <a href="#">회원탈퇴</a></td></tr>
				</table>
			<!-- 	<hr> -->
		</div>
		<div class="col-lg-1">
		</div>
	</div>
			
	</div>
		
 <%@ include file="/WEB-INF/views/include/leftMenuEnd.jsp"%>
       <!--================End Left Menu Area =================-->
	 <!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	 <!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>


</body>
</html>