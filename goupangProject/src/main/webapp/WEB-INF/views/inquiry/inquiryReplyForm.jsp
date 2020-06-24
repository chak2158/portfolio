<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>문의하기</title>
</head>
<body>
	<style type="text/css">

	textarea{resize: none;}
	.inquiryReplyContainer{
	width: 40%;
	}
	</style>
	
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	
	 <!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	 <!--================End Top Header Area =================-->
	 	        <!--================Categories Banner Area =================-->
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>문의 답변</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">상품</a></li>
                        <li><a href="#">문의 답변 작성</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
	 <div class="container inquiryReplyContainer">
    <h2>문의 답변</h2>
    <h2></h2>
    <p>
        <label>상품명:
      ${inquiryReplyRequest.productName}
        </label>
        
    </p>
    <form:form action="${pageContext.request.contextPath}/inquiry/inquiryReplyForm" modelAttribute="inquiryReplyRequest">
    <p>
        <label>답변내용:<br>
        <form:textarea path="replyContent"/>     
        </label>
        <form:hidden path="inquiryNo"/>
        <form:hidden path="sellerNo"/>
        <form:hidden path="productNo"/>
        <form:hidden path="productName"/>
    </p>

    <input type="submit" value="문의 등록" class="btn subs_btn form-control">
    
    </form:form>
    </div>
    	 <!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	 <!--================End Footer Area =================-->
	 <%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
