<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>BroKurly</title>

<%@ include file="/WEB-INF/views/include/header.jsp"%>



<!--================Categories Banner Area =================-->
<section class="categories_banner_area" style="background: url(${pageContext.request.contextPath}/assets/img/banner/여행티켓.png) no-repeat scroll center center;" >
	<div class="container">
		<div class="c_banner_inner">
			<h3>travel/ticket</h3>
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li class="current"><a href="${pageContext.request.contextPath}/sample/sampleList">travel/ticket</a></li>
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
					<div class="showing_fillter">
						<div class="row m0">
							<div class="first_fillter">
								<h4>Showing 1 to 12 of 30 total</h4>
							</div>
							<div class="secand_fillter">
								<h4>SORT BY :</h4>
								<select class="selectpicker">
									<option>Name</option>
									<option>Name 2</option>
									<option>Name 3</option>
								</select>
							</div>
							<div class="third_fillter">
								<h4>Show :</h4>
								<select class="selectpicker">
									<option>09</option>
									<option>10</option>
									<option>10</option>
								</select>
							</div>
							<div class="four_fillter">
								<h4>View</h4>
								<a class="active" href="#"><i class="icon_grid-2x2"></i></a> <a
									href="#"><i class="icon_grid-3x3"></i></a>
							</div>
						</div>
					</div>
					<div class="c_product_grid_details">
						<div class="c_product_item">
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="c_product_img">
										<img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/product/l-product-2.jpg"
											alt="">
									</div>
								</div>
								<div class="col-lg-8 col-md-6">
									<div class="c_product_text">
										<h3>Nike Max Air Vapor Power</h3>
										<h5>$45.05</h5>
										<ul class="product_rating">
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
										</ul>
										<h6>
											Available In <span>Stock</span>
										</h6>
										<p>Curabitur semper varius lectus sed consequat. Nam
											accumsan dapibus sem, sed lobortis nisi porta vitae. Ut quam
											tortor, facilisis nec laoreet consequat, malesuada a massa.
											Proin pretium tristique leo et imperdiet.</p>
										<ul class="c_product_btn">
											<li class="p_icon"><a href="#"><i
													class="icon_piechart"></i></a></li>
											<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
											<li class="p_icon"><a href="#"><i
													class="icon_heart_alt"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="c_product_item">
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="c_product_img">
										<img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/product/l-product-4.jpg"
											alt="">
									</div>
								</div>
								<div class="col-lg-8 col-md-6">
									<div class="c_product_text">
										<h3>Max Air Vapor Power</h3>
										<h5>$110.50</h5>
										<ul class="product_rating">
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
										</ul>
										<h6>
											Available In <span>Stock</span>
										</h6>
										<p>Curabitur semper varius lectus sed consequat. Nam
											accumsan dapibus sem, sed lobortis nisi porta vitae. Ut quam
											tortor, facilisis nec laoreet consequat, malesuada a massa.
											Proin pretium tristique leo et imperdiet.</p>
										<ul class="c_product_btn">
											<li class="p_icon"><a href="#"><i
													class="icon_piechart"></i></a></li>
											<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
											<li class="p_icon"><a href="#"><i
													class="icon_heart_alt"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="c_product_item">
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="c_product_img">
										<img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/product/l-product-7.jpg"
											alt="">
									</div>
								</div>
								<div class="col-lg-8 col-md-6">
									<div class="c_product_text">
										<h3>Fossil Watch</h3>
										<h5>$250</h5>
										<ul class="product_rating">
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
										</ul>
										<h6>
											Available In <span>Stock</span>
										</h6>
										<p>Curabitur semper varius lectus sed consequat. Nam
											accumsan dapibus sem, sed lobortis nisi porta vitae. Ut quam
											tortor, facilisis nec laoreet consequat, malesuada a massa.
											Proin pretium tristique leo et imperdiet.</p>
										<ul class="c_product_btn">
											<li class="p_icon"><a href="#"><i
													class="icon_piechart"></i></a></li>
											<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
											<li class="p_icon"><a href="#"><i
													class="icon_heart_alt"></i></a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="c_product_item">
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="c_product_img">
										<img class="img-fluid" src="${pageContext.request.contextPath}/assets/img/product/l-product-8.jpg"
											alt="">
									</div>
								</div>
								<div class="col-lg-8 col-md-6">
									<div class="c_product_text">
										<h3>Jens T-Shirt</h3>
										<h5>$45.05</h5>
										<ul class="product_rating">
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
											<li><a href="#"><i class="fa fa-star"></i></a></li>
										</ul>
										<h6>
											Available In <span>Stock</span>
										</h6>
										<p>Curabitur semper varius lectus sed consequat. Nam
											accumsan dapibus sem, sed lobortis nisi porta vitae. Ut quam
											tortor, facilisis nec laoreet consequat, malesuada a massa.
											Proin pretium tristique leo et imperdiet.</p>
										<ul class="c_product_btn">
											<li class="p_icon"><a href="#"><i
													class="icon_piechart"></i></a></li>
											<li><a class="add_cart_btn" href="#">Add To Cart</a></li>
											<li class="p_icon"><a href="#"><i
													class="icon_heart_alt"></i></a></li>
										</ul>
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
				<div class="col-lg-3 float-md-right">
					<div class="categories_sidebar">
						<aside class="l_widgest l_p_categories_widget">
							<div class="l_w_title">
								<h3>Categories</h3>
							</div>
							<ul class="navbar-nav">
								<li class="nav-item"><a class="nav-link" href="#">Men’s
										Fashion <i class="icon_plus" aria-hidden="true"></i> <i
										class="icon_minus-06" aria-hidden="true"></i>
								</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
									role="button" data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> Women’s Fashion <i class="icon_plus"
										aria-hidden="true"></i> <i class="icon_minus-06"
										aria-hidden="true"></i>
								</a>
									<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
										<li class="nav-item"><a class="nav-link" href="#">Hoodies
												& Sweatshirts</a></li>
										<li class="nav-item"><a class="nav-link" href="#">Jackets
												& Coats</a></li>
										<li class="nav-item"><a class="nav-link" href="#">Blouses
												& Shirts</a></li>
									</ul></li>
								<li class="nav-item"><a class="nav-link" href="#">Phone
										& Accessories <i class="icon_plus" aria-hidden="true"></i> <i
										class="icon_minus-06" aria-hidden="true"></i>
								</a></li>
								<li class="nav-item"><a class="nav-link" href="#">Electronic
										Appliance <i class="icon_plus" aria-hidden="true"></i> <i
										class="icon_minus-06" aria-hidden="true"></i>
								</a></li>
								<li class="nav-item"><a class="nav-link disabled" href="#">Computer
										& Networking <i class="icon_plus" aria-hidden="true"></i> <i
										class="icon_minus-06" aria-hidden="true"></i>
								</a></li>
								<li class="nav-item"><a class="nav-link disabled" href="#">TV,
										Audiio & Gaming <i class="icon_plus" aria-hidden="true"></i> <i
										class="icon_minus-06" aria-hidden="true"></i>
								</a></li>
								<li class="nav-item"><a class="nav-link disabled" href="#">Office
										Supplies <i class="icon_plus" aria-hidden="true"></i> <i
										class="icon_minus-06" aria-hidden="true"></i>
								</a></li>
								<li class="nav-item"><a class="nav-link disabled" href="#">All
										Categories <i class="icon_plus" aria-hidden="true"></i> <i
										class="icon_minus-06" aria-hidden="true"></i>
								</a></li>
							</ul>
						</aside>
						<aside class="l_widgest l_fillter_widget">
							<div class="l_w_title">
								<h3>Filter section</h3>
							</div>
							<div id="slider-range" class="ui_slider"></div>
							<label for="amount">Price:</label> <input type="text" id="amount"
								readonly>
						</aside>
						<aside class="l_widgest l_color_widget">
							<div class="l_w_title">
								<h3>Color</h3>
							</div>
							<ul>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
								<li><a href="#"></a></li>
							</ul>
						</aside>
						<aside class="l_widgest l_menufacture_widget">
							<div class="l_w_title">
								<h3>Manufacturer</h3>
							</div>
							<ul>
								<li><a href="#">Nigel Cabourn.</a></li>
								<li><a href="#">Cacharel.</a></li>
								<li><a href="#">Calibre (Menswear)</a></li>
								<li><a href="#">Calvin Klein.</a></li>
								<li><a href="#">Camilla and Marc</a></li>
							</ul>
						</aside>
						<aside class="l_widgest l_feature_widget">
							<div class="l_w_title">
								<h3>Featured Products</h3>
							</div>
							<div class="media">
								<div class="d-flex">
									<img src="img/product/featured-product/f-p-5.jpg" alt="">
								</div>
								<div class="media-body">
									<h4>
										Jeans with <br /> Frayed Hems
									</h4>
									<h5>$45.05</h5>
								</div>
							</div>
							<div class="media">
								<div class="d-flex">
									<img src="img/product/featured-product/f-p-6.jpg" alt="">
								</div>
								<div class="media-body">
									<h4>
										Crysp Denim<br />Montana
									</h4>
									<h5>$45.05</h5>
								</div>
							</div>
						</aside>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================End Categories Product Area =================-->


<%@ include file="/WEB-INF/views/include/footer.jsp"%>

<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>