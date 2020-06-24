package com.goupang.www.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.goupang.www.common.AuthCheckInterceptor;


@Configuration
@EnableWebMvc
@Import({DBConfig.class,SqlMapperConfig.class/*,someConfig.class*/})
@ComponentScan(basePackages = {"com.goupang.www"})
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("home");
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authCheckInterceptor())
			.addPathPatterns("/inquiry/**")
			.excludePathPatterns("/inquiry/inquiryList")
			.addPathPatterns("/review/**")
			.excludePathPatterns("/review/reviewList")
			.addPathPatterns("/admin/**")
			.addPathPatterns("/cart/**")
			.addPathPatterns("/order/**")
			.addPathPatterns("/product/**")
			.excludePathPatterns("/product/productDetailList")
			.excludePathPatterns("/product/productCategoryList")
			;

	}


//	@Bean
//	public AuthCheckInterceptor authCheckInterceptor() {
//		return new AuthCheckInterceptor();
//	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}

	//파일업로드
	@Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10 * 1024 * 1024); //10MB
        multipartResolver.setMaxUploadSizePerFile(10 * 1024 * 1024); //10MB
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;
    }
	
	/* static file(image, sound, css, javascript) 경로 지정 */

    @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
         registry.addResourceHandler("/uploadImages/**").addResourceLocations("file:///c:/uploadImages/");
     }
	
}