<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>문의 수정</title>
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
                    <h3>문의</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">문의</a></li>
                        <li><a href="#">문의 수정</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
    <h2>문의 수정</h2>
    
    <p>
        <label>상품명:
      ${inquiryRequest.productName}
        </label>
    </p>
    <p>
        <label>판매자:
      ${inquiryRequest.sellerName}
        </label>
    </p>
	<form:form action="${pageContext.request.contextPath}/inquiry/inquiryUpdate" modelAttribute="inquiry">
	    <table border="1px solid black">
	    
			<tr><th>필드값</th><th>필드명</th><th>내용</th></tr>
			<tr><td>INQUIRY_NO      </td><td>문의번호</td><td><form:hidden path="inquiryNo" value="${inquiry.inquiryNo}"/>${inquiry.inquiryNo}</td></tr>
			<tr><td>MEMBER_NO       </td><td>회원번호</td><td>${inquiry.memberNo}</td></tr>
			<tr><td>PRODUCT_NO      </td><td>상품번호</td><td><form:hidden path="productNo" value="${inquiry.productNo}"/>${inquiry.productNo}</td></tr>
			<tr><td>INQUIRY_TITLE   </td><td>문의제목</td><td>${inquiry.inquiryTitle}</td></tr>
			<tr><td>INQUIRY_CONTENT </td><td>문의내용</td><td><form:input path="inquiryContent" value="${inquiry.inquiryContent}"/></td></tr>
			<tr><td>INQUIRY_WRT_DATE</td><td>작성일</td><td>${inquiry.inquiryWrtDate}</td></tr>
			<tr><td>INQUIRY_MOD_DATE</td><td>수정일</td><td>${inquiry.inquiryModDate}</td></tr>
			<tr><td>INQUIRY_DEL_DATE</td><td>삭제일</td><td>${inquiry.inquiryDelDate}</td></tr>
			<tr><td> </td><td> </td><td><input type="submit" value="수정 완료"></td></tr>
		</table>
	</form:form>
		 <!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	 <!--================End Footer Area =================-->
	 	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
