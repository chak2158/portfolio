package com.goupang.www.dao.search;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.product.Product;

public interface SearchDAO {

	List<Product> selectProductListByProductName(@Param("productName") String productName) throws Exception;
	List<String> selectProductNameListByProductName(@Param("productName") String productName) throws Exception;
}
