package com.goupang.www.dto.product;


public class FileVo {

    private int productImgNo; /* 상품이미지번호 */
    private int productNo ; /* 상품번호 */
    private String productImgPath;
    private String productThumbPath;
    
    
    public int getProductImgNo() {
        return productImgNo;
    }
    public void setProductImgNo(int productImgNo) {
        this.productImgNo = productImgNo;
    }
    public int getProductNo() {
        return productNo;
    }
    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }
    public String getProductImgPath() {
        return productImgPath;
    }
    public void setProductImgPath(String productImgPath) {
        this.productImgPath = productImgPath;
    }
    public String getProductThumbPath() {
        return productThumbPath;
    }
    public void setProductThumbPath(String productThumbPath) {
        this.productThumbPath = productThumbPath;
    }
    
    
    @Override
    public String toString() {
        return "ProductImage [productImgNo=" + productImgNo + ", productNo=" + productNo + ", productImgPath="
                + productImgPath + ", productThumbPath=" + productThumbPath + "]";
    }
    
        

    
 }