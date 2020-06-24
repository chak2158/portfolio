package com.goupang.www.dto.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {
    
    private int productNo;
    private int sellerNo;
    private String productName;
    private int productPrice;
    private String productBrand;
    private int productStock;
    private String productOption;
    private String productContent;
    private MultipartFile[] files;
    
    
    

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public ProductRequest() { }
    
    public MultipartFile[] getFiles() {
        return files;
    }
    
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
    public int getSellerNo() {
        return sellerNo;
    }
    public void setSellerNo(int sellerNo) {
        this.sellerNo = sellerNo;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    public String getProductBrand() {
        return productBrand;
    }
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
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
    
    
    @Override
    public String toString() {
        return "ProductRequest [sellerNo=" + sellerNo + ", productName=" + productName + ", productPrice="
                + productPrice + ", productBrand=" + productBrand + ", productStock=" + productStock
                + ", productOption=" + productOption + ", productContent=" + productContent + "]";
    }
    
    
    
}
