<%@ page contentType="text/html; charset=utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
<body>
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css"/>
<style>
	.top_right a{
	margin:5px;
	color: black; 
	}
	.header_top_area{
	 margin-bottom: 0px;
	 padding-bottom: 10px;
	}
</style>
	<!--================Top Header Area =================-->
	<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
	<div class="header_top_area" >
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="top_header_left">
						<!-- 헤더 탑 왼쪽 빈공간 -->
					</div>
				</div>
				<div class="col-lg-6">
					<div class="top_header_middle">
						<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/assets/img/title.png"></a>
					</div>
				</div>
				<div class="col-lg-3" style="color: white; ">
					<div class="top_right_header" >
						<ul class="top_right" >
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>



