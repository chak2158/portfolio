package com.goupang.www.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.product.Product;
import com.sun.org.glassfish.gmbal.ParameterNames;

public interface ProductDAO {

    List<Product> selectProductList(@Param("sellerNo") int sellerNo) throws Exception;
    
    void insertProduct(
            
            @Param("productName") String productName,
            @Param("sellerNo") int sellerNo,
            @Param("productBrand") String productBrand,
            @Param("productPrice") int productPrice,
            @Param("productStock") int productStock,
            @Param("productOption") String productOption,
            @Param("productContent") String productContent
            
            )throws Exception;
    
    List<Product> selectProductByProductNo(@Param("productNo")int productNo);
    
    int updateProduct(Product product
            
//            @Param("productName") String productName,
//            @Param("sellerNo") int sellerNo,
//            @Param("productBrand") String productBrand,
//            @Param("productPrice") int productPrice,
//            @Param("productStock") int productStock,
//            @Param("productOption") String productOption,
//            @Param("productContent") String productContent
            
            
            );

    
    void deleteProduct(@Param("productNo")int productNo)throws Exception;

    void deleteProductImg(@Param("productNo")int productNo)throws Exception;
    
    List<Product> selectProductListByCategory(@Param("categoryNo")int categoryNo)throws Exception;

    
    List<Product> selectProductImgByProductNo(@Param("productNo")int productNo) throws Exception;

    int maxProductNo();
//    int countProduct();

}
