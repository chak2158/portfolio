<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="member.register" /></title>
</head>
<body>
	<!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	<style type="text/css">
.step2Container {
	width: 30%;
}

span {
	color: hotpink;
}

.errors {
	padding-left: 20px;
}
</style>

	<!--================Top Header Area =================-->
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--================End Top Header Area =================-->
	<!--================Categories Banner Area =================-->
	<section class="solid_banner_area">
		<div class="container">
			<div class="solid_banner_inner">
				<h3>회원가입</h3>
				<ul>
					<li><a href="${pageContext.request.contextPath}">Home</a></li>
					<li><a href="#">약관</a></li>
					<li><a href="#">회원정보 입력</a></li>
				</ul>
			</div>
		</div>
	</section>
	<!--================End Categories Banner Area =================-->
	<br>
	<div class="container step2Container">

		<h2 style="text-align: center;">
			<spring:message code="member.info" />
		</h2>


		<form:form action="step3" modelAttribute="registerRequest">


			<div class="row">

				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-12">
							<p>
								<label style="width: 100%"> <spring:message code="email" /><span>*</span>
									<form:errors class="errors" path="email" /><br> <form:input
										path="email" class="form-control" />
								</label>
							</p>
						</div>

					</div>
				</div>

				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-12">
							<!-- <p id="checkIdResult"></p> -->

							<p>
								<label style="width: 100%"><spring:message code="name" /><span>*</span>
									<form:errors class="errors" path="name" /><br> <form:input
										path="name" class="form-control" /> </label>
							</p>
						</div>
						<div class="col-lg-11" style="color: hotpink; text-align: left;">

						</div>
					</div>
				</div>

				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-12">
							<p>
								<label style="width: 100%"><spring:message
										code="password" /><span>*</span> <form:errors class="errors"
										path="password" /><br> <form:password path="password"
										class="form-control" /> </label>
							</p>
						</div>
						<div class="col-lg-11" style="color: hotpink; text-align: left;">

						</div>
					</div>
				</div>

				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-12">
							<p>
								<label style="width: 100%"><spring:message
										code="password.confirm" /><span>*</span> <form:errors
										class="errors" path="confirmPassword" /><br> <form:password
										path="confirmPassword" class="form-control" /> </label>
							</p>
						</div>
						<div class="col-lg-11" style="color: hotpink; text-align: left;">

						</div>
					</div>
				</div>

				<div class="col-lg-12">
					<div class="row">
						<div class="col-lg-12">
							<p>
								<label style="width: 100%"><spring:message code="phone" /><span>*</span>
									<form:errors class="errors" path="phone" /><br> <form:input
										path="phone" class="form-control" /> </label>
							</p>
						</div>
						<div class="col-lg-11" style="color: hotpink; text-align: left;">

						</div>
					</div>
				</div>

				<div class="col-lg-12">
					<input type="submit" value="<spring:message code="register.btn" />"
						class="btn subs_btn form-control">
				</div>

			</div>

		</form:form>
		<p style="text-align: center;">
			<a href="${pageContext.request.contextPath}/"> [<spring:message
					code="go.main" />]
			</a>
		</p>
		<div id="somediv"></div>
	</div>
	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
	<script>
		/**/
		$(function() {
			$("#email").blur(function() {
				var content = $(this).val();
				/*     	   var emailId = $(this).attr('id');
				 loadDoc("/sample/sampleAjax",content,emailId);
				 console.log(content,emailId);
				 var ss  = sa(content);
				 console.log(ss); */
			});
		});
		var url = "/sample/sampleAjax";

		$(document).on(
				"click",
				"#somebutton",
				function() {
					$.get(url, function(responseJson) {
						console.log(responseJson);
						var $table = $("<table>").appendTo($("#somediv"));
						$.each(responseJson, function(index, product) {
							console.log(product);
							$("<tr>").appendTo($table).append(
									$("<td>").text(product.id)).append(
									$("<td>").text(product.email)).append(
									$("<td>").text(product.name)).append(
									$("<td>").text(product.registerDateTime));
						});
					});
				});
		/* 
		function sa(content){
		return content;
		};
		function passwordCheck(){
		var pwVal = document.getElementById("pw").value;
		var pwChkVal = document.getElementById("pwChk").value;
		
		if(pwVal == ""){
			document.getElementById("pw_confirm").innerHTML = "비밀번호를 입력해 주세요";
		}else{
			if(pwVal != pwChkVal){
				document.getElementById("pw_confirm").innerHTML = "비밀번호를 확인해 주세요";
			}else{
				document.getElementById("pw_confirm").innerHTML = "굿";
			}
		}

		
		} */

		/* function loadDoc(url,content){
		 var xhttp = new XMLHttpRequest(); //ajax 사용을 위한 내장객체 생성
		 xhttp.onreadystatechange = function(){ //readystate를 변화시킬것이다
		 if(this.readyState == 4 && this.status == 200){//리퀘스트 리스폰스 확인. 0 안보내졌다 1서버가 받았다 2해더가 열렸다 3읽고있다 4리퀘스트를 처리했다  status: 리스폰스 결과에 따른 값
		 console.log(this.status);
		 console.log(this.response);
		 document.getElementById("checkIdResult").innerHTML = this.responseText;
		 }
		 }
		 xhttp.open("POST", url, true);//리퀘스트 초기화(생성). 방식,url,비동기화 여부
		 xhttp.send();//리퀘스트 발송
		 } */
	</script>
</body>
</html>
