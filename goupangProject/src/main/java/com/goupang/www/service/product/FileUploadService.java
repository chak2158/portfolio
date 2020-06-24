package com.goupang.www.service.product;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.goupang.www.controller.product.FileUtil;
import com.goupang.www.dao.product.FileUploadDao;
import com.goupang.www.dao.product.ProductDAO;
import com.goupang.www.dto.product.FileVo;
import com.goupang.www.dto.product.Product;



@Service("fileuploadService")
@Transactional
public class FileUploadService {
    
    @Autowired
    private FileUploadDao fileUploadDao;
    
    // 리눅스 기준으로 파일 경로를 작성 ( 루트 경로인 /으로 시작한다. )
    // upload 폴더를 생성해 놓아야 한다.
    private static final String SAVE_PATH = "C:/uploadImages";
    private static final String THUMBNAIL_PATH = SAVE_PATH +"/thumb";
    private static final String PREFIX_IMG_URL = "/uploadImages/";
    private static final String PREFIX_URL = "/uploadImages/thumb/";
    
    //files[0]은 썸네일 저장하고 나머지는 그냥 저장
    public int restore(MultipartFile[] files,@ModelAttribute("product") int productNo){
       List<String> url = new ArrayList<String>();
       int result = 0;
       try {
          String originFilename = null;
          String extName = null;
          Long size = 0L; 
          String saveFileName = null;
          
          for(int i = 0; i < files.length; i++) {
             if(files[i].getOriginalFilename()!=null && !files[i].getOriginalFilename().isEmpty()) {
                originFilename = files[i].getOriginalFilename();
                extName   = originFilename.substring(originFilename.lastIndexOf("."), originFilename.length());
                size = files[i].getSize();
                //저장할 파일 이름
                saveFileName = genSaveFileName(extName);
                //파일 저장 메소드
                if(i == 0) {   //0번째 파일만 썸네일 저장
                    writeThumbFile(files[i], saveFileName);
                    FileVo fileVo = new FileVo();
                    fileVo.setProductImgPath(PREFIX_IMG_URL + saveFileName);
                   fileVo.setProductThumbPath(PREFIX_URL + saveFileName);
                   String productThumbPath = PREFIX_URL + saveFileName;
                   String productImgPath = PREFIX_IMG_URL + saveFileName;
                   System.out.println(productThumbPath);
                   System.out.println(productImgPath);
                   System.out.println(productNo);
                   //파일 경로 db에 저장
                    fileUploadDao.insertImg(productNo,productImgPath,productThumbPath);
                   
                    //System.out.println(imgPath);
                       //원본, 썸네일 경로 Dao에 저장
                 }else {      //나머지 파일은 그냥 저장
                    writeFile(files[i], saveFileName);
                    FileVo fileVo = new FileVo();
                    fileVo.setProductImgPath(PREFIX_IMG_URL + saveFileName);
                 }
                url.add(PREFIX_IMG_URL + saveFileName);   //view에 출력할 썸네일 url list
             }else {
                System.out.println("file없음");
                result = 9;
             }
          }
       } catch (IOException e) {
          throw new RuntimeException(e);
       }
       return result;
    }
    
    // 현재 시간을 기준으로 파일 이름 생성
    private String genSaveFileName(String extName) {
       String fileName = "";
       
       Calendar calendar = Calendar.getInstance();
       fileName += calendar.get(Calendar.YEAR);
       fileName += calendar.get(Calendar.MONTH);
       fileName += calendar.get(Calendar.DATE);
       fileName += calendar.get(Calendar.HOUR);
       fileName += calendar.get(Calendar.MINUTE);
       fileName += calendar.get(Calendar.SECOND);
       fileName += calendar.get(Calendar.MILLISECOND);
       fileName += extName;
       
       return fileName;
    }
    
    // 파일을 실제로 write 하는 메서드
    private void writeFile(MultipartFile multipartFile, String saveFileName)
                         throws IOException{
       String filePath = SAVE_PATH + "/" + saveFileName;

       File file = new File(filePath);
       multipartFile.transferTo(file);
       
    }
    
    // thumb 저장하는 메서드
    private void writeThumbFile(MultipartFile multipartFile, String saveFileName)
                         throws IOException{
       String filePath = SAVE_PATH + "/" + saveFileName;
       String thumbfilePath = THUMBNAIL_PATH + "/" + saveFileName;
       
       File file = new File(filePath);
       multipartFile.transferTo(file);
       
       //Image Crop & Resize...
         try {
          FileUtil.imageResize(filePath, thumbfilePath, "jpg");
       } catch (Exception e) {
           System.out.println("imageResize Error");
          e.printStackTrace();
       }
    }
}
    
