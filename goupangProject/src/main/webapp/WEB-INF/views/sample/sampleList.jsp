<%@ page contentType="text/html; charset=utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>상품 상세 보기</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<link href="${pageContext.request.contextPath}/assets/css/productDetailList.css" rel="stylesheet">
     <!--================Top Header Area =================-->
    <%@ include file="/WEB-INF/views/include/header.jsp"%>
     <!--================End Top Header Area =================-->
<c:if test="${error != null}">

    <script type="text/javascript">
    var v = "${error}";
    alert(v);
    </script>

</c:if>
<c:forEach var="p" items="${productList}">
    <form:form action="${pageContext.request.contextPath}/product/productUpdateForm" modelAttribute="product">
    
        <div class = "product">
        
                <div class="productImg">
                <img src="${pageContext.request.contextPath}${imgPath}">
                <%-- <img src="${pageContext.request.contextPath}${imgThPath}"> --%>
             </div>
             <div class="productInfo">
                <p class="productName"><span>상품명</span><form:hidden path="productName" value="${p.productName}" />${p.productName}</p>
                <p class="productPrice"><span>가격</span><form:hidden path="productPrice" value="${p.productPrice}" />${p.productPrice}</p>
                <p class="productBrand"><span>브랜드명</span><form:hidden path="productBrand" value="${p.productBrand}" />${p.productBrand}</p>
                <p class="productOption"><span>옵션</span><form:hidden path="productOption" value="${p.productOption}" />${p.productOption}</p>
                <p class="cartStock"><span>구매수량</span>
                <button type="button" class="minus">-</button>
                <input type="number" class="numBox" min="1" max="${p.productStock}" value="1" readonly="readonly" id="orderQty"/>
                <button type="button" class="plus">+</button>
                </p>
                <p class="productContent"><span>재고수량</span><form:hidden path="productStock" value="${p.productStock}"/>${p.productStock}</p>
                <p class="productContent"><span>┌상세내용┐</span><br><form:hidden path="productContent" value="${p.productContent}"/>${p.productContent}</p>
                <p class="productNo"><span>물품번호</span><form:hidden path="productNo" value="${p.productNo}" />${p.productNo}</p>
                <p class="sellerNo"><span>판매자번호</span><form:hidden path="sellerNo" value="${p.sellerNo}" />${p.sellerNo}</p>
                <p class="productAvgRate"><span>물품평점</span><form:hidden path="productAvgRate" value="${p.productAvgRate}"/>${p.productAvgRate}</p>
            <script type="text/javascript">
          $(".plus").click(function(){
           var num = $(".numBox").val();
           var plusNum = Number(num) + 1;
           
           if(plusNum > ${p.productStock}) {
                $(".numBox").val(num);
               } else {
                $(".numBox").val(plusNum);          
               }
              });
          
          $(".minus").click(function(){
           var num = $(".numBox").val();
           var minusNum = Number(num) - 1;
           
           if(minusNum <= 0) {
            $(".numBox").val(num);
           } else {
            $(".numBox").val(minusNum);          
           }
          });
            </script>
            
            <input type="button" value="상품 구매" onclick="buyProduct()">
            <button type="button" onclick="getProduct()">장바구니 담기</button>
            <div id="snackbar">장바구니에 상품을 담았습니다.</div>
            </div>
        </div>
    </form:form>
</c:forEach>


  <div id="reviewList"></div>
  <div id="inquiryList"></div>

     <!--================Footer Area =================-->
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
     <!--================End Footer Area =================-->
    <%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
 <%-- <script src="${pageContext.request.contextPath}/assets/js/productDetailList.js"></script> --%>
 <script type="text/javascript">
 $(function () {
        var pn = ${productList[0].productNo};

        $.ajax({
                type : "GET", //전송방식을 지정한다 (POST,GET)
                url : "${pageContext.request.contextPath}/review/reviewList?productNo="+pn+"&curPage=1",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
                dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
                error : function(){
                    $("#reviewList").html("작성된 상품평이 없습니다");
                    },
                success : function(Parse_data){$("#reviewList").html(Parse_data);}
         });
        
        $.ajax({
            type : "GET", //전송방식을 지정한다 (POST,GET)
            url : "${pageContext.request.contextPath}/inquiry/inquiryList?productNo="+pn+"&curPage=1",//호출 URL을 설정한다. GET방식일경우 뒤에 파라티터를 붙여서 사용해도된다.
            dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
            error : function(){
                $("#inquiryList").html("작성된 문의가 없습니다");
                },
            success : function(Parse_data){$("#inquiryList").html(Parse_data);}
     });

    });


    function fn_paging(curPage,productNo){
        $.ajax({
            type : "GET", //전송방식을 지정한다 (POST,GET)
            url : "${pageContext.request.contextPath}/review/reviewList?curPage=" + curPage +"&productNo="+productNo,
            dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
            error : function(){
                $("#inquiryList").html("작성된 문의가 없습니다<br>"+"<a href='${pageContext.request.contextPath}/inquiry/inquiryForm?productNo=${productNo}'>문의 작성하기</a><br>");
                },
            success : function(Parse_data){$("#reviewList").html(Parse_data);}
        });
        };
        function inquiry_paging(curPage,productNo){
            $.ajax({
                type : "GET", //전송방식을 지정한다 (POST,GET)
                url : "${pageContext.request.contextPath}/inquiry/inquiryList?curPage=" + curPage +"&productNo="+productNo,
                dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
                error : function(){
                    $("#inquiryList").html("작성된 문의가 없습니다");
                    $("#inquiryList").html(Parse_data);
                    },
                success : function(Parse_data){$("#inquiryList").html(Parse_data);}
            });
            };
    function buyProduct(){
        var productNo = ${param.productNo};
        var orderQty = $("#orderQty").val();
        console.log(orderQty);
        
        location.href = "${pageContext.request.contextPath}/cart/addCart?productNo="+productNo+"&orderQty="+orderQty;
    };
    function getProduct() {
        
          var x = document.getElementById("snackbar");
          var productNo = ${param.productNo};
            var orderQty = $("#orderQty").val();
         
         
            $.ajax({
                type : "GET", //전송방식을 지정한다 (POST,GET)
                url : "${pageContext.request.contextPath}/cart/addCart?productNo="+productNo+"&orderQty="+orderQty,
                dataType : "text",//호출한 페이지의 형식이다. xml,json,html,text등의 여러 방식을 사용할 수 있다.
                error : function(){
                    console.log("에러");
                    },
                success : function(Parse_data){
                    console.log("dd1");
                    x.className = "show";
                    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
                    console.log("dd2");
                }
            });
          // After 3 seconds, remove the show class from DIV
         
        }

 </script>
</body>
</html>
