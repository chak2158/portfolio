package com.goupang.www.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.product.ProductDAO;
import com.goupang.www.dto.product.ProductRequest;

@Service
@Transactional
public class ProductFormService {
	
    @Autowired
    private ProductDAO productDAO;

    public int insertProductList(ProductRequest productReq) throws Exception {
        
        System.out.println("selectProductList:"+productReq.toString());
        
        productDAO.insertProduct(
                productReq.getProductName(),
                productReq.getSellerNo(),
                productReq.getProductBrand(),
                productReq.getProductPrice(),
                productReq.getProductStock(),
                productReq.getProductOption(),
                productReq.getProductContent()
                );
        
        return productDAO.maxProductNo();
    }
}


	


