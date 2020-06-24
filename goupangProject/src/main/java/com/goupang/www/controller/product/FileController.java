package com.goupang.www.controller.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.goupang.www.service.product.FileUploadService;


@Controller
public class FileController {

	@Resource(name = "fileuploadService")
	private FileUploadService fileUploadService;
	
	@GetMapping( "/uploadImages" )
	public String form() {
		return "uploadForm";
	}
	
	@PostMapping( "/product/productDetailList" )
	public String upload(
			Model model,
			@RequestParam("files") MultipartFile[] files) {
		//System.out.println("upload controller: 올리기 시작");
		//로그레벨: TRACE > // DEBUG > INFO > WARN > ERROR > FATAL
		//logger.debug("upload controller: 올리기 시작");
		System.out.println("files >>>>>> " + files);
		//int result = fileUploadService.restore(files);
		String url = "";
        /*
         * if(result > 0) { url = "result"; }
         */
		model.addAttribute("url", url); //url들이 썸네일임
		return "result";
	}
}
