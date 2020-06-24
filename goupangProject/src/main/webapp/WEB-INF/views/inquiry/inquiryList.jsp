<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.inquiryBtn{
    color: #444444;
    background: #F3F3F3;
    border: 1px #DADADA solid;
    padding: 1px 10px;
    border-radius: 2px;
    font-weight: bold;
    font-size: 9pt;
    outline: none;
}
.inquiryBtn:hover {
    border: 1px #C6C6C6 solid;
    box-shadow: 1px 1px 1px #EAEAEA;
    color: #333333;
    background: #F7F7F7;
}

.inquiryBtn:active {
    box-shadow: inset 1px 1px 1px #DFDFDF;   
}
.inquiryTable{
	width:70%;
	border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
   
  margin : 20px 10px;
}
.inquiryTable th{
 width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    }
.inquiryReplyTable{
	width:70%;
	border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    background-color:#fbfbfb;
   
  margin : 20px 10px;
}
.inquiryReplyTable th{
 width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    }
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
<%-- <c:if test="${error != null}">

    <script type="text/javascript">
    var v = "${error}";
  	alert(v);
	</script>

</c:if> --%>
<!-- 상품 페이지 만들어지면 거기서 보낸 번호를 여기다 담아서 보낸다 -->
<%--          <a href="${pageContext.request.contextPath}/">
            [<spring:message code="go.main" />]
        </a><br> --%>
<div class="container">


	<a href="#">문의(${pagination.listCnt })</a><br>
	<button class="inquiryBtn" onclick=location.href="${pageContext.request.contextPath}/inquiry/inquiryForm?productNo=${productNo}" >문의 작성하기</button>

	<hr>
	<ul>
		<li>구매한 상품의 취소/반품은 구매내역에서 신청 가능합니다.</li>
		<li>상품문의 및 후기게시판을 통해 취소나 환불, 반품 등은 처리되지 않습니다.</li>
		<li>가격, 판매자, 교환/환불 및 배송 등 해당 상품 자체와 관련 없는 문의는 고객센터 내 1:1 문의하기를 이용해주세요.</li>
		<li>"해당 상품 자체"와 관계없는 글, 양도, 광고성, 욕설, 비방, 도배 등의 글은 예고 없이 이동, 노출제한, 삭제 등의 조치가 취해질 수 있습니다.</li>
		<li>공개 게시판이므로 전화번호, 메일 주소 등 고객님의 소중한 개인정보는 절대 남기지 말아주세요.</li>
	</ul>
	<hr>
	<c:forEach var="i" items="${inquiryList}">
		<form:form action="${pageContext.request.contextPath}/inquiry/inquiryUpdateForm" modelAttribute="inquiry">
		<form:hidden path="inquiryNo" value="${i.inquiryNo}" readonly ="true"/>
		<form:hidden path="productNo" value="${i.productNo}" />
		<form:hidden path="inquiryModDate" value="${i.inquiryModDate}" />
		<form:hidden path="inquiryDelDate" value="${i.inquiryDelDate}"/>
		<form:hidden path="memberNo" value="${i.memberNo}" />
		<form:hidden path="inquiryWrtDate" value="${i.inquiryWrtDate}" />
		<table class="inquiryTable">       
			<tr><td>회원번호:${i.memberNo}</td><td style="text-align: right;">${i.inquiryWrtDate}</td></tr>            
			<tr><th style="text-align: center;">문의제목</th><td  style="border-bottom: 1px solid #ccc;"><form:hidden path="inquiryTitle" value="${i.inquiryTitle}" />${i.inquiryTitle}</td></tr>    
			<tr><td style="text-align: center;">문의내용</td><td><form:hidden path="inquiryContent" value="${i.inquiryContent}" />${i.inquiryContent}</td></tr>
			<tr>
				<td>
					
				</td>
				<td  style="text-align: right;">
				<c:if test="${fn:length(i.inquiryReplyList) == 0}">		

					<c:if test="${authInfo.id == i.memberNo}">
					<input class="inquiryBtn"  type="submit" value="문의 수정">
					<button class="inquiryBtn"  type="button" onclick="deleteInquiry('${pageContext.request.contextPath}/inquiry/inquiryDelete?memberNo=${i.memberNo}&inquiryNo=${i.inquiryNo}&productNo=${i.productNo}')">문의삭제</button>					
					</c:if>			
				</c:if>
				</td>
			</tr>
			
		</table>
						<c:if test="${fn:length(i.inquiryReplyList) == 0}">				
										<c:if test="${authInfo.grant == 2}">
					
		<button class="inquiryBtn" type="button" onclick="insertReply('${pageContext.request.contextPath}/inquiry/inquiryReplyForm?inquiryNo=${i.inquiryNo}&productNo=${i.productNo}&curPage=${pagination.curPage }' )">문의답변</button>
					</c:if>
				</c:if>
		<c:forEach var="j" items="${i.inquiryReplyList}">
			<table class="inquiryReplyTable">
				<%-- <tr><td>inquiryReplyNo 	</td><td>	문의답변번호	   </td><td>${j.inquiryReplyNo}</td>   </tr>
				<tr><td>inquiryNo	   	</td><td>	문의번호		   </td><td>${j.inquiryNo}</td>    </tr>
				<tr><td>replyModDate	</td><td>	문의답변수정일     </td> <td>${j.replyModDate}</td>   </tr>
				<tr><td>replyDelDate	</td><td>	문의답변삭제일     </td> <td>${j.replyDelDate}</td>   </tr> --%>
				<tr><td>	판매자번호: ${j.sellerNo}      </td><td  style="text-align: right;">${j.replyWrtDate}</td>    </tr>
				<tr><th style="text-align: center;">	└ 문의답변내용       </th> <td style="border-bottom: 1px solid #ccc;">${j.replyContent}</td>   </tr>
				
			</table>
		</c:forEach>
	</form:form>
</c:forEach>

<div>
<nav aria-label="Page navigation example" class="pagination_area">
<ul class="pagination">

    <c:if test="${pagination.curRange ne 1 }">
        <li class="page-item" href="#" onClick="inquiry_paging(1,${productNo})" ><a class="page-link" href="#">처음</a></li> 
    </c:if>
    <c:if test="${pagination.curPage ne 1}">
        <li class="page-item" href="#" onClick="inquiry_paging('${pagination.prevPage }',${productNo})"><a class="page-link" href="#">이전</a></li> 
    </c:if>
    <c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
        <c:choose>
            <c:when test="${pageNum eq  pagination.curPage}">
                <span style="font-weight: bold;"><li class="page-item" href="#" onClick="inquiry_paging('${pageNum }',${productNo})"><a class="page-link" href="javascript:void(0);">${pageNum }</a></li></span> 
            </c:when>
            <c:otherwise>
                <li class="page-item" href="#" onClick="inquiry_paging('${pageNum }',${productNo})"><a class="page-link" href="javascript:void(0);">${pageNum }</a></li> 
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
        <li class="page-item" href="#" onClick="inquiry_paging('${pagination.nextPage }',${productNo})"><a class="page-link" href="#">다음</a></li> 
    </c:if>
    <c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
        <li class="page-item" href="#" onClick="inquiry_paging('${pagination.pageCnt }',${productNo})"><a class="page-link" href="#">끝</a></li> 
    </c:if>
    </ul>
     </nav>
</div>
 </div>
<%-- <div>
    총 게시글 수 : ${pagination.listCnt } /    총 페이지 수 : ${pagination.pageCnt } / 현재 페이지 : ${pagination.curPage } / 현재 블럭 : ${pagination.curRange } / 총 블럭 수 : ${pagination.rangeCnt } / 현재 보고있는 상품 번호 : ${productNo}
</div>
 --%>
<script type="text/javascript">

/* function inquiry_paging(curPage,productNo) {
	location.href = "${pageContext.request.contextPath}/inquiry/inquiryList?curPage=" + curPage +"&productNo="+productNo;
	} */

function deleteInquiry(url) {
	//console.log(url)
	if(confirm("정말 삭제합니까?")){		
	location.href=url;
	}

}

function insertReply(url) {location.href=url;}
</script>
</body>
</html>