<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니목록이야</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js">
//전체선택 체크박스 클릭 
$("#allCheck").click(function(){ 
	//만약 전체 선택 체크박스가 체크된상태일경우
	if($(".chk").is(":checked")) { 
		//해당화면에 전체 checkbox들을 체크해준다
		$(".chk").prop("checked",true); 
		// 전체선택 체크박스가 해제된 경우 } 
	else { //해당화면에 모든 checkbox들의 체크를해제시킨다. 
		$(".chk").prop("checked",false);
	}
});

$(".chk").click(function(){ 
	//만약 전체 선택 체크박스가 체크된상태일경우
	if($("input[name='chk']").length == 3) { 
		//해당화면에 전체 checkbox들을 체크해준다
		$("#allCheck").prop("checked",true); 
		// 전체선택 체크박스가 해제된 경우 } 
	else { //해당화면에 모든 checkbox들의 체크를해제시킨다. 
		$("input[name='chk']").prop("checked",false);
	}
});
	
</script>

</head>
<body>

	<c:if test="${error != null}">

		<script type="text/javascript">
    var v = "${error}";
  	alert(v);
	</script>

	</c:if>
	<h1>장바구니</h1>
	<table border="1px solid black">
		<tr>
			<th>선택<input type="checkbox" class="chk" name="chk" id="allCheck"/></th>
			<th>member_no</th>
			<th>product_no</th>
			<th>order_qty</th>
			<th>delete</th>
		</tr>
		<c:forEach var="cart" items="${cartList}">
			<!-- for(Cart cart : cartList ) -->
			<form:form
				action="${pageContext.request.contextPath}/cart/updateCartList"
				modelAttribute="cart">
				<tr>
					<td><input type="checkbox" class="chk" name="chk" /></td>
					<input type="text" value="${cart.cartNo}" name="cartNo" id="cartNo"
						hidden="hidden"></input>
					<td><input type="text" value="${cart.memberNo}"
						name="memberNo" id="memberNo" readonly></input></td>
					<td><input type="text" value="${cart.productNo}"
						name="productNo" id="productNo" readonly></input></td>
					<td><input type="text" placeholder="${cart.orderQty}"
						name="orderQty" id="orderQty"></input> <%-- <td><form:input path="orderQty" value="${cart.orderQty}" type="hidden" /> --%>
						<input type="submit" value="수량변경" /></td>
					<td><button type="button"
							onclick="deleteCart('${pageContext.request.contextPath}/cart/deleteCartList?cartNo=${cart.cartNo}&memberNo=${cart.memberNo}')">장바구니
							삭제</button></td>
				</tr>
			</form:form>
		</c:forEach>


	</table>
	<script type="text/javascript">
function deleteCart(url) {
	//console.log(url)
	if(confirm("정말 삭제합니까?")){		
	location.href=url;
	}

}
</script>


</body>
</html>