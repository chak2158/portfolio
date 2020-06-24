<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록이야</title>

</head>
<body>

	<h1>주문목록</h1>
	<table border="1px solid black">
		<tr>
			<th>선택<input type="checkbox" class="chk" name="chk"
				id="allCheck" /></th>
			<th>ORDER_PRODUCTS_NO</th>
			<th>MEMBER_NO</th>
			<th>PRODUCT_NO</th>
			<th>PAYMENT_NO</th>
			<th>ORDER_QTY</th>
			<th>ORDER_DATE</th>
			<th>DELIVERY_STATUS</th>
			<th>ORDER_DELIVERY_DESTINATION</th>
			<th>ORDER_STATUS</th>
			<th>ORDER_STATUS_DATE</th>
		</tr>
		<c:forEach var="order" items="${orderList}">
			<!-- for(Order order : orderList ) -->
			<form:form modelAttribute="order">
				<tr>
					<td><input type="checkbox" class="chk" name="chk" /></td>
					<td><input type="text" value="${order.orderProductsNo}"
						name="orderProductsNo" id="orderProductsNo" readonly> </input></td>
					<td><input type="text" value="${order.memberNo}"
						name="memberNo" id="memberNo" readonly></input></td>
					<td><input type="text" value="${order.productNo}"
						name="productNo" id="productNo" readonly></input></td>
					<td><input type="text" value="${order.paymentNo}"
						name="paymentNo" id="paymentNo" readonly></input></td>
					<td><input type="text" value="${order.orderQty}"
						name="orderQty" id="orderQty" readonly></input></td>
					<td><input type="text" value="${order.orderDate}"
						name="orderDate" id="orderDate" readonly></input></td>
					<td><input type="text" value="${order.deliveryStatus}"
						name="deliveryStatus" id="deliveryStatus" readonly></input></td>
					<td><input type="text"
						value="${order.orderDeliveryDestination}"
						name="orderDeliveryDestination" id="orderDeliveryDestination"
						readonly></input></td>
					<td><input type="text" value="${order.orderStatus}"
						name="orderStatus" id="orderStatus" readonly></input> <%-- <td><form:input path="orderQty" value="${cart.orderQty}" type="hidden" /> --%>
						<!-- <input type="submit" value="수량변경" /> --></td>
					<%-- <td><button type="button"
							onclick="deleteCart('${pageContext.request.contextPath}/cart/deleteCartList?cartNo=${cart.cartNo}&memberNo=${cart.memberNo}')">장바구니
							삭제</button></td> --%>
					<td><input type="text" value="${order.orderStatusDate}"
						name="orderStatusDate" id="orderStatusDate" readonly></input></td>
					<td><button type="button"
							onclick="location.href ='${pageContext.request.contextPath}/order/confirmOrderUpdate?orderProductsNo=${order.orderProductsNo}&productNo=${order.productNo}'">
				구매확정</button>
				<button type="button"
							onclick="location.href ='${pageContext.request.contextPath}/order/refundOrderUpdate?orderProductsNo=${order.orderProductsNo}&productNo=${order.productNo}'">
				반품신청</button>
				<button type="button"
							onclick="location.href ='${pageContext.request.contextPath}/order/cancelOrderUpdate?orderProductsNo=${order.orderProductsNo}&productNo=${order.productNo}'">
				취소신청(배송준비중 일 때)</button></td>
				</tr>
				
				
				
		</form:form>	
		</c:forEach>


	</table>



</body>
</html>