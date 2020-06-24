<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>문의하기</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>

	<style type="text/css">
textarea {
	resize: none;
	width: 100%;
	height: 300px;
}

.inquiryContainer {
	width: 50%;
}
.inquiryContainer textarea {
	resize: none;
	width: 100%;
	height: 200px;
}
.inquiryContainer label {
	width: 100%;
}
</style>

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
					<li><a href="#">상품</a></li>
					<li><a href="#">상품 문의 작성</a></li>
				</ul>
			</div>
		</div>
	</section>
	<!--================End Categories Banner Area =================-->
	<div class="container inquiryContainer">
		<br>
		<p>
			<label>상품명: ${inquiryRequest.productName} </label>
		</p>
		<form:form
			action="${pageContext.request.contextPath}/inquiry/inquiryForm"
			modelAttribute="inquiryRequest">
			<div class="row">
				<div class="col-lg-12">
					<label>문의 내용:
					<form:textarea path="inquiryContent" placeholder="500자 이내로 작성해 주세요." />
					</label>
					<form:hidden path="productNo" />
					<form:hidden path="productName" />
					<form:hidden path="memberNo" />
				</div>
			</div>
			<input type="submit" value="문의 등록" class="btn subs_btn form-control">
		</form:form>
	</div>
	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
