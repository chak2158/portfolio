<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<!DOCTYPE html>

<html>
<head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>

<title>seller's Products List</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="top_header_left">
					<h2 style="margin-top: 50px; color: red;">Admin</h2>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="top_header_middle">

					<a href="${pageContext.request.contextPath}/manager/sellerList"
						style="color: black;"><h1 style="margin-top: 30px;">Seller's
							Products List</h1></a>

					<!-- <div class="input-group" style="margin: 20px;"> -->
					<form
						action="${pageContext.request.contextPath}/manager/memberSelectList"
						modelAttribute="memberName" class="input-group"
						style="margin: 20px;">
						<input type="text" value="${member.memberName}" name="memberName"
							id="memberName" placeholder="판매자를 입력해주세요" style="width: 250px;"></input> <input type="submit" value="검색" style="width: 50px; padding: 0;">
					</form>

				</div>
			</div>
			<div class="col-lg-3">
				<div class="top_right_header">
					<ul class="top_right">

						<a href="${pageContext.request.contextPath}/manager/logout"
							style="color: black;">로그아웃</a>


					</ul>
				</div>
			</div>
		</div>
	</div>
	<table border="2px solid black" style="margin: 0 auto;">
		<tr style="text-align: center;">
			<th>판매자 번호</th>
			<th style="width: 150px;">상품명</th>
			<th style="width: 80px;">가격</th>
			<th style="width: 70px;">브랜드</th>
			<th style="width: 50px;">수량</th>
			<th >옵션</th>
		</tr>
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.sellerNo}</td>
				<td>${product.productName}</td>
				<td style="text-align: right;" >${product.productPrice}</td>
				<td>${product.productBrand}</td>
				<td style="text-align: right;">${product.productStock}</td>
				<td>${product.productOption}</td>


			</tr>
		</c:forEach>
	</table>
	<div style="font-size: 1.2em; text-align: center;">
		<c:if test="${pagination.curRange ne 1 }">
			<a href="#" onClick="fn_paging(1)">[처음]</a>
		</c:if>
		<c:if test="${pagination.curPage ne 1}">
			<a href="#" onClick="fn_paging('${pagination.prevPage }')">[이전]</a>
		</c:if>
		<c:forEach var="pageNum" begin="${pagination.startPage }"
			end="${pagination.endPage }">
			<c:choose>
				<c:when test="${pageNum eq  pagination.curPage}">
					<span style="font-weight: bold;"><a href="#"
						onClick="fn_paging('${pageNum }')">${pageNum }</a></span>
				</c:when>
				<c:otherwise>
					<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if
			test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
			<a href="#" onClick="fn_paging('${pagination.nextPage }')">[다음]</a>
		</c:if>
		<c:if
			test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
			<a href="#" onClick="fn_paging('${pagination.pageCnt }')">[끝]</a>
		</c:if>
	</div>
	<div style="text-align: center; ">
		<input type="button" value="이전 페이지"
			onclick="location.href='${pageContext.request.contextPath}/manager/sellerList';"
			class="btn btn-secondary" style="font-size: 13px; ">
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>