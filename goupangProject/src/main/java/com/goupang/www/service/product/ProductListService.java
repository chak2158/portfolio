package com.goupang.www.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goupang.www.dao.product.ProductDAO;
import com.goupang.www.dto.product.Product;

@Service
@Transactional
public class ProductListService {
	
	@Autowired
	private ProductDAO productDAO;
		
	public List<Product> selectProductList(int sellerNo) throws Exception {
		return productDAO.selectProductList(sellerNo);
	}

	public List<Product> selectProductByProductNo(int productNo) throws Exception {
        return productDAO.selectProductByProductNo(productNo);
    }
	
	public List<Product> selectProductListByCategory(int categoryNo) throws Exception {
        return productDAO.selectProductListByCategory(categoryNo);
    }
	
}


	


