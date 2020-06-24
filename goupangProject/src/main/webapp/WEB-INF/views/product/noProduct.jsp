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


<!--================Categories Banner Area =================-->
<section class="categories_banner_area" style="height: 250px;">
	<div class="container">
		<div class="c_banner_inner">
			<h3>travel/ticket</h3>
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li class="current"><a
					href="${pageContext.request.contextPath}/sample/sampleList">travel/ticket</a></li>
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
							<div></div>
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
						<form:form
							action="${pageContext.request.contextPath}/product/productCategoryList"
							modelAttribute="product">
							<div>
								<h3>죄송합니다.</h3>
								<h3>조건에 부합하는 상품이 없습니다.</h3>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--================Footer Area =================-->
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<!--================End Footer Area =================-->
<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>