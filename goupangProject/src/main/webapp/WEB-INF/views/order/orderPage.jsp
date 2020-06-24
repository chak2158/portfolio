<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
   src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>주문/결제 화면이야</title>
<%@ include file="/WEB-INF/views/include/commonIncludeCSS.jsp"%>
<style>
 .price_method .card-header h5 span {
  background: transparent;
  text-transform: uppercase;
  font-family: "Montserrat", sans-serif;
  font-weight: bold;
  font-size: 14px;
  color: #333333;
  position: relative;
}

</style>
<%@ include file="/WEB-INF/views/include/header.jsp"%>


<%-- ${orderCommand } --%>
</head>
<body>

   <!--================End Categories Banner Area =================-->
   <section class="register_area p_100">
      <div class="container">
         <div class="register_inner">
            <div class="row">
               <div class="col-lg-7">
                  <div class="billing_details">
                        <h2 class="reg_title">Billing Detail</h2>
                        <form class="billing_inner row">
                           <div class="col-lg-12">

                     
                              <div class="form-group">
										<c:forEach var="item" items="${orderCommand}" varStatus="i">
											<c:set var="info" value="${item}" />
                              </c:forEach>
											<label for="name">name </label>
											<input type="hidden" value="${info.value.memberNo }"
												name="memberNo" id="memberNo" />
											<input type="text" class="form-control" id="name"
												aria-describedby="name" value="${info.value.memberName}"
												name="memberName" readonly="readonly" />
									</div>
                           </div>
                           <div class="col-lg-12">
                              <div class="form-group">
                                 <label for="email">Email</label> <input type="email"
                                    class="form-control" id="email" aria-describedby="email"
                                    value="${info.value.memberEmail }" name="memberEmail"
                                    readonly="readonly" />
                              </div>
                           </div>
                           <div class="col-lg-12">
                              <div class="form-group">
                                 <label for="phone">Phone</label> <input type="text"
                                    class="form-control" id="phone" aria-describedby="phone"
                                    value="${info.value.memberPhone }" name="memberPhone">
                              </div>
                           </div>
                        </form>
                        <h2 class="reg_title">Address Detail</h2>
                        <form class="billing_inner row">
                           <div class="col-lg-12">
                              <div class="form-group">
                                 <label for="name">배송지 </label> <input type="text"
                                    class="form-control" aria-describedby="name"
                                    value="서울시 구로구" id="addr" name="orderDeliveryDestination">
                              </div>
                           </div>
                           <div class="col-lg-12">
                              <div class="form-group">
                                 <label for="order">Order Notes</label>
                                 <textarea class="form-control" id="order" rows="3"></textarea>
                              </div>
                           </div>
                        </form>
                  </div>
               </div>
                <div class="col-lg-5">
                  <div class="order_box_price">
                     <h2 class="reg_title">Your Order</h2>
                     <div  class="payment_list">
                        <div class="price_single_cost">
                        <c:forEach var="item" items="${orderCommand}" varStatus="i">
                        <div class="product">
                           <input type="hidden" value="${item.value.cartNo }" name="cartNo" /> 
                              <input type="hidden" value="${item.value.productNo }" name="productNoArr" id="productNo" />
                           <h5>${item.value.productName }
                              <input type="hidden" value="${item.value.orderQty }"
                                 id="orderQty" readonly="readonly" /> 
                                 <span>[${item.value.orderQty }ea]  price: ${item.value.orderQty*item.value.productPrice }
                              </span>
                           </h5>
						</div>
                           </c:forEach>
                           <h3>
                              <span class="normal_text">Order Totals</span><span>${item.value.orderQty*item.value.productPrice }원</span>
                           </h3>
                        </div>


                        <div id="accordion" role="tablist" class="price_method">
                           <div class="card">
                              <div class="card-header" role="tab" id="headingOne">
                                 <h5 class="normal_text">
                                    <input type="radio" name="paymentNo"
                                       onchange="paymentMethod(this)" value="1"><span>계좌이체</span>
                                 </h5>
                              </div>
                              <div class="card-header" role="tab" id="headingOne">
                                 <h5 class="normal_text">
                                    <input type="radio" name="paymentNo"
                                       onchange="paymentMethod(this)" value="2"><span>체크/신용카드</span>
                                 </h5>
                              </div>
                              <div class="card-header" role="tab" id="headingOne">
                                 <h5 class="normal_text">
                                    <input type="radio" name="paymentNo"
                                       onchange="paymentMethod(this)" value="3"><span>휴대폰</span>
                                 </h5>
                              </div>
                              <div class="card-header" role="tab" id="headingOne">
                                 <h5 class="normal_text">
                                    <input type="radio" name="paymentNo"
                                       onchange="paymentMethod(this)" value="4"><span>무통장입금</span>
                                 </h5>
                              </div>
                              <div class="card-body" >
                                 <select id="select" name="select">
                                    <option>선택</option>
                                 </select> <input type="text" id="info" name="info">
                              </div>
                           </div>
                        </div>
                        <input type="button" class="btn subs_btn form-control"
                           onclick="orderBtn()" value="결제하기">
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      </section>





      <script type="text/javascript">
         function paymentMethod(e) {
            var one = [ "-은행-", "국민", "우리", "농협" ];
            var two = [ "-카드사-", "현대", "삼성", "비씨" ];
            var three = [ "-통신사-", "LGU+", "SKT", "KT" ];
            var four = [ "우리 (1002-11-11-11)", "농협 (350-112-111)",
                  "국민(420-0002-1231)" ];
            var target = document.getElementById("select");
            var ph = document.getElementsByName('info')[0];
            if (e.value == "1") {
               var d = one;
               document.getElementById("info").style.display = "block";
               ph.placeholder = '계좌번호를 입력해주세요.';
            } else if (e.value == "2") {
               var d = two;
               document.getElementById("info").style.display = "block";
               ph.placeholder = '카드번호를 입력해주세요';
            } else if (e.value == "3") {
               var d = three;
               document.getElementById("info").style.display = "block";
               ph.placeholder = '휴대폰번호를 입력해주세요';
            } else if (e.value == "4") {
               var d = four;
               document.getElementById("info").style.display = "none";
            }
            target.options.length = 0;
            for (x in d) {
               var opt = document.createElement("option");
               opt.value = d[x];
               opt.innerHTML = d[x];
               target.appendChild(opt);
            }
         }

         function Product(productNo, orderQty) {
            this.productNo = productNo;
            this.orderQty = orderQty;
         }

         function orderBtn() {

            /* var orderNoArr1 = new Array();
            var orderNoArr = $('input[name=productNoArr]');
            console.log("orderNoarr: ",orderNoArr);
            var arrykeys=Object.keys(orderNoArr);
            var orderNoArr1=Object.keys(orderNoArr[0]);
            consloe.log("orderNoArr1",orderNoArr1);
            console.log("orderNoArr",orderNoArr[0]);
            console.log("keys",keys); */
            var orderProductArr = new Array();
            //class=product에서 productNo 값 배열에 담아줌.
            //id=product는 알지 못함.여러개인걸 알 수 없으니까 ==>foreach였잖아
            $(".product").each(function() {
               var productNo = $(this).find('#productNo').val();
               console.log("productNo: ", productNo);
               var orderQty = $(this).find('#orderQty').val();
               console.log("orderQty: ", orderQty);
               orderProductArr.push(new Product(productNo, orderQty));
            });
            console.log("orderProductArr : ", orderProductArr);
            var memberNo = $("#memberNo").val();
            var addr = $("#addr").val();

            var paymentNo = document
                  .querySelector('input[name="paymentNo"]:checked').value;

            var params = {
               orderProductArr : orderProductArr,
               memberNo : memberNo,
               addr : addr,
               paymentNo : paymentNo
            }
            console.log("params: ", params);

            $
                  .ajax({
                     url : "${pageContext.request.contextPath}/order/orderForm",
                     type : "post",
                     contentType : 'application/json; charset=utf-8',
                     data : JSON.stringify(params),
                     success : function(result) {
                        if (result > 0) {
                           location.href = "${pageContext.request.contextPath}/order/orderSuccess";
                        } else {
                           alert("주문실패");
                        }
                     }
                  });
         }
      </script>
      <!--================Footer Area =================-->
      <%@ include file="/WEB-INF/views/include/footer.jsp"%>
      <!--================End Footer Area =================-->
      <%@ include file="/WEB-INF/views/include/commonIncludeJS.jsp"%>
</body>
</html>