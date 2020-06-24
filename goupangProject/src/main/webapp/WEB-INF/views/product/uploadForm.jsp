<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>파일 업로드 예제</h1>
	
	<form method="POST" action="upload" enctype="multipart/form-data">
		<p>
		아이디 : <input type="text" name="email" id="eamil"/>
		</p>
	
		<p>
		파일 고르세요: <input type="file" name="files" multiple="multiple"/>
		</p>
		<input type="submit" id="submit" value="업로드">
	</form>

	
		${errors }



</body>
</html>