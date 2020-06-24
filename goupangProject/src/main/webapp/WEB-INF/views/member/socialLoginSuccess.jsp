<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	
	 <!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	 <!--================End Top Header Area =================-->
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
