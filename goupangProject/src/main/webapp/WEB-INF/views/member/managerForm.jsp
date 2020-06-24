<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	
	<!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--================End Top Header Area =================-->
	        <!--================Categories Banner Area =================-->
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>관리자 등록</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">관리자 등록</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
	<div class="container">
		<div class="top_header_middle" style="margin-bottom: 40px;">
			<form action="${pageContext.request.contextPath}/member/managerForm"
				method="post" modelAttribute="member">
				id:<input type="text" name="memberEmail"><br> pw:<input
					type="password" name="memberPw"><br> <input
					type="submit" value="등록"><br>
			</form>
			<a href="${pageContext.request.contextPath}/" style="margin: 0;"> [<spring:message
			code="go.main" />]
	</a>
		</div>
	</div>
	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>