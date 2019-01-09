package com.qingguomama.service.impl;

import com.google.gson.Gson;
import com.qingguomama.exception.UploadException;
import com.qingguomama.service.UploadService;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    //引入第一步的七牛配置

    private String accesskey="LGLAi-DeN-8TaVtmT4ajlwoB5ubhqJDnCbxros4H";


    private String secretKey="R-QBk3oTg1aSW9OBFt6OyEOxhueh1EH3fkNvfxxM";


    private String bucketName="qingguomamazuo";


    private String bucketHostName="pka9l5dgc.bkt.clouddn.com";



    public String upload(MultipartFile image,String extName) throws UploadException {
///构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传

//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString()+ new Date().getMinutes()+extName;
        try {
            byte[] uploadBytes =image.getBytes();
            Auth auth = Auth.create(accesskey, secretKey);
            String upToken = auth.uploadToken(bucketName);
            try {
                Response response = uploadManager.put(uploadBytes, key, upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);

            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (UnsupportedEncodingException ex) {
            //ignore
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }




}
