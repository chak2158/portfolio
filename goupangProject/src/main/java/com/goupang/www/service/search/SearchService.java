package com.goupang.www.service.search;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.search.SearchDAO;
import com.goupang.www.dto.product.Product;

@Service
@Transactional
public class SearchService {
	
	@Autowired
	private SearchDAO searchDAO;
	public List<Product> selectProductList(String productName) throws Exception {
		return searchDAO.selectProductListByProductName(productName);
	}
	public List<String> selectProductNameList(String productName) throws Exception {
		return searchDAO.selectProductNameListByProductName(productName);
				
	}


	
}


	


