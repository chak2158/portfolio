<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<title>주문성공</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
	<!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--================End Top Header Area =================-->

	<section class="emty_cart_area p_100">
		<div class="container">
			<div class="emty_cart_inner">
				<i class="icon-handbag icons"></i>
				<h3>주문이 완료되었습니다.</h3>
				<h4>
					back to <a href="${pageContext.request.contextPath}">main</a>
				</h4>
<br>
				<div class="col-lg-12">
					<button
						onclick="location.href='${pageContext.request.contextPath}/order/orderList'"
						class="btn subs_btn form-control" style="width: 150px;">주문이력보기</button>
					<button
						onclick="location.href='${pageContext.request.contextPath}'"
						class="btn subs_btn form-control" style="width: 150px;">처음화면으로</button>
				</div>
			</div>
		</div>
	</section>

	<div id="orderList"></div>

	<script>
		function orderList() {
			/* $("#orderList").click(function() {
						console.log("ss>"); */
			$(function() {
				var mn = $
				{
					auth.id
				}
				;
				console.log(mn);
				//여기서 리스트 페이지 불러오고
				//불러온 페이지 안에서 이 펑션에 매개변수만 바꿔넣어서 실행시킨다
				$
						.ajax({
							type : "GET", //전송방식을 지정한다 (POST,GET)
							url : "${pageContext.request.contextPath}/order/orderList?memberNo="
									+ mn,//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
							dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
							error : function() {
								$("#orderList").html("주문한 품목이 없듬니다");
							},
							success : function(Parse_data) {
								$("#orderList").html(Parse_data);
							}
						});

			});
			/* }); */
		}
	</script>

	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->



</body>
</html>