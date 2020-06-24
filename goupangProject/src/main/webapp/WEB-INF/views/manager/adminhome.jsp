<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>BroKurly admin</title>
</head>
<body>
	<!--================Top Header Area =================-->
	<!-- <div class="header_top_area"> -->
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="top_header_left">
					<h2 style="margin-top: 50px; color: red;">Admin</h2>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="top_header_middle">

					<a href="${pageContext.request.contextPath}/" style="color: black;"><h1
							style="margin-top: 30px;">Admin Page</h1></a>

					<div class="input-group" style="margin: 20px;">
						<input type="text" class="form-control" placeholder="Search"
							aria-label="Search"> <span class="input-group-btn">
							<button class="btn btn-secondary" type="button">
								<i class="icon-magnifier"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="top_right_header">
					<ul class="top_right">
						
						<c:if test="${empty authInfo}">
								<a href="${pageContext.request.contextPath}/member/login" style="color: black;">로그인</a>
							</c:if>
							<c:if test="${! empty authInfo}">
								<a href="${pageContext.request.contextPath}/manager/memberList" style="color: black;">일반회원 관리 I</a>
								<a href="${pageContext.request.contextPath}/manager/sellerList" style="color: black;">구매자회원 관리 I</a>
    							<a href="${pageContext.request.contextPath}/member/logout" style="color: black;">로그아웃</a>
								<p style="color:"><b style="font-size: 1.1em; color: black;">${authInfo.name}</b>님,환영합니다.</p>
							</c:if>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- 	</div> -->





	<%@ include file="/WEB-INF/views/include/footer.jsp"%>


	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
