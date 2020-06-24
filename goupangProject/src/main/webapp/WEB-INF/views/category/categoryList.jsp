<%@ page contentType="text/html; charset=utf-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>카테고리</title>
</head>
<body>

<c:forEach var="c" items="${categoryList}">
     <form:form action="${pageContext.request.contextPath}/category/categoryList" modelAttribute="category">
   <table border ="1px solid black">
    <tr><th>카테고리번호</th><th>카테고리명</th></tr>
            <tr><td><form:hidden path="categoryNo" value="${c.categoryNo}" />${c.categoryNo}</td>        
            <td><form:hidden path="categoryName" value="${c.categoryName}" />${c.categoryName}</td>
    </table>
    </form:form>
</c:forEach>
</body>
</html>