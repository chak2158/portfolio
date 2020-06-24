<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>

	         <!--================login Area =================-->
        <section class="error_area p_100">
            <div class="container">
                <div class="error_inner">
                    <h4>죄송합니다</h4>
                    <h5>알수없는 에러가 발생하였습니다.</h5>
                    <p>상담번호:1111-1111-1111</p>
                        <h6>첫 화면으로 <a href="${pageContext.request.contextPath}">돌아가기</a></h6>
                </div>
            </div>
        </section>
        <!--================End login Area =================-->

	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>