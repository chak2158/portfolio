<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>

<title><spring:message code="login.title" /></title>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script> -->

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style type="text/css">
.loginContainer {
	width: 30%;
}

.loginContainer .textInput {
	width: 100%;
}
</style>
</head>

<body>
	<!--================Top Header Area =================-->
	
	

	<%@ include file="/WEB-INF/views/include/header2.jsp"%>
	<script type="text/javascript">
	
	</script>
	<!--================End Top Header Area =================-->
        <!--================Categories Banner Area =================-->
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>로그인</h3>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}">Home</a></li>
                        <li><a href="#">로그인</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
        <br>
	<div class="container loginContainer">
		<div class="top_header_middle" style="margin-bottom: 40px;">
			<form:form modelAttribute="loginCommand">
				<form:errors />
<br>
				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-1">
							<span style="color:gray"><i class="far fa-2x fa-envelope" style="line-height: 38px"></i></span>
						</div>
						<div class="col-lg-11">
							<form:input path="email" class="form-control textInput" placeholder="아이디(이메일)" />
							
						</div>
					</div>
					<div class="row">
					<div class="col-lg-1">
					</div>
						<div class="col-lg-11" style="color:hotpink; text-align:left;">
							<form:errors path="email" />ㅤ
						</div>
					</div>
				</div>
				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-1">
							<span style="color:gray"><i class="fas fa-2x fa-lock" style="line-height: 38px"></i></span>
						</div>
						<div class="col-lg-11">
							<form:password path="password" class="form-control" placeholder="비밀번호" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-1">
					</div>
						<div class="col-lg-11" style="color:hotpink; text-align:left;">
							
							<form:errors path="password" />ㅤ
						</div>
					</div>
				</div>
				<div class="col-lg-12">
				<div class="row">
				<div class="col-lg-1">
				</div>
				<div class="col-lg-5" style="text-align: left; line-height: 53px">
					<label><form:checkbox path="rememberEmail" /> <spring:message code="rememberEmail" /> </label>

				</div>
				<div class="col-lg-6" style="text-align: right;">
					<a href="#">아이디 | 비밀번호 찾기</a>
				</div>
				</div>
				</div>

								<div class="col-lg-12">
					<span> 로그인 종류 <form:radiobutton path="loginType"
							value="1" label="일반회원" checked="checked" /> <form:radiobutton
							path="loginType" value="2" label="판매자" /> <form:radiobutton
							path="loginType" value="3" label="관리자" />

					</span>
				</div>
				<br>
				<div class="col-lg-12">
					<input type="submit" value="<spring:message code="login.btn" />" class="btn subs_btn form-control">
				</div>
			</form:form>
			<%-- 	<a href="${pageContext.request.contextPath}/" style="margin: 0;"> [<spring:message
			code="go.main" />]
	</a> --%>
			<div id="naver_id_login"></div>
		</div>
	</div>
	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("HeXj_gy3e8nTNaVKketI",
				"http://localhost:8080/goupangProject/member/naverCallBack");
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("white", 2, 40);
		naver_id_login.setDomain("http://localhost:8080/goupangProject/");
		naver_id_login.setState(state);
		naver_id_login.init_naver_id_login();

	</script>

	<!--
       <div id="naverIdLogin"></div>
   <script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "HeXj_gy3e8nTNaVKketI",
			callbackUrl: "http://localhost:8080/goupang/member/naverLogin",
			isPopup: false, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	naverLogin.init();
	</script> -->

</body>
</html>
