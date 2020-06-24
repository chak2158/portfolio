<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>상품평 샘플 페이지 출력</title>
<style>
.revBtn{
    color: #434343;
    background: #F2F2F2;
    border: 1px #D9D9D9 solid;
    padding: 1px 10px;
    border-radius: 2px;
    font-weight: bold;
    font-size: 9pt;
    outline: none;
}
.revBtn:hover {
    border: 1px #C5C5C5 solid;
    box-shadow: 1px 1px 1px #E9E9E9;
    color: #323232;
    background: #F6F6F6;
}
.revBtn:active {
    box-shadow: inset 1px 1px 1px #DEDEDE;   
}
.revTable{
	width: 100%;
	border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    /* height: 50px; */
    line-height: 2.5;
    font-size: 15px;
   
  margin : 20px 10px;
}
.starRate{
	height: 22px;
	background: ★;
	width: 80px;
	display: inline-block;
}
</style>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>

<%--          <a href="${pageContext.request.contextPath}/">
            [<spring:message code="go.main" />]
        </a><br> --%>
<div class="container">
<br><h4>상품평</h4>
<%-- <a href="#">리뷰(${pagination.listCnt})</a></br> --%>
<button class="revBtn" onclick="location.href='${pageContext.request.contextPath}/order/orderList'">상품평 작성하기</button><br>
<hr>

<form:form action="${pageContext.request.contextPath}/review/reviewUpdateForm" modelAttribute="review" >
	<c:forEach var="r" items="${reviewProductNoList}">
		<form:hidden path="reviewNo" value="${r.reviewNo}" readonly="true"/>
		<form:hidden path="productNo" value="${r.productNo}"/>
		<form:hidden path="productName" value="${r.productName}"/>
		<form:hidden path="productOption" value="${r.productOption}"/>
		<form:hidden path="memberNo" value="${r.memberNo}"/>
		<form:hidden path="memberName" value="${r.memberName}"/>
		<form:hidden path="reviewRate" value="${r.reviewRate}"/>
		<form:hidden path="reviewContent" value="${r.reviewContent}"/>
		<form:hidden path="reviewSummary" value="${r.reviewSummary}"/>
		<form:hidden path="reviewDate" value="${r.reviewDate}"/>
		<table class="revTable">
			<tr><th>${r.memberName}</th></tr>
			<tr><td><!-- <span class="starRate"> --><%-- ${r.reviewRate} --%>
			   <ul>
                  <li><a href="#"><i class="fa fa-star"></i></a></li>
                  <li><a href="#"><i class="fa fa-star"></i></a></li>
                  <li><a href="#"><i class="fa fa-star"></i></a></li>
                  <li><a href="#"><i class="fa fa-star"></i></a></li>
                  <li><a href="#"><i class="fa fa-star"></i></a></li>
               </ul>
			<!-- </span> --> ${r.reviewDate}</td></tr>
			<script>
			$.fn.generateStars = function(){
				return this.each(function(i,e){$(e).html($('<span/>').width($(e).text()*22));});
			};
			$('.starRate').generateStars();
			</script>
			<tr><td style="color:grey">${r.productName}, ${r.productOption}</td></tr>
			<tr><td style="word-break:break-all">${r.reviewContent}</td></tr>
			<tr><td style="word-break:break-all; border-bottom: 1px solid #ccc;">${r.reviewSummary}</td></tr>
			<c:if test="${authInfo.id == r.memberNo}">
				<tr><td><button type="button" class="revBtn" onclick="location.href='${pageContext.request.contextPath}/review/reviewUpdateForm?reviewNo=${r.reviewNo}'">상품평 수정</button>
					<button type="button" class="revBtn" onclick="deleteReview('${pageContext.request.contextPath}/review/reviewDelete?memberNo=${r.memberNo}&reviewNo=${r.reviewNo}&productNo=${r.productNo}')">상품평 삭제</button>
				</td></tr>
			</c:if>
		</table>
	</c:forEach>	
</form:form>
<div>
<nav aria-label="Page navigation example" class="pagination_area">
<ul class="pagination">

    <c:if test="${pagination.curRange ne 1 }">
        <li class="page-item" href="#" onClick="review_paging(1,${productNo})" ><a class="page-link" href="#">처음</a></li> 
    </c:if>
    <c:if test="${pagination.curPage ne 1}">
        <li class="page-item" href="#" onClick="review_paging('${pagination.prevPage }',${productNo})"><a class="page-link" href="#">이전</a></li> 
    </c:if>
    <c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
        <c:choose>
            <c:when test="${pageNum eq  pagination.curPage}">
                <span style="font-weight: bold;"><li class="page-item" href="#" onClick="review_paging('${pageNum }',${productNo})"><a class="page-link" href="javascript:void(0);">${pageNum }</a></li></span> 
            </c:when>
            <c:otherwise>
                <li class="page-item" href="#" onClick="review_paging('${pageNum }',${productNo})"><a class="page-link" href="javascript:void(0);">${pageNum }</a></li> 
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
        <li class="page-item" href="#" onClick="review_paging('${pagination.nextPage }',${productNo})"><a class="page-link" href="#">다음</a></li> 
    </c:if>
    <c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
        <li class="page-item" href="#" onClick="review_paging('${pagination.pageCnt }',${productNo})"><a class="page-link" href="#">끝</a></li> 
    </c:if>
</ul>
</nav>
</div>
</div>
<script type="text/javascript">
function deleteReview(url) {
	//console.log(url)
	if(confirm("상품평을 삭제하시겠습니까?")){		
	location.href=url;
	}
}
</script>
</body>
</html>