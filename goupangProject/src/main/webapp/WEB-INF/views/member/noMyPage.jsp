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
                    <h3>권한 없음</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">마이페이지</a></li>
                      
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
          <!--================Left Menu Area =================-->
<%@ include file="/WEB-INF/views/include/leftMenuStart.jsp"%>
        <section class="error_area p_100">
            <div class="container">
                <div class="error_inner">
                    <h4>권한이 없습니다</h4>
                    <p>일반회원만 마이페이지를 이용할 수 있습니다.</p>
                    <h6>첫 화면으로 <a href="${pageContext.request.contextPath}">돌아가기</a></h6>
                </div>
            </div>
        </section>
        <%@ include file="/WEB-INF/views/include/leftMenuEnd.jsp"%>
       <!--================End Left Menu Area =================-->

		

	 <!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	 <!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>


</body>
</html>