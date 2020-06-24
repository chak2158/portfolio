<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="member.register" /></title>
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
                    <h3>회원가입</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">약관</a></li>
                        <li><a href="#">회원정보 입력</a></li>
                        <li><a href="#">회원가입 성공</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
                <section class="error_area p_100">
            <div class="container">
                <div class="error_inner">
                  
                <p>
                <spring:message code="register.done">
				<spring:argument value="${registerRequest.name}" />
				<spring:argument value="${registerRequest.email}" />
				</spring:message>
				</p>
			<a href="${pageContext.request.contextPath}/" > [<spring:message
					code="go.main"  />]
			</a>	
                    
                </div>
            </div>
        </section>

	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
