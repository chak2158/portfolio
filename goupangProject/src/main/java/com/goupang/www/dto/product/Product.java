package com.goupang.www.dto.product;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
@Repository
public class Product {

    private int productNo;
    private int sellerNo;
    private String productName;
    private int productPrice;
    private String productBrand;
    private int productStock;
    private String productOption;
    private String productContent;
    private String productRegDate;
    private String productDelDate;
    private String productSellStartDate;
    private String productSellEndDate;
    private String productAvgRate;
    private MultipartFile[] files;
    
    public Product() {};    
    
    public MultipartFile[] getFiles() {
        return files;
    }
    
    public Product(int productNo, int sellerNo, String productName, int productPrice, String productBrand,
            int productStock, String productOption, String productContent, String productRegDate, String productDelDate,
            String productSellStartDate, String productSellEndDate, String productAvgRate) {

        this.productNo = productNo;
        this.sellerNo = sellerNo;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBrand = productBrand;
        this.productStock = productStock;
        this.productOption = productOption;
        this.productContent = productContent;
        this.productRegDate = productRegDate;
        this.productDelDate = productDelDate;
        this.productSellStartDate = productSellStartDate;
        this.productSellEndDate = productSellEndDate;
        this.productAvgRate = productAvgRate;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
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

    public String getProductRegDate() {
        return productRegDate;
    }

    public void setProductRegDate(String productRegDate) {
        this.productRegDate = productRegDate;
    }

    public String getProductDelDate() {
        return productDelDate;
    }

    public void setProductDelDate(String productDelDate) {
        this.productDelDate = productDelDate;
    }

    public String getProductSellStartDate() {
        return productSellStartDate;
    }

    public void setProductSellStartDate(String productSellStartDate) {
        this.productSellStartDate = productSellStartDate;
    }

    public String getProductSellEndDate() {
        return productSellEndDate;
    }

    public void setProductSellEndDate(String productSellEndDate) {
        this.productSellEndDate = productSellEndDate;
    }

    public String getProductAvgRate() {
        return productAvgRate;
    }

    public void setProductAvgRate(String productAvgRate) {
        this.productAvgRate = productAvgRate;
    }

    
    
    
    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Product [productNo=" + productNo + ", sellerNo=" + sellerNo + ", productName=" + productName
                + ", productPrice=" + productPrice + ", productBrand=" + productBrand + ", productStock=" + productStock
                + ", productOption=" + productOption + ", productContent=" + productContent + ", productRegDate="
                + productRegDate + ", productDelDate=" + productDelDate + ", productSellStartDate="
                + productSellStartDate + ", productSellEndDate=" + productSellEndDate + ", productAvgRate="
                + productAvgRate + "]";
    }
    
    
    
    
     
}
