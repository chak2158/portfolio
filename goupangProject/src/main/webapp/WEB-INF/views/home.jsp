<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>BroKurly</title>


  <%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
 
</head>
<body>

	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<%@ include file="/WEB-INF/views/include/menu.jsp"%>
	<%@ include file="/WEB-INF/views/include/banner.jsp"%>

	<br>
	<%@ include file="/WEB-INF/views/include/product.jsp"%>



	
	<%-- <jsp:include page="/product/productCategoryList?categoryNo=1" flush ="false"/>
	<jsp:include page="/product/productCategoryList?categoryNo=2" flush ="false"/> --%>  


   







<%@ include file="/WEB-INF/views/include/feature.jsp"%>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%> 
</body>
</html>
