package com.goupang.www.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goupang.www.dao.product.FileUploadDao;
import com.goupang.www.dao.product.ProductDAO;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductImage;

@Service
@Transactional
public class ProductImgListService {
	
	@Autowired
	private FileUploadDao fileuploadDao;
		
	public List<ProductImage> selectImg(int productNo) throws Exception {
        return fileuploadDao.selectImg(productNo);
    }
	
	public List<ProductImage> selectImgByCate(int categoryNo) throws Exception {
        return fileuploadDao.selectImgByCate(categoryNo);
    }
	
}


	


