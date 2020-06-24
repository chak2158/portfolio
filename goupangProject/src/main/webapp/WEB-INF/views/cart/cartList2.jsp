<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<head></head>

<body>
	<header>
		<div class="logo">
			<a href="메인">coupang</a>
		</div>
	</header>
	<section>
		<h1>장바구니</h1>
	</section>
	<div>
		<table border="1px"
			summary="장바구니 상품명, 제품가격, 선택한수량, 총결제비용 정보 및 결제 상품으로 선택,해제 및 수량변경, 삭제 기능 제공표">
			<tr>
				<th><label> <input title="모든 상품을 결제상품으로 설정"
						type="checkbox" checked="checked" /> <span>&nbsp;&nbsp;전체선택</span>
				</label></th>
				<th colspan="2">상품정보</th>
				<th>상품금액</th>
				<th>배송비</th>
			</tr>
			<tr>
				<td><input type="checkbox" checked="checked" value="상품번호"
					title="상품명" /></td>
				<td><img src="상품이미지 썸네일링크" width="78" height="78" alt="상품명" />
					<a href="상품이미지 클릭하면 상품링크"></a>
					<div>
						<a href="상품 링크">상품명</a>
					</div>
					<div>
						상품금액<span><select title="상품 수량변경">
								<option value="1" selected>1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
						</select></span>
					</div>
					<div>
						옵션*상품금액<a href="장바구니에서 삭제>">삭제</a>
					</div></td>
				<td>상품 총 금액</td>
				<td>2,500원</td>
				<td>(배송비)무료</td>
			</tr>
			<tr>
				<td colspan="5">상품가격<span>상품가격만</span>원<span
					class="더하기symbol용span">+</span>배송비 <span><strong>2,500원</strong></span>
					<span class="=symbol용span">=</span> 주문금액 <span>45,400</span>원
				</td>
			</tr>
		</table>
	</div>
	<div class="order foot">
		<label> <input title="모든 상품을 결제상품으로 설정" type="checkbox"
			checked="checked" class="all-deal-select" /> <span>전체선택</span><span
			class="cart-count-bottom">( <em>3</em> / 3 )
		</span>
		</label>
		<!--<a href="javascript:void(0);" class="selected-delete logging" data-login="false" data-view-type="shoppingCart" data-event-name="selectiveDeletionClick" data-log-label="cart-p-deleteMulti" data-coulog-type="clickEvent" data-listener-event-type="click">선택삭제</a>
						<a href="javascript:void(0);" class="selected-soldout-delete logging" data-login="false" data-view-type="shoppingCart" data-event-name="deleteAllEosAndOosClick" data-log-label="cart-p-outDeleteAll" data-coulog-type="clickEvent">품절/판매종료상품 전체삭제</a>
					</span>-->
	</div>
	<div class="price-area">
		<h2>장바구니 총 주문금액 정보</h2>
		총 상품가격 <em> 11,740 </em>원 <span class="symbol-plus1"><span
			class="sr-only">더하기</span></span> 총 배송비 <em>2,500</em>원 <span
			class="symbol-equal1"><span class="sr-only">결과는</span></span> 총 주문금액
		<em> 11,740<span>원</span>
		</em>
	</div>
	<div class="order-buttons">
		<button type="button" onclick="location.href='main.jsp'">계속
			쇼핑하기</button>
		<button type="button" onclick="location.href='결제.jsp'">구매하기</button>
	</div>
</body>

</html>
