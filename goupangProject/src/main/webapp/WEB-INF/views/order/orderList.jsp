<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order List</title>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>

	<!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--================End Top Header Area =================-->
<style>

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #388e3c;
	color: white;
}
</style>
</head>
<body>
	
	<!--================Categories Banner Area =================-->
	<section class="solid_banner_area">
		<div class="container">
			<div class="solid_banner_inner">
				<h3>주문 목록</h3>
				<ul>
					<li><a href="${pageContext.request.contextPath}">Home</a></li>
					<li><a href="#">Order List</a></li>
				</ul>
			</div>
		</div>
	</section>
	<!--================End Categories Banner Area =================-->
	<!--================Left Menu Area =================-->
	<%@ include file="/WEB-INF/views/include/leftMenuStart.jsp"%>

	<table id="customers">
		<tr>
			<th>주문번호</th>
			<th>상품이름</th>
			<th>상품수량</th>
			<th>주문날짜</th>
			<th>배송상태</th>
			<th></th>
		</tr>
		<c:forEach var="order" items="${orderList}">
			<!-- for(Order order : orderList ) -->
			<form:form modelAttribute="order">
				<tr>
					<input type="hidden" value="${order.memberNo}" name="memberNo"
						id="memberNo" readonly />
					<input type="hidden" value="${order.paymentNo}" name="paymentNo"
						id="paymentNo" readonly />
						<input type="hidden" value="${order.productNo}" name="productNo"
						id="productNo" readonly />
					<input type="hidden" value="${order.orderStatusDate}"
						name="orderStatusDate" id="orderStatusDate" readonly />
					<td><input type="text" value="${order.orderProductsNo}"
						name="orderProductsNo" id="orderProductsNo" readonly /></td>
					<td><input type="text" value="${order.productName}"
						name="productName" id="productName" readonly /></td>
					<td><input type="text" value="${order.orderQty}"
						name="orderQty" id="orderQty" readonly /></td>
					<td><input type="text" value="${order.orderDate}"
						name="orderDate" id="orderDate" readonly /></td>
					<td><input type="text" value="${order.deliveryStatus}"
						name="deliveryStatus" id="deliveryStatus" readonly /></td>
					
					<input type="hidden" value="${order.orderStatus}"
						name="orderStatus" id="orderStatus" class="orderStatus" readonly />
					<td>
						
							<button type="button"
								onclick="location.href ='${pageContext.request.contextPath}/order/confirmOrderUpdate?orderProductsNo=${order.orderProductsNo}&productNo=${order.productNo}'">
								구매확정</button>
							<button type="button"
								onclick="location.href ='${pageContext.request.contextPath}/order/refundOrderUpdate?orderProductsNo=${order.orderProductsNo}&productNo=${order.productNo}'">
								반품신청</button>
							<button type="button"
								onclick="location.href ='${pageContext.request.contextPath}/order/cancelOrderUpdate?orderProductsNo=${order.orderProductsNo}&productNo=${order.productNo}'">
								취소신청(배송준비중 일 때)</button>
						</div>
					</td>
				</tr>
			</form:form>
		</c:forEach>
	</table>
	<script>
	/* $(document).ready(function(){
		$(".orderStatus").each(function(){
		var orderStatus = $(this).find('#orderStatus').val();
		console.log("orderStatus",orderStatus);
		if(orderStatus==1){
			$(".message").val("반품신청");
		}
		else if(orderStatus==2){
			$(".message").val("교환신청");
		}
		else if(orderStatus==3){
			$(".message").val("구매확정");
		}
		
	});
	}); */
	
	/*var status = document.getElementsByClassName("orderStatus").value;
    console.log(status);
     var str = document.getElementByClassName("message").innerHTML;
    
    if(status="1"){
        str = "반품신청";
    }
    else if(status="2"){
        str = "취소신청";
    }
    else if(status="3"){
        str = "구매확정";
    } */
</script>

	<%@ include file="/WEB-INF/views/include/leftMenuEnd.jsp"%>
	<!--================End Left Menu Area =================-->
	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>

</html>
