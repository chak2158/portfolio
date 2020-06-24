package com.goupang.www.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.category.CategoryDAO;
import com.goupang.www.dto.category.Category;

@Service
@Transactional
public class CategoryListService {
	
	@Autowired
	private CategoryDAO categoryDAO;
		
	public List<Category> selectCategoryList(int categoryNo) throws Exception {
	    List<Category> cl =  categoryDAO.selectCategoryList(categoryNo);
	    System.out.println(cl.get(0));
	    return cl;
	}
	
	
}


	


