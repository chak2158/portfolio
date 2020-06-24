<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<script src="//cdn.ckeditor.com/4.14.0/standard/ckeditor.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <title>상품수정</title>
</head>
<body>
    <h2>수정</h2>
    <form:form action="${pageContext.request.contextPath}/product/productUpdate" modelAttribute="product" enctype="multipart/form-data">
    <p>
        <label><br>
        물품번호 : <form:hidden path="productNo" value="${product.productNo}" readonly="readonly" />${product.productNo}<br>
        판매자번호 : <form:hidden path="sellerNo"  value="${product.sellerNo}" readonly="readonly" />${product.sellerNo}<br> 
        상품명 : <form:input path="productName" /> <br>
        브랜드명 : <form:input path="productBrand" /> <br>
        가격 : <form:input path="productPrice" /> <br>
        재고량 : <form:input path="productStock" /> <br>
        옵션 : <form:input path="productOption" /> <br>
        ┌ 상세정보 ┐ <form:textarea class="ckeditor" name="productContent" id="productContent" path="productContent"/> 
            
            <script>
                        var ckeditor_config = {
                            height : 300,
                            resize_enable : false,
                            enterMode : CKEDITOR.ENTER_BR,
                            shiftEnterMode : CKEDITOR.ENTER_P,
                            filebrowserUploadUrl : "${pageContext.request.contextPath}/product/regist.do"
                        };

                        CKEDITOR.replace("productContent", ckeditor_config);
                    </script>
                
            대표이미지 : <br>
            <form:input path="files"  type="file"  multiple="multiple"/>
         <!--   <input type="file" id="files" name="files" multiple="multiple"/> -->
            <div class="select_img"><img src="" /></div>
             <script>
               $("#files").change(function(){
                    if(this.files && this.files[0]) {
                         var reader = new FileReader;
                          reader.onload = function(data) {
                 $(".select_img img").attr("src", data.target.result).width(500);        
                    }
                    reader.readAsDataURL(this.files[0]);
                    }
                 });
             </script>
         
            
            </label>
    </p>

    <input type="submit" value="상품수정">
    </form:form>
</body>
</html>
