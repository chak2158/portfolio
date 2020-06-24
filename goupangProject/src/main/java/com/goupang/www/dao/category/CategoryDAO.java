package com.goupang.www.dao.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goupang.www.dto.category.Category;

public interface CategoryDAO {

    List<Category> selectCategoryList(@Param("categoryNo") int categoryNo) throws Exception;
        
}
