<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="//code.jquery.com/jquery-1.11.1.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	 <!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	 <!--================End Top Header Area =================-->
 Help > Install New Software > http://emmet.io/eclipse/updates
<table border="1px solid black">
<tr><th>s_no</th><th>s_name</th></tr>
        <c:forEach var="sample" items="${sampleList}">
        <tr>
            <td>${sample.s_no}</td>
            <td>${sample.s_name}</td>
        </tr>
        </c:forEach>
</table>
<button id="startChat">ss</button>
  <div id="inquiryList">
  
        </div>
	 <!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	 <!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
<script type="text/javascript">
$("#startChat").click(function(e) {
	var name = "${authInfo.name}";
	   window.open('http://localhost:3000/?name='+name+' 고객님', '_blank','width = 500, height = 500, top = 100, left = 200, location = no');

});
/* 	$(function () {
			//여기서 리스트 페이지 불러오고
			//불러온 페이지 안에서 이 펑션에 매개변수만 바꿔넣어서 실행시킨다
			$.ajax({
		            type : "GET", //전송방식을 지정한다 (POST,GET)
		            url : "${pageContext.request.contextPath}/inquiry/inquiryList?productNo=1&curPage=1",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
		            dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
		            error : function(){
		            	alert("통신실패2!!!!");
		            	},
		            success : function(Parse_data){$("#inquiryList").html(Parse_data);}
			 });
		
	});
	function fn_paging(curPage,productNo){
	 $.ajax({
            type : "GET", //전송방식을 지정한다 (POST,GET)
            url : "${pageContext.request.contextPath}/inquiry/inquiryList?curPage=" + curPage +"&productNo="+productNo,
            dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
            error : function(){
            	alert("통신실패!!!!");
            	},
            success : function(Parse_data){$("#inquiryList").html(Parse_data);}
	 });
	} */
</script>

</body>
</html>