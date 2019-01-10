package com.qingguomama.service;

import com.qingguomama.bean.Img;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String upload(MultipartFile image/*,String currentUser*/);
    Img getImg(String url/*,String currentUser*/);
    String updateImg(String url /*,String currentUser*/);
}
