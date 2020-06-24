package com.goupang.www.dto.category;

public class CategoryList {
    
    private int categoryNo; /* 카테고리번호 */
    private String categoryName; /* 카테고리이름 */
    
    public CategoryList() {}
    
    public int getCategoryNo() {
        return categoryNo;
    }
    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
    public CategoryList(int categoryNo, String categoryName) {
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
    }
    
    @Override
    public String toString() {
        return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
    }
    
     
}
