package com.goupang.www.controller.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goupang.www.dto.sample.Sample;
import com.goupang.www.service.sample.SampleListService;



@Controller
public class SampleListController {
//	@Autowired
//    private ApplicationContext applicationContext;
	
	
	private SampleListService sampleListService;
	@Autowired
	public void setSampleListService(SampleListService sampleListService) {
		this.sampleListService = sampleListService;
	}
	
//	@GetMapping("/")
//	public void beanPrint() {
//        String[] beanNames = applicationContext.getBeanDefinitionNames();
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        for (String beanName : beanNames) {
//            System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
//        }
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	}

	
	@RequestMapping("/sample/sampleList")
	public String list(Model model) {
		List<Sample> sampleList = sampleListService.list();		
		model.addAttribute("sampleList", sampleList);
		return "sample/sampleList";
	}
	@RequestMapping("/sample/sampleListPagination")
	public String listPagination(Model model) {
		List<Sample> sampleList = sampleListService.listPagination();		
		model.addAttribute("sampleList", sampleList);
		return "sample/sampleList";
	}
	
	@RequestMapping("/sample/sampleAjax")
	public String sampleAjax() {
		
		return "member/memberList";
	}
	@RequestMapping("/sample/sampleMain")
	public String sampleMain() {
		
		return "sample/sampleMain";
	}
	@RequestMapping("/sample/chat")
	public String sampleChat() {
		
		return "http://localhost:3000/";
	}
	
}
