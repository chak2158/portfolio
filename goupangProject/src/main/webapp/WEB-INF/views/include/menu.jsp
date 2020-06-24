<%@ page contentType="text/html; charset=utf-8"%>
<style>
.shop_header_area {
background-color: #C6C3DC;
margin-bottom: 1%;
}
.nav-link {
color:blue !improtant;

}
.nav-link:hover {
color:blue !improtant;

}

/* .sticky_scroll_header {
  position: fixed;
  top: 0;
  width: 100%;
} */
</style>
<!--================Menu Area =================-->
<header class="shop_header_area on_scroll_header" id="myHeader">
<!-- <header class="shop_header_area"> -->
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light" style=" border: 0 solid black; ">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav">
					<li class="nav-item dropdown submenu "><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							전체 메뉴 <i class="fa fa-angle-down" aria-hidden="true"></i>
					</a>
						<ul class="dropdown-menu">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=5">여행/티켓</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=1">뷰티/패션</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=2">생활/건강</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=3">디지털/가전제품</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/product/productCategoryList?categoryNo=4">스포츠/자동차/취미</a></li>
						</ul></li>
					
					<li class="nav-item"><a class="nav-link" href="#">신상품</a></li>
					<li class="nav-item"><a class="nav-link" href="#">베스트</a></li>
					<li class="nav-item"><a class="nav-link" href="#">이벤트</a></li>
				</ul>
			</div>
		</nav>
	</div>
</header>

<!-- <script type="text/javascript">

window.onscroll = function() {scroll_header()};
var mHeader = document.getElementById("myHeader");
var mSticky = mHeader.offsetTop;

function scroll_header() {
  if (window.pageYOffset > mSticky) {
	  mHeader.classList.add("sticky_scroll_header");
  } else {
    header.classList.remove("sticky_scroll_header");
  }
}
</script> -->
<!--================End Menu Area =================-->