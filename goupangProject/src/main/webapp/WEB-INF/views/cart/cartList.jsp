<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shopping cart</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	<style>
/* .p_100 {
	margin-left: 100px;
}
.emty_cart_inner {
	margin-left: 100px;
} */
.cart_items {
	margin-top: 30px;
}
</style>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<!--================Categories Banner Area =================-->
	<section class="solid_banner_area">
		<div class="container">
			<div class="solid_banner_inner">
				<h3>shopping cart</h3>
				<ul>
					<li><a href="${pageContext.request.contextPath}">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/cart/cartList">Shopping
							cart</a></li>
				</ul>
			</div>
		</div>
	</section>
	<!--================End Categories Banner Area =================-->
	<!--================Left Menu Area =================-->
	<%@ include file="/WEB-INF/views/include/leftMenuStart.jsp"%>
	<c:if test="${error != null}">

		<script type="text/javascript">
			var v = "${error}";
			alert(v);
		</script>

	</c:if>

	<c:if test="${empty cartList}">

		<section class="emty_cart_area p_100">
			<div class="container">
				<div class="emty_cart_inner">
					<i class="icon-handbag icons"></i>
					<h3>Your Cart is Empty</h3>
					<h4>
						back to <a href="${pageContext.request.contextPath}">main</a>
					</h4>
				</div>
			</div>

		</section>

	</c:if>


	<!--================Shopping Cart Area =================-->
	<c:if test="${not empty cartList}">
		<div class="container">
			<div class="cart_items">
				<h3>Your Cart Items</h3>
				<div class="table-responsive-md">
					<table class="table">
						<tbody>
							<tr>
								<th>
									<div class="checkBox" style="text-align: center;">
										<input type="checkbox" name="allCheck" id="allCheck"
											checked="checked" />
									</div>
								</th>
								<th scope="col" style="text-align: center;">product</th>
								<th scope="col" style="text-align: center;">price</th>
								<th scope="col" style="text-align: center;">Quantity</th>
								<th scope="col" style="text-align: center;">total_price</th>
								<th scope="col" style="text-align: center;"></th>
							</tr>
						</tbody>
						<form
							action="${pageContext.request.contextPath}/cart/updateCartList"
							modelAttribute="cart" method="POST">
							<c:forEach var="cart" items="${cartList}">
								<tr>
									<td>
										<div class="checkBox">
											<input type="checkbox" name="chBox" class="chBox"
												data-cartNo="${cart.cartNo}" checked="checked" />
										</div>
									</td>
									<!-- for(Cart cart : cartList ) -->

									<input type="hidden" value="${cart.cartNo}" name="cartNo"
										class="cartNo" />
									<input type="hidden" value="${cart.memberNo}" name="memberNo"
										class="memberNo" />
									<input type="hidden" value="${cart.productNo}" name="productNo"
										class="productNo" />
									<td>
										<div class="media-body">
											<h4>${cart.productName}</h4>
										</div>
									</td>
									<td><p class="red" style="text-align: center;">${cart.productPrice}</td>
									<td>
										<div class="quantity">
											<input type="text" value="${cart.orderQty}" name="orderQty"
												class="input-text qty" /> <input type="submit" value="수량변경" />
										</div>
									</td>
									<td><p>${cart.totalPrice}</p></td>
									<td scope="row"><a href="#"
										onclick="deleteCart('${pageContext.request.contextPath}/cart/deleteCartList?cartNo=${cart.cartNo}&memberNo=${cart.memberNo}')">
											<img
											src="${pageContext.request.contextPath}/assets/img/icon/close-icon.png"
											alt="삭제">
									</a></td>
								</tr>
							</c:forEach>
					</table>
					<table class="table">
						<tr class="last">
							<td>
								<button type="button" id="order_btn"
									class="btn subs_btn form-control" data-cartNo="${cart.cartNo }">선택주문</button>
							</td>
							<td>
								<button type="button" id="delete_btn"
									class="btn subs_btn form-control" data-cartNo="${cart.cartNo }">선택삭제</button>
							</td>
							<td>
								<button type="button" class="btn subs_btn form-control"
									onclick="location.href='${pageContext.request.contextPath}'">쇼핑
									더 하기</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<!--================End Shopping Cart Area =================-->

		<script>
			//전체선택 체크박스 클릭시 전체 선택
			$("#allCheck").click(function() {
				var chk = $("#allCheck").prop("checked");
				if (chk) {
					$(".chBox").prop("checked", true);
				} else {
					$(".chBox").prop("checked", false);
				}
			});

			//개별 체크박스 선택시 전체선택 체크박스 해제
			$(".chBox").click(function() {
				$("#allCheck").prop("checked", false);
			});

			//선택주문 버튼
			$("#order_btn")
					.click(
							function() {
								var checkArr = new Array();
								$("input[class='chBox']:checked").each(
										function() {
											checkArr.push($(this).attr(
													"data-cartNo"));
										});
								console.log("checkArr: ", checkArr);
								console.log("checkArr: ", $.param(checkArr));
								$
										.ajax({
											url : "${pageContext.request.contextPath}/order/orderPage",
											type : "post",
											data : {
												chbox : checkArr
											},
											success : function(data) {
												console.log("data: ", data);
												var param = encodeURIComponent(JSON
														.stringify(data));
												console.log("param: ", param);

												location.href = "${pageContext.request.contextPath}/order/orderPage?data="
														+ param;
											}
										});

							});

			//선택박스 삭제버튼
			$("#delete_btn")
					.click(
							function() {
								var confirm_val = confirm("정말 삭제하시겠습니까?");

								//개별 선택된 체크박스들을 배열 변수에 저장후 컨트롤러 전송
								if (confirm_val) {
									var checkArr = new Array();

									$("input[class='chBox']:checked").each(
											function() {
												checkArr.push($(this).attr(
														"data-cartNo"));

											});
									console.log(checkArr);
									$
											.ajax({
												url : "${pageContext.request.contextPath}/cart/deleteCheckCart",
												type : "post",
												data : {
													chbox : checkArr
												},
												success : function(result) {
													if (result == 1) {
														location.href = "${pageContext.request.contextPath}/cart/cartList";
													} else {

														alert("삭제실패");
													}
												}
											});
								}
							});
		</script>

		<script type="text/javascript">
			function deleteCart(url) {
				//console.log(url)
				if (confirm("정말 삭제합니까?")) {
					location.href = url;
				}

			}

		</script>
	</c:if>
	<%@ include file="/WEB-INF/views/include/leftMenuEnd.jsp"%>
	<!--================End Left Menu Area =================-->
	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>