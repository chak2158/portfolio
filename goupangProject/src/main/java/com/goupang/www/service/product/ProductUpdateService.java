package com.goupang.www.service.product;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.product.ProductDAO;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductRequest;
import com.goupang.www.dto.product.ProductUpdate;


@Service
@Transactional
public class ProductUpdateService {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;
	public void insertProductList(ProductRequest productReq) throws Exception {
		
		//System.out.println("selectInquiryList:"+inquiryReq.toString());
		
	    productDAO.insertProduct(
                productReq.getProductName(),
                productReq.getSellerNo(),
                productReq.getProductBrand(),
                productReq.getProductPrice(),
                productReq.getProductStock(),
                productReq.getProductOption(),
                productReq.getProductContent()
                );
	    
	    int productNo = product.getProductNo();
	    productDAO.selectProductImgByProductNo(productNo);
	}

	
	public ProductUpdate selectProduct(int productNo) {
		 List<Product> productList = productDAO.selectProductByProductNo(productNo);
		 productList.get(0);
		return null;
	}


//	public void updateProduct(Product product)throws Exception {
//	    productDAO.updateProduct(product
//				product.getProductName(),
//				product.getSellerNo(),
//				product.getProductBrand(),
//				product.getProductPrice(),
//				product.getProductStock(),
//				product.getProductOption(),
//				product.getProductContent()
//				);	    
//	    System.out.println("product >>>>>>>>>>>>서비스" +product);
//	}


    public int updateProductList(Product product) {
        try {
            System.out.println("product >>>>>>>>>>>>" +product);
            int result = productDAO.updateProduct(product
//                    product.getProductName(),
//                    product.getSellerNo(),
//                    product.getProductBrand(),
//                    product.getProductPrice(),
//                    product.getProductStock(),
//                    product.getProductOption(),
//                    product.getProductContent()
                    );
            System.out.println("result >>>>>>>>>>>>>>>>>>>>>>>>> "+ result);
        } catch (Exception e) {
          
            e.printStackTrace();
        }
        
        return product.getProductNo();
    }

}


	


