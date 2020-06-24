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
                    <h3>판매자 신청</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">판매자 신청</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
	        
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>로그인</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">로그인</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
	<form action="${pageContext.request.contextPath}/member/sellerForm" method="post" modelAttribute="seller">
	사업자번호:<input type="text" name="sellerLicensenumber"><br>
	상호:<input type="text" name="sellerCompanyname"><br>
	대표자:<input type="text" name="sellerName"><br>
	id:<input type="text" name="sellerId"><br>
	pw:<input type="password" name="sellerPw"><br>
	전화번호:<input type="text" name="sellerPhone"><br>
	주소:<input type="text" name="sellerAddr"><br>
	<input type="submit" value="가입신청"><br>
	</form>
	<a href="${pageContext.request.contextPath}/"> 메인으로 돌아가기</a>
		<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>