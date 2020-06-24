<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	<link
		href="${pageContext.request.contextPath}/assets/css/productDetailList.css"
		rel="stylesheet">
	<!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--================End Top Header Area =================-->


	<!--================Categories Banner Area =================-->
	<section class="categories_banner_area">
		<div class="container">
			<div class="c_banner_inner">
				<h3>shop grid with left sidebar</h3>
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Shop</a></li>
					<li class="current"><a href="#">Shop Grid with Left
							Sidebar</a></li>
				</ul>
			</div>
		</div>
	</section>
	<!--================End Categories Banner Area =================-->

	<!--================Categories Product Area =================-->
	<section class="categories_product_main p_80">
		<div class="container">
			<div class="categories_main_inner">
				<div class="row row_disable">
					<div class="col-lg-9 float-md-right">
						<div class="categories_product_area">
							<div class="row">
								<c:foreach var="p" items="${productList }">
									<div class="col-lg-4 col-sm-6">
										<ul>
											<li class="p_icon"><a href="#"><i
													class="icon_piechart"></i></a></li>
											<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
											<li class="p_icon"><a href="#"><i
													class="icon_heart_alt"></i></a></li>
										</ul>
										<h4>${p.productName }</h4>
										<h5>${p.productPrice } $40</h5>
									</div>
								</c:foreach>
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
			<div class="col-lg-3 float-md-right">
				<div class="categories_sidebar">
					<aside class="l_widgest l_p_categories_widget">
						<div class="l_w_title">
							<h3>Categories</h3>
						</div>
						<ul class="navbar-nav">
							<li class="nav-item"><a class="nav-link" href="#">Travel/Ticket</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Fashion/Beauty</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Living/Health</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Digital/HomeApp</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Sports/Car/Hobby</a></li>
						</ul>
					</aside>

					
				</div>
			</div>
		</div>
		</div>
		</div>
	</section>
	<!--================End Categories Product Area =================-->

</body>
</html>