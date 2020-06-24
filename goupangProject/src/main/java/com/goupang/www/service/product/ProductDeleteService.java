package com.goupang.www.service.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.product.ProductDAO;


@Service
@Transactional
public class ProductDeleteService {
	
	@Autowired
	private ProductDAO productDAO;

	public String deleteProduct(int productNo) {
		try {
		    productDAO.deleteProductImg(productNo);
		    productDAO.deleteProduct(productNo);
			return null;
		} catch (Exception e) {
			return "삭제할 수 없습니다.";
		}
	}


}


	


