package com.goupang.www.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductImage;

public interface FileUploadDao {

    void insertImg(
            @Param("productNo") int productNo, 
            @Param("productImgPath") String productImgPath,
            @Param("productThumbPath") String productThumbPath);

    void updateImg(
            @Param("productNo") int productNo, 
            @Param("productImgPath") String productImgPath,
            @Param("productThumbPath") String productThumbPath) throws Exception;

    List<ProductImage> selectImg(@Param("productNo") int productNo) throws Exception;

    List<ProductImage> selectImgByCate(@Param("categoryNo") int categoryNo) throws Exception;
}
