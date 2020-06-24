<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>

<html>
<head>
<title>카테고리별 상품 목록</title>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<style>
.navbar-nav li{z-index: 9999;}
</style>

<section class="categories_banner_area" style="height: 250px;" >
    <div class="container">
        <div class="c_banner_inner">
            <c:forEach var="c" items="${categoryList}">
                <c:if test="${c.categoryNo == 1}">
                    <h3>${c.categoryName}</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li class="current"><a href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=${c.categoryNo}">${c.categoryName}</a></li>
                    </ul>
                    </c:if>
            </c:forEach>
        </div>
    </div>
</section>
<!--================Categories Product Area =================-->
<section class="categories_product_main p_80">
	<div class="container">
		<div class="categories_main_inner">
			<div class="row row_disable">
				<div class="col-lg-9 float-md-right">
					<div class="showing_fillter">
						<div class="row m0">
							<div class="first_fillter">
								<h4>Showing 1 to 12 of 30 total</h4>
							</div>
							<div>　　　　　　　　　　　　　　　　</div>
							<div class="secand_fillter">
								<h4>SORT BY :</h4>
								<select class="selectpicker">
									<option>이름순</option>
									<option>가격순</option>
									<option>평점순</option>
								</select>
							</div>
							<div class="four_fillter">
								<h4>View</h4>
								<a class="active" href="#"><i class="icon_grid-2x2"></i></a> <a
									href="#"><i class="icon_grid-3x3"></i></a>
							</div>
						</div>
					</div>

					<div class="categories_product_area">

						<div class="row" >
							<c:forEach var="p" items="${productList}" varStatus="status">
								<div class="col-lg-4 col-sm-6">
									<div class="l_product_item">
											<div class="l_p_img">
												<a
													href="${pageContext.request.contextPath}/product/productDetailList?productNo=${p.productNo}">
													<img src="${pageContext.request.contextPath}${imgThPath[status.index]}" >
												</a>
												<h5 class="new">New</h5>
											</div>
											<div class="l_p_text">
												<ul>
													<li class="p_icon"><a href="#"><i
															class="icon_piechart"></i></a></li>
													<li><a class="add_cart_btn"
														href="${pageContext.request.contextPath}/cart/cartList?productNo=${productNo}">Add
															To Cart</a></li>
													<li class="p_icon"><a href="#"><i
															class="icon_heart_alt"></i></a></li>
												</ul>
												<h4>${p.productName}</h4>
												<h5>&#8361; ${p.productPrice}</h5>
											</div>
									</div>
								</div>
							</c:forEach>
							
							<c:forEach var="p" items="${productList}" varStatus="status">
                                <div class="col-lg-4 col-sm-6">
                                    <div class="l_product_item">
                                            <div class="l_p_img">
                                                <a
                                                    href="${pageContext.request.contextPath}/product/productDetailList?productNo=${p.productNo}">
                                                    <img src="${pageContext.request.contextPath}${imgThPath[status.index]}" >
                                                </a>
                                                <h5 class="new">New</h5>
                                            </div>
                                            <div class="l_p_text">
                                                <ul>
                                                    <li class="p_icon"><a href="#"><i
                                                            class="icon_piechart"></i></a></li>
                                                    <li><a class="add_cart_btn"
                                                        href="${pageContext.request.contextPath}/cart/cartList?productNo=${productNo}">Add
                                                            To Cart</a></li>
                                                    <li class="p_icon"><a href="#"><i
                                                            class="icon_heart_alt"></i></a></li>
                                                </ul>
                                                <h4>${p.productName}</h4>
                                                <h5>&#8361; ${p.productPrice}</h5>
                                            </div>
                                    </div>
                                </div>
                            </c:forEach>
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
				<div class="col-lg-3 float-md-right">
					<div class="categories_sidebar">
						<aside class="l_widgest l_p_categories_widget">
							<div class="l_w_title">
								<h3>Categories</h3>
							</div>
							<ul class="navbar-nav" >
								<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=1">Fashion/Beauty</a></li>
								<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=2">Living/Health</a></li>
								<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=3">Digital/HomeApp</a></li>
								<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=4">Sports/Car/Hobby</a></li>
								<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=5">Travel/Ticket</a></li>
							</ul>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Categories Product Area =================-->
<!-- original -->
<%-- <c:forEach var="p" items="${productList}">
   <form:form
      action="${pageContext.request.contextPath}/product/productCategoryList"
      modelAttribute="product">

      <p>
         <a
            href="${pageContext.request.contextPath}/product/productDetailList?productNo=${p.productNo}">
            <img src="${pageContext.request.contextPath}${imgThPath}">
         </a>
      </p>

   </form:form>
</c:forEach> --%>
<!-- original -->
<!--================Footer Area =================-->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<!--================End Footer Area =================-->
<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>