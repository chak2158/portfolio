package com.goupang.www.dto.product;

public class ProductUpdate {
    
    String productName;
    int sellerNo;
    String productBrand;
    int productPrice;
    int productStock;
    String productOption;
    String productContent;
    
    ProductUpdate(){};
    
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getSellerNo() {
        return sellerNo;
    }
    public void setSellerNo(int sellerNo) {
        this.sellerNo = sellerNo;
    }
    public String getProductBrand() {
        return productBrand;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    public int getProductStock() {
        return productStock;
    }
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    public String getProductOption() {
        return productOption;
    }
    public void setProductOption(String productOption) {
        this.productOption = productOption;
    }
    public String getProductContent() {
        return productContent;
    }
    public void setProductContent(String productContent) {
        this.productContent = productContent;
    }
    
    
}
