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
</style>
	<!--================Top Header Area =================-->
	<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
	<div class="header_top_area" >
		<div class="container">
			<div>
				<div class="top_right_header" >
				<div class="container">
					<div class="row">
						<div class="col-lg-6" style="text-align: left;">
						<ul class="top_right" >
							<a href="#" id="favorite" title="즐겨찾기 등록"> 즐겨찾기 <i class="far fa-bookmark"></i></a>
						</ul>
						</div>
						<div class="col-lg-6">
							<ul class="top_right" >
							<c:if test="${empty authInfo}">
							<a href="${pageContext.request.contextPath}/member/step1" ">회원 가입</a>
								<a href="${pageContext.request.contextPath}/member/login" >로그인</a>
							</c:if>
							<c:if test="${! empty authInfo}">
								<c:if test="${authInfo.grant > 1}">
								<a href="${pageContext.request.contextPath}/sellerHome" >판매자 페이지</a>
								</c:if>
								<c:if test="${authInfo.grant > 2}">
								<a href="${pageContext.request.contextPath}/admin">관리자 페이지</a>
								</c:if>
								
								<a href="#" style="color: black;" onclick="chatBot()">채팅봇상담</a>
								<a href="${pageContext.request.contextPath}/member/myPage" >마이페이지</a>
								<a href="${pageContext.request.contextPath}/cart/cartList" >장바구니</a>
								<a href="${pageContext.request.contextPath}/member/logout" >로그아웃</a>
							
							</c:if>
	
						</ul>
						</div>
					</div>
				</div>

		

					
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3">
					<div class="top_header_left">
						<!-- 헤더 탑 왼쪽 빈공간 -->
						



					</div>
				</div>
				<div class="col-lg-6">
					<div class="top_header_middle">
    
						<a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/assets/img/title.png"></a>
						
						<div class="input-group" style="margin: 20px;">
							<input type="text" class="form-control" placeholder="최저가 검색"
								aria-label="Search" id="search" >
								<span class="input-group-btn">
								<button class="btn btn-secondary" type="button" onclick="search()">
									<i class="icon-magnifier"></i>
								</button>
							</span>
						</div>
					</div>
				</div>
				<div class="col-lg-3" style="color: white; ">
					<div class="top_right_header" >
						<ul class="top_right" >

							<c:if test="${! empty authInfo}">


								<p  style="color: black;"><b style="font-size: 1.1em;">${authInfo.name}</b>님,환영합니다.</p>
							</c:if>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
		    var autocomplete_text = ["자동완성기능","Autocomplete","자동차","자기부상열차"];
		    $("#search").autocomplete({
		        source : function( request, response ) {
		             $.ajax({
		                    type: 'post',
		                    url: "${pageContext.request.contextPath}/search/searchJson?keyword="+$("#search").val(),
		                    dataType: "json",
		                    data: { value : request.term },
		                    success: function(data) {
		                    	console.log(data);
		                    	response(
	                    			$.map(data,function(item){
                    						return {label: item, value: item}
                    					}
	                    			)
                    			)
	                    	}
		               });   

		            },
		        minLength: 2
		    }); 
		                  
		    $("#search").keydown(function() {
		 	   var content = $(this).val();
		 	   if(event.keyCode == 13){
		 		   search();
		 		 }
		    });
		    //즐겨찾기
		    $('#favorite').on('click', function(e) { var bookmarkURL = window.location.href; var bookmarkTitle = document.title; var triggerDefault = false; if (window.sidebar && window.sidebar.addPanel) {
		    	// Firefox version < 23 
		    	window.sidebar.addPanel(bookmarkTitle, bookmarkURL, ''); } else if ((window.sidebar && (navigator.userAgent.toLowerCase().indexOf('firefox') > -1)) || (window.opera && window.print)) {
		    		// Firefox version >= 23 and Opera Hotlist
		    		var $this = $(this); $this.attr('href', bookmarkURL); $this.attr('title', bookmarkTitle); $this.attr('rel', 'sidebar'); $this.off(e); triggerDefault = true; } else if (window.external && ('AddFavorite' in window.external)) {
		    			// IE Favorite 
		    			window.external.AddFavorite(bookmarkURL, bookmarkTitle); } else {
		    				// WebKit - Safari/Chrome 
		    				alert((navigator.userAgent.toLowerCase().indexOf('mac') != -1 ? 'Cmd' : 'Ctrl') + '+D 키를 눌러 즐겨찾기에 등록하실 수 있습니다.'); } return triggerDefault; });

		    	
		    
		});
		function search(){
			var url = "${pageContext.request.contextPath}/search/search?keyword="+$("#search").val();
			location.href=url;
		}
		function chatBot(){
			var name = "${authInfo.name}";
			window.open('http://192.168.0.123:3000/?name='+name+' 고객님', '_blank','width = 500, height = 500, top = 100, left = 200, location = no, menubar=no');
			/* window.open('http://localhost:3000/?name='+name+' 고객님', '_blank','width = 500, height = 500, top = 100, left = 200, location = no'); */
		}

/* 
 $( function() {
     $("#search").keydown(function() {
    	   var content = $(this).val();
    	   if(event.keyCode == 13){
    		   search();
    		 }
       });
	 
	    var availableTags = [
	      "ActionScript",
	      "AppleScript",
	      "Asp",
	      "BASIC",
	      "C",
	      "C++",
	      "Clojure",
	      "COBOL",
	      "ColdFusion",
	      "Erlang",
	      "Fortran",
	      "Groovy",
	      "Haskell",
	      "Java",
	      "JavaScript",
	      "Lisp",
	      "Perl",
	      "PHP",
	      "Python",
	      "Ruby",
	      "Scala",
	      "Scheme"
	    ];
	    $( "#search" ).autocomplete({
	      source: availableTags
	    });
	     */

</script>

	<!--================End Top Header Area =================-->
	
	
	<!-- 


<div class="ui-widget">
  <label for="tags">검색: </label>
  <input id="tags" >
</div>
 

    
</body>
</html>
	
	
	 -->