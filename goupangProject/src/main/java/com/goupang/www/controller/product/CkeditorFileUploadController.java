package com.goupang.www.controller.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

@Controller
@RequestMapping("/product")
public class CkeditorFileUploadController {

    @RequestMapping(value = "regist.do", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(HttpServletRequest req, HttpServletResponse resp, MultipartHttpServletRequest multiFile)
            throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>> hahahahahahahahah >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        JsonObject json = new JsonObject();
        PrintWriter printWriter = null;
        OutputStream out = null;
        MultipartFile file = multiFile.getFile("upload");
        System.out.println("size: >>>>>>>>>>>>>"  + file.getSize());
        //파일이 비어있지 않고
        if (file != null) {
        	//파일 사이즈 0 이상이며 파일 이름이 비어있지 않을 때
            if (file.getSize() > 0 && !(file.getName().equals(null))) {
            	//파일의 확장자명? 을 소문자로 만드는데 이미지/로 시작
                if (file.getContentType().toLowerCase().startsWith("image/")) {
                    try {
                    	//유니크한id-파일 원래이름
                        String fileName = UUID.randomUUID().toString()+ "-"+file.getOriginalFilename();
                        System.out.println("fileName: >>>>>>>>>>>>>"  + fileName);
                        //업로드시 사용할 경로 - 실제 디렉터리 경로
                        String uploadPath = "c:/uploadImages/ckUpload";
                        //url작성을 위한 상대경로?미리보기에 사용
                        String imagePath = "/uploadImages/ckUpload";
                        byte[] bytes = file.getBytes();
                        //업로드시 사용할 경로 - 실제 디렉터리 경로
                        String realPath = uploadPath;
                        System.out.println("realPath: "+realPath);
                        
                        File uploadFile = new File(realPath);
                        //파일 경로가 있는지 검사
                        if (!uploadFile.exists()) {
                        	//없으면 디렉토리 생성
                            uploadFile.mkdirs();
                        }
                        //진짜 쓸 파일 경로
                        realPath = realPath + "/" + fileName;
                        //실제 파일 경로 기준으로 내보낼 파일 경로를 받아옴
                        out = new FileOutputStream(new File(realPath));
                        //내보낼 파일을 바이트 형식으로 쌓음
                        out.write(bytes);
                        //내보냄
                        out.flush();
                        //업로드된 파일을 실제로 만듬?
                        printWriter = resp.getWriter();
                        //?
                        resp.setContentType("text/html");
                        //파일 상대경로
                        String fileUrl = req.getContextPath()+imagePath+"/"+fileName;

                        // json 데이터로 등록
                        // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
                        // 이런 형태로 리턴이 나가야함.
                        json.addProperty("uploaded", 1);
                        json.addProperty("fileName", fileName);
                        json.addProperty("url", fileUrl);
                        System.out.println(json.toString());
                        printWriter.println(json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (out != null) {
                            out.close();
                        }
                        if (printWriter != null) {
                            printWriter.close();
                        }
                    }
                }
            }
        }
        return null;
    }

}