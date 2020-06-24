<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>상품평등록</title>
<style>
	.reviewcon{
	display: block;
	margin-left: 280px; margin-right: auto;
	justify-content: center;
    align-items: center
	}
	.reviewcon div{
	width: 900px;
	height: 70px;
	margin: auto;
	}
	.rtitle{
	display: block;
	margin-left: auto; margin-right: auto;
	padding: 30px;
	}
	.rtitle div{
	width: 900px;
	height: 50px;
	}
	.rname{
	display: block;
	margin-left: 280px; margin-right: auto;
	padding: 30px;
	}
	.rname div{
	width: 900px;
	height: 50px;
	text-align: left;
	font-size: 30;
	}
	.rinfo{
	display: block;
	margin-left: 280px; margin-right: auto;
	padding: 30px;	
	}
	.rinfo div{
	width: 900px;
	height: 180px;
	text-align: left;
	font-size: 30;
	
	}
	.rrate{
	display: block;
	margin-left: 280px; margin-right: auto;
	padding: 30px;	
	}
	.rrate div{
	width: 900px;
	height: 180px;
	text-align: left;
	font-size: 30;	
	}
	.revcon{
	display: block;
	margin-left: 320px; margin-right: auto;
	}
	.revcon div{
	width: 900px;
	height: 180px;
	text-align: left;
	font-size: 30;
	}
	.rcon{
	display: block;
	margin-left: 320px; margin-right: auto;
	}
	.rcon div{
	width: 900px;
	height: 200px;
	text-align: left;
	font-size: 30;
	}
	.revsumm{
	display: block;
	margin-left: 320px; margin-right: auto;	
	}
	.revsumm div{
	width: 900px;
	height: 70px;
	text-align: left;
	font-size: 30;	
	}
	.rsumm{
	display: block;
	margin-left: 320px; margin-right: auto;
	}
	.rsumm div{
	width: 900px;
	height: 70px;
	text-align: left;
	font-size: 30;
	}
	.revbutton{
	display: block;	
	margin-left: 430px; margin-right: auto;
	}
	.revbutton div{
	width: 900px;
	height: 80px;
	text-align: left;
	font-size: 30;	
	}
	.rbutton{
	display: block;
	margin-left: 430px; margin-right: auto;	
	}
	.rbutton div{
	width: 900px;
	height: 80px;
	text-align: left;
	font-size: 30;
	}
	.button{
	background-color: green;
	border: none;
	border-radius: 5px;
	color: white;
	text-align: center;
	font-size:30px;
	margin: 4px 2px;
	}
	.starRate{display:inline-block;
	width: 500px;
	}
	.revcontent{
	resize: none;
	}
</style>
<style>
     #starRate a{
        text-decoration: none;
        font-size: 28px;
        color: gray;
    }
    #starRate a.on{
        color: #04B431;
    }
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
	<!--================Top Header Area =================-->
 	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!--================End Top Header Area =================-->
	<div class="reviewcon">
    <div class="rtitle">
    <h2>구매후기</h2>
    </div>
    </div>
    <div class="reviewcon">
    <div class="rname">
        <label>
      ${reviewReq.memberName}
        </label>
    </div>
	<div class="rinfo">
        <p>구매후기 쓰기</p>
        <label>
      ${reviewReq.productName}
        </label>
        <label>
      ${reviewReq.productOption}
        </label>
    </div>
    </div>
    <form:form action="${pageContext.request.contextPath}/review/reviewForm" modelAttribute="reviewRequest">
    <div class="reviewcon">
    <div class="rrate">
        <p id="starRate">
        <label>별점:</label>
        <a href="#" rvalue="1">★</a>
        <a href="#" rvalue="2">★</a>
        <a href="#" rvalue="3">★</a>
        <a href="#" rvalue="4">★</a>
        <a href="#" rvalue="5">★</a>
		</p>
	<form:hidden path="reviewRate" id="reviewRate"/>
		<script>
        $('#starRate a').click(function(){
            $(this).parent().children("a").removeClass("on");
            $(this).addClass("on").prevAll("a").addClass("on");
            $('#reviewRate').val($(this).attr("rvalue"));
          });
		</script>
        <br>
        </div>
        </div>
        <div class="revcon">
        <div class="rcon">
        <p><label>구매후기:
        <form:textarea path="reviewContent" class="revcontent" placeholder="구매 후기를 남겨주세요" cols="70" rows="5"/>
        </label><br>
        </p>
        </div>
        </div>
        <div class="revsumm">
        <div class="rsumm">
        <p><label>한줄요약:
        <form:input path="reviewSummary" style="width: 500px; border-bottom: 1px solid #ccc;"/>
        </label><br>
        </p>
        </div>
        </div>
        <form:hidden path="orderProductsNo"/>
        <form:hidden path="productNo"/>
        <form:hidden path="productName"/>
        <form:hidden path="productOption"/>
        <form:hidden path="memberNo"/>
        <form:hidden path="memberName"/>
    <div class="revbutton">
	<div class="rbutton">
    <input type="submit" style="width: 200px; height: 50px; " value="등록하기" />
    </div>
    </div>
    </form:form>
    
   	<!--================Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<!--================End Footer Area =================-->
	<%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>
