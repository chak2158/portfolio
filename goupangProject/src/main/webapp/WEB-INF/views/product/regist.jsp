<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	type="stylesheet" />
<!-- Start Seller Header -->
<link
	href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap"
	rel="stylesheet">
<title>상품등록</title>
<style>
h2, p {
	text-align: center;
}
</style>
</head>

<body>
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>

	<!--================Top Header Area =================-->
	<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
	<div class="header_top_area">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="top_header_left" style="margin-top: 80px;">
						<h3 style="color: red;">Seller Page</h3>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="top_header_middle">

						<a href="${pageContext.request.contextPath}/"><h1
								style="margin: 20px; color: #43a047; font-family: 'Pacifico', cursive; font-size: 60px;">BroKurly</h1></a>

						<div class="input-group" style="margin: 20px;">
							<input type="text" class="form-control" placeholder="Search"
								aria-label="Search" id="search"> <span
								class="input-group-btn">
								<button class="btn btn-secondary" type="button"
									onclick="search()">
									<i class="icon-magnifier"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3" style="color: white;">
					<div class="top_right_header">
						<ul class="top_right">
							<c:if test="${empty authInfo}">
								<a href="${pageContext.request.contextPath}/member/step1"
									style="color: black;">회원 가입|</a>
								<a href="${pageContext.request.contextPath}/member/login"
									style="color: black;">로그인</a>
							</c:if>
							<c:if test="${! empty authInfo}">
								<c:if test="${authInfo.grant > 1}">
									<a href="${pageContext.request.contextPath}/sellerHome"
										style="color: black;">판매자 페이지|</a>
								</c:if>
								<c:if test="${authInfo.grant > 2}">
									<a href="${pageContext.request.contextPath}/admin"
										style="color: black;">관리자 페이지|</a>
								</c:if>

								<a href="#" style="color: black;" onclick="chatBot()">채팅봇상담|</a>
								<a href="${pageContext.request.contextPath}/member/myPage"
									style="color: black;">마이페이지|</a>
								<a href="${pageContext.request.contextPath}/cart/cartList"
									style="color: black;">장바구니|</a>
								<a href="${pageContext.request.contextPath}/member/logout"
									style="color: black;">로그아웃</a>
								<p style="color: black;">
									<b style="font-size: 1.1em;">${authInfo.name}</b>님,환영합니다.
								</p>
							</c:if>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			var autocomplete_text = [ "자동완성기능", "Autocomplete", "자동차", "자기부상열차" ];
			$("#search")
					.autocomplete(
							{
								source : function(request, response) {
									$
											.ajax({
												type : 'post',
												url : "${pageContext.request.contextPath}/search/searchJson?keyword="
														+ $("#search").val(),
												dataType : "json",
												data : {
													value : request.term
												},
												success : function(data) {
													console.log(data);
													response($
															.map(
																	data,
																	function(
																			item) {
																		return {
																			label : item,
																			value : item
																		}
																	}))
												}
											});

								},
								minLength : 2
							});

			$("#search").keydown(function() {
				var content = $(this).val();
				if (event.keyCode == 13) {
					search();
				}
			});
		});
		function search() {
			var url = "${pageContext.request.contextPath}/search/search?keyword="
					+ $("#search").val();
			location.href = url;
		}
		function chatBot() {
			var name = "${authInfo.name}";
			window
					.open('http://192.168.0.123:3000/?name=' + name + ' 고객님',
							'_blank',
							'width = 500, height = 500, top = 100, left = 200, location = no');
		}
	</script>
	<!-- End Seller Header -->

	<!--================Start Banner Area =================-->
	<section class="solid_banner_area">
		<div class="container">
			<div class="solid_banner_inner">
				<h3>상품 등록</h3>
				<ul>
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<li><a
						href="${pageContext.request.contextPath}/product/regist"
						style="font-weight: bold;">상품 등록</a></li>
				</ul>
			</div>
		</div>
	</section>
	<!--================End  Banner Area =================-->

	<!-- Start Seller Menu -->
	<header class="shop_header_area">
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#"><img
					src="${pageContext.request.contextPath}/assets/img/logo.png" alt=""></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">

					<ul class="navbar-nav">

						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/product/sellerProductList">상품
								목록</a></li>
						<li class="nav-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/product/regist">상품
								등록</a></li>
						<li class="nav-item"><a class="nav-link" href="#">셀러기능들
								추가</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<!-- End Seller Menu -->

	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		<h2>등록</h2>
		<form:form action="${pageContext.request.contextPath}/product/regist"
			modelAttribute="productRequest" enctype="multipart/form-data">

			<div>
				<table>
					<tr>

						<form:hidden path="productNo" value="${productRequest.productNo}" />
						<th>판매자번호</th>
						<td><form:input path="sellerNo" /></td>
					</tr>
					<tr>
						<th>상품명</th>
						<td><form:input path="productName" /></td>
					</tr>
					<tr>
						<th>브랜드명</th>
						<td><form:input path="productBrand" /></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><form:input path="productPrice" /></td>
					</tr>
					<tr>
						<th>재고량</th>
						<td><form:input path="productStock" /></td>
					</tr>
					<tr>
						<th>옵션</th>
						<td><form:input path="productOption" /></td>
					</tr>
				</table>
			</div>
			<br>
			<p>상세정보</p>
			<textarea class="ckeditor" name="productContent" id="productContent"></textarea>
			<p>
				<script>
					var ckeditor_config = {
						height : 300,
						resize_enable : false,
						enterMode : CKEDITOR.ENTER_BR,
						shiftEnterMode : CKEDITOR.ENTER_P,
						filebrowserUploadUrl : "${pageContext.request.contextPath}/product/regist.do"
					};

					CKEDITOR.replace("productContent", ckeditor_config);
				</script>
				대표이미지  <br>
				<form:input path="files" type="file" multiple="multiple" />
				<!--   <input type="file" id="files" name="files" multiple="multiple"/> -->
			<div class="select_img" style="text-align: center;">
				<img src="" />
			</div>
			<script>
				$("#files").change(
						function() {
							if (this.files && this.files[0]) {
								var reader = new FileReader;
								reader.onload = function(data) {
									$(".select_img img").attr("src",
											data.target.result).width(500);
								}
								reader.readAsDataURL(this.files[0]);
							}
						});
			</script>



			<p>
				<input type="submit" value="상품등록">
			</p>
		</form:form>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
