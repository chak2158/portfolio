<%@ page contentType="text/html; charset=utf-8"%>

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
                    <h3>검색</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">상품 검색</a></li>
                      
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
	         <!--================login Area =================-->
        <section class="error_area p_100">
            <div class="container">
                <div class="error_inner">

                    <p>${param.keyword} 에 대한 검색결과가 없습니다.</p>
                    <h6>첫 화면으로 <a href="${pageContext.request.contextPath}">돌아가기</a></h6>
                </div>
            </div>
        </section>
        <!--================End login Area =================-->
        

	 <!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	 <!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>

</body>
</html>