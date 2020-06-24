<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
		
    <title><spring:message code="login.title" /></title>
</head>
<body>
	 <!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	 <!--================End Top Header Area =================-->
	         <!--================Categories Banner Area =================-->
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>로그인 성공</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">로그인 성공</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
    <p>
        <spring:message code="login.done" />
    </p>
    <p>
          <a href="${pageContext.request.contextPath}/">
            [<spring:message code="go.main" />]
        </a>
    </p>
     <!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	 <!--================End Footer Area =================-->
<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
