package com.goupang.www.controller.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goupang.www.dto.category.Category;
import com.goupang.www.dto.product.Product;
import com.goupang.www.dto.product.ProductImage;
import com.goupang.www.dto.product.ProductRequest;
import com.goupang.www.service.category.CategoryListService;
import com.goupang.www.service.product.ProductImgListService;
import com.goupang.www.service.product.ProductListService;

@Controller
public class productListByCateController {
    @Autowired
    private ProductListService productListService;
    @Autowired
    private ProductImgListService productImgListService;
    @Autowired
    private CategoryListService categoryListService;

    @RequestMapping("/product/productCategoryList")
    public String list(Model model, @ModelAttribute("product") Product product, @RequestParam int categoryNo
        ) throws Exception {
        // 카테고리 번호로 받아오기
        // int categoryNo = Integer.parseInt(req.getParameter("categoryNo"));
        System.out.println(categoryNo);
        //selectImg 할때 categoryNo 기준으로 productNo List 뽑아와서 ProductImageList에 사진 넣어서 뽑아와야함
        List<Category> categoryList = categoryListService.selectCategoryList(categoryNo);
        model.addAttribute("categoryList", categoryList);
        List<Product> productList = productListService.selectProductListByCategory(categoryNo);
        if(productList != null) {
        List<ProductImage> productImageList = productImgListService.selectImgByCate(categoryNo);
        System.out.println("productList>>>>>>>>>>>>>>>>" + productList);
        System.out.println("productImageList>>>>>>>>>>>>>>>>" + productImageList);
        model.addAttribute("productList", productList);
        model.addAttribute("productImageList", productImageList);
        
        //System.out.println("productImageList.get(0).getProductImgPath()>>>>>"+productImageList.get(0).getProductImgPath());
        if (productImageList.size() != 0) {
            //List<String> imgPath = new ArrayList<String>(); 
            List<String> imgThPath = new ArrayList<String>(); 
            for(ProductImage image : productImageList) {
                //imgPath.add(image.getProductImgPath());
                imgThPath.add(image.getProductThumbPath());
            }
            //model.addAttribute("imgPath", imgPath);
            System.out.println("썸네일 리스트>>>>>>>>>>>>>>>>" + imgThPath);
            model.addAttribute("imgThPath", imgThPath);
        } else {
            String imgPath = "/uploadImages/noimage.jpg";
            String imgThPath = "/uploadImages/thumb/noimageth.jpg";
            //model.addAttribute("imgPath", imgPath);
            model.addAttribute("imgThPath", imgThPath);
        }
        return "/product/productCategoryList";
        } else {
            return "/product/noProduct";
        }
    }
        
}
