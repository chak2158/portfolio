<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>주문/결제 화면이야</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function paymentMethod(e) {
		var one = [ "국민", "우리", "농협" ];
		var two = [ "현대", "삼성", "비씨" ];
		var three = [ "LGU+", "SKT", "KT" ];
		var four = [ "우리 (1002-11-11-11)", "농협 (350-112-111)",
				"국민(420-0002-1231)" ];
		var target = document.getElementById("select");
		if (e.value == "one")
			var d = one;
		else if (e.value == "two")
			var d = two;
		else if (e.value == "three")
			var d = three;
		else if (e.value == "four")
			var d = four;
		target.options.length = 0;
		for (x in d) {
			var opt = document.createElement("option");
			opt.value = d[x];
			opt.innerHTML = d[x];
			target.appendChild(opt);
		}
	}
</script>
${orderCommand }
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/order/orderForm" modelAttribute="order">
	<div>
		<h2>상품정보</h2>
		<table>
		<c:forEach var="item" items="${orderCommand}" varStatus="i">
			<c:set var="info" value="${item}"/>
			<tr>
				<th>상품명</th>
				<td><input type="text" value="${item.value.productName }" readonly="readonly"/></td>
				<th>상품수</th>
				<td><input type="text" value="${item.value.orderQty }" readonly="readonly"/></td>
			</tr>
		</c:forEach>
		</table>
		
		<h2>구매자정보</h2>
		
		<table>
			<tr>
				<th>구매자이름</th>
				<td><input type="text" value="${info.value.memberName}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>구매자이메일</th>
				<td><input type="text" value="${info.value.memberEmail }" readonly="readonly" /></td>
			</tr>
			<tr>
				<th>구매자전화번호</th>
				<td><input type="text" placeholder="${info.value.memberPhone }">
					<button type="button" value="수정"
						onclick="modifyPhone('${pageContext.request.contextPath}/order/modifyPhone?memberNo=${info.value.memberPhone}')">수정</button>
				</td>
			</tr>
		</table>
	</div>
	<hr>
	<div>
		<h2>배송정보</h2>
		<table>
			<tr>
				<th>배송지</th>
				<td><input type="text" value="서울시 구로구"><td>
				<td>	<button type="button" onclick="openDaumPostcode()" value="${order.orderDeliveryDestination}">새로운배송지
						추가</button></td>
			</tr>
		</table>
	</div>
	<hr>
	<div>
		<h2>결제정보</h2>
		<table>
			
			<tr>
				<td><input type="radio" name="payMethod" value="마지막결제정보">마지막
					결제 정보
					<p>db에서 가져옴</p> <input type="radio" name="payMethod"
					onclick="newPayment()" value="결제방식">새로운 결제 <br>
					<table>
						<tr>
							<td><input type="radio" name="method"
								onchange="paymentMethod(this)" value="one">계좌이체</td>
							<td><input type="radio" name="method"
								onchange="paymentMethod(this)" value="two">체크/신용카드</td>
							<td><input type="radio" name="method"
								onchange="paymentMethod(this)" value="three">휴대폰</td>
							<td><input type="radio" name="method"
								onchange="paymentMethod(this)" value="four">무통장입금</td>
						</tr>
						<tr>
							<td><select id="select">
									<option>선택</option>
							</select></td>
							<td>번호 <input type="text">
							</td>
						</tr>
					</table>
					
			</tr>
		</table>
	</div>
	</form:form>

<script type="text/javascript">
	function modifyPhone(url) {
		console.log(url)
		if (confirm("전화번호가 변경되었습니다.")) {
			location.href = url;
		}

	}
</script>

</body>
</html>