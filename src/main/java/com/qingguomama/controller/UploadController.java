package com.qingguomama.controller;

import com.qingguomama.bean.Img;
import com.qingguomama.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@CrossOrigin(origins = {"http://localhost:2182"})
public class UploadController {
    @Autowired
    private UploadService uploadService;



    @RequestMapping(value="/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file/*, @RequestParam("currentUser") String currentUser*/,HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        if (file != null) {
            String URL = uploadService.upload(file/*,currentUser*/);
            System.out.println(URL);
            request.setAttribute("filePath", URL);
            return URL;
        } else {
            return "fail";
        }//返回值给微信小程序


        //abcaaa
        //测试git提交

    }
        @RequestMapping(value="/getLoader")
        @ResponseBody
        public Img getLoader(@RequestParam("Url") String url/*, @RequestParam("currentUser") String currentUser*/,HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
            Img img = uploadService.getImg(url);
            return img;

        }






}
