<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
.col-lg-5 img {
	width: 100%;
	padding: 0 50px 50px 50px;
}
</style>

<title>BroKurly</title>
</head>
<body>
	<link
		href="${pageContext.request.contextPath}/assets/css/productDetailList.css"
		rel="stylesheet">

	<%@ include file="/WEB-INF/views/include/header.jsp"%>


	<!--================Menu Area =================-->
	<%@ include file="/WEB-INF/views/include/menu.jsp"%>
	<!--================End Menu Area =================-->

	<!--================Product Details Area =================-->
	<section class="product_details_area">
		<c:forEach var="p" items="${productList}">
			<form:form
				action="${pageContext.request.contextPath}/product/productUpdateForm"
				modelAttribute="product">

				<div class="container">
					<div class="row">
						<div class="col-lg-5">
							<img src="${pageContext.request.contextPath}${imgPath}">
						</div>
						<div class="product_details_text">
							<h3>${p.productName}</h3>
							<ul class="p_rating">
								<li><a href="#"><i class="fa fa-star"></i></a></li>
								<li><a href="#"><i class="fa fa-star"></i></a></li>
								<li><a href="#"><i class="fa fa-star"></i></a></li>
								<li><a href="#"><i class="fa fa-star"></i></a></li>
								<li><a href="#"><i class="fa fa-star"></i></a></li>
							</ul>
							<div class="add_review">
								<a
									href="${pageContext.request.contextPath}/review/reviewList?productNo=${p.productNo}">5
									Reviews</a> <a
									href="${pageContext.request.contextPath}/review/reviewForm?productNo=${p.productNo}">Add
									your review</a>
							</div>
							<h6>
								Available In <span>Stock</span>
							</h6>
							<h4>&#8361; ${p.productPrice}</h4>
							<h5>BRAND : ${p.productBrand}</h5>
							<div class="p_color">
								<h4 class="p_d_title">
									color <span>*</span>
								</h4>
								<ul class="color_list">
									<li><a href="#"></a></li>
									<li><a href="#"></a></li>
									<li><a href="#"></a></li>
									<li><a href="#"></a></li>
									<li><a href="#"></a></li>
									<li><a href="#"></a></li>
								</ul>
							</div>
							<div class="p_color">
								<h4 class="p_d_title">
									수량 <span>*</span>
								</h4>
								<button type="button" class="minus">-</button>
								<input type="number" class="numBox" min="1"
									max="${p.productStock}" value="1" readonly="readonly"
									id="orderQty" />
								<button type="button" class="plus">+</button>
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
							</div>
							<div class="quantity">
								<div class="custom">
									<c:forEach var="cart" items="${cartList}">
										<!-- for(Cart cart : cartList ) -->
										<form
											action="${pageContext.request.contextPath}/cart/updateCartList"
											modelAttribute="cart" method="POST"></form>
									</c:forEach>
								</div>
								<button type="button" onclick="buyProduct()"
									class="add_cart_btn" style="margin: 0;">바로주문</button>
								<button type="button" onclick="getProduct()"
									class="add_cart_btn" style="margin: 0;">장바구니 담기</button>
								<div id="snackbar">장바구니에 상품을 담았습니다.</div>
							</div>
							<div class="shareing_icon">
								<h5>share :</h5>
								<ul>
									<li><a href="#"><i class="social_facebook"></i></a></li>
									<li><a href="#"><i class="social_twitter"></i></a></li>
									<li><a href="#"><i class="social_pinterest"></i></a></li>
									<li><a href="#"><i class="social_instagram"></i></a></li>
									<li><a href="#"><i class="social_youtube"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
	</section>
	<!--================End Product Details Area =================-->

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<nav class="tab_menu">
				<div class="nav nav-tabs" id="nav-tab" role="tablist">
					<a class="nav-item nav-link active" id="nav-home-tab"
						data-toggle="tab" href="#nav-home" role="tab"
						aria-controls="nav-home" aria-selected="true">Product
						Description</a> <a class="nav-item nav-link" id="nav-profile-tab"
						data-toggle="tab" href="#nav-profile" role="tab"
						aria-controls="nav-profile" aria-selected="false">Reviews (1)</a>
					<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab"
						href="#nav-contact" role="tab" aria-controls="nav-contact"
						aria-selected="false">상품문의</a> <a class="nav-item nav-link"
						id="nav-info-tab" data-toggle="tab" href="#nav-info" role="tab"
						aria-controls="nav-info" aria-selected="false">additional
						information</a> <a class="nav-item nav-link" id="nav-gur-tab"
						data-toggle="tab" href="#nav-gur" role="tab"
						aria-controls="nav-gur" aria-selected="false">gurantees</a>
				</div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
					aria-labelledby="nav-home-tab">
					<p>${p.productContent}</p>
				</div>
				<div class="tab-pane fade" id="nav-profile" role="tabpanel"
					aria-labelledby="nav-profile-tab">
					<h4>Rocky Ahmed</h4>
					<ul>
						<li><a href="#"><i class="fa fa-star"></i></a></li>
						<li><a href="#"><i class="fa fa-star"></i></a></li>
						<li><a href="#"><i class="fa fa-star"></i></a></li>
						<li><a href="#"><i class="fa fa-star"></i></a></li>
						<li><a href="#"><i class="fa fa-star"></i></a></li>
					</ul>
					<div id="reviewList"></div>

				</div>
				<div class="tab-pane fade" id="nav-contact" role="tabpanel"
					aria-labelledby="nav-contact-tab">
					<div id="inquiryList"></div>
				</div>
				<div class="tab-pane fade" id="nav-info" role="tabpanel"
					aria-labelledby="nav-info-tab">
					<p>Excepteur sint occaecat cupidatat non proident, sunt in
						culpa qui officia deserunt mollit anim id est laborum. Sed ut
						perspiciatis unde omnis iste natus error sit voluptatem
						accusantium doloremque laudantium, totam rem aperiam, eaque ipsa
						quae ab illo inventore veritatis et quasi architecto beatae vitae
						dicta sunt explicabo. Emo enim ipsam voluptatem quia voluptas sit
						aspernatur aut odit aut fugit, sed quia consequuntur.</p>
				</div>
				<div class="tab-pane fade" id="nav-gur" role="tabpanel"
					aria-labelledby="nav-gur-tab">
					<p>Excepteur sint occaecat cupidatat non proident, sunt in
						culpa qui officia deserunt mollit anim id est laborum. Sed ut
						perspiciatis unde omnis iste natus error sit voluptatem
						accusantium doloremque laudantium, totam rem aperiam, eaque ipsa
						quae ab illo inventore veritatis et quasi architecto beatae vitae
						dicta sunt explicabo. Emo enim ipsam voluptatem quia voluptas sit
						aspernatur aut odit aut fugit, sed quia consequuntur.</p>
				</div>
			</div>
		</div>
	</section>
	<!--================End Product Details Area =================-->

	<!--================End Related Product Area =================-->
	<section class="related_product_area">
		<div class="container">
			<div class="related_product_inner">
				<h2 class="single_c_title">Related Product</h2>
				<div class="row">
					<div class="col-lg-3 col-sm-6">
						<div class="l_product_item">
							<div class="l_p_img">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/img/product/related-product/r-product-1.jpg"
									alt="">
							</div>
							<div class="l_p_text">
								<ul>
									<li class="p_icon"><a href="#"><i
											class="icon_piechart"></i></a></li>
									<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
									<li class="p_icon"><a href="#"><i
											class="icon_heart_alt"></i></a></li>
								</ul>
								<h4>Run Tracksuit</h4>
								<h5>$85.50</h5>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="l_product_item">
							<div class="l_p_img">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/img/product/related-product/r-product-2.jpg"
									alt="">
								<h5 class="new">New</h5>
							</div>
							<div class="l_p_text">
								<ul>
									<li class="p_icon"><a href="#"><i
											class="icon_piechart"></i></a></li>
									<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
									<li class="p_icon"><a href="#"><i
											class="icon_heart_alt"></i></a></li>
								</ul>
								<h4>Nike Men Trouser</h4>
								<h5>
									<del>$130.50</del>
									$110
								</h5>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="l_product_item">
							<div class="l_p_img">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/img/product/related-product/r-product-3.jpg"
									alt="">
							</div>
							<div class="l_p_text">
								<ul>
									<li class="p_icon"><a href="#"><i
											class="icon_piechart"></i></a></li>
									<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
									<li class="p_icon"><a href="#"><i
											class="icon_heart_alt"></i></a></li>
								</ul>
								<h4>Nike Track Pants</h4>
								<h5>$250.00</h5>
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6">
						<div class="l_product_item">
							<div class="l_p_img">
								<img class="img-fluid"
									src="${pageContext.request.contextPath}/assets/img/product/related-product/r-product-4.jpg"
									alt="">
								<h5 class="sale">Sale</h5>
							</div>
							<div class="l_p_text">
								<ul>
									<li class="p_icon"><a href="#"><i
											class="icon_piechart"></i></a></li>
									<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
									<li class="p_icon"><a href="#"><i
											class="icon_heart_alt"></i></a></li>
								</ul>
								<h4>Therma Pants</h4>
								<h5>$45.50</h5>
							</div>
						</div>
					</div>
				</div>
				<nav aria-label="Page navigation example" class="pagination_area">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#">6</a></li>
						<li class="page-item next"><a class="page-link" href="#"><i
								class="fa fa-angle-right" aria-hidden="true"></i></a></li>
					</ul>
				</nav>
			</div>
		</div>
		</form:form>
		</c:forEach>
	</section>
	<!--================End Related Product Area =================-->



	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
	<script type="text/javascript">
	$(function () {
	     var productNo = ${productList[0].productNo};  
	     review_paging(1,productNo);
	     inquiry_paging(1,productNo);
	
	  });

   function review_paging(curPage,productNo){
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
					$("#inquiryList").html("작성된 문의가 없습니다.");
					//$("#inquiryList").html(Parse_data);
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