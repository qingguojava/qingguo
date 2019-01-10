package com.qingguomama.service.impl;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVSaveOption;
import com.google.gson.Gson;
import com.qingguomama.bean.Img;
import com.qingguomama.exception.UploadException;
import com.qingguomama.service.UploadService;
import com.qingguomama.util.LeanCloudUtil;
import com.qingguomama.util.QiniuUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    //引入第一步的七牛配置



    public String upload(MultipartFile image/*,String currentUser*/) throws UploadException {
///构造一个带指定Zone对象的配置类
        String originalFilename = image.getOriginalFilename();
        // 如何取得文件上传的后缀名 zly.jpg
        String extName  = StringUtils.substringAfterLast(originalFilename, ".");
        Configuration cfg = new Configuration(Zone.zone0());
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传

//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = UUID.randomUUID().toString()+ new Date().getMinutes()+"."+extName;
        try {
            byte[] uploadBytes =image.getBytes();
            Auth auth = Auth.create(QiniuUtil.accesskey, QiniuUtil.secretKey);
            String upToken = auth.uploadToken(QiniuUtil.bucketName);
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

        String URL = QiniuUtil.bucketHostName + "/" + key;
        AVObject fileObject = new AVObject("FileAtImg");
        String mime_type = "image/"+extName;

        LeanCloudUtil.start();

        fileObject.put("mime_type",mime_type);
        fileObject.put("name",key);
        fileObject.put("url",URL);
//        fileObject.put("userId",userId);
        fileObject.put("provider","qiniu");
        try {
            fileObject.save();
        } catch (AVException e) {
            e.printStackTrace();
        }


        return URL;
    }
   public Img getImg(String url){
       Img img = new Img();

       AVQuery<AVObject> avQuery = new AVQuery<>("FileAtImg");
       AVObject avObject = null;
       try {
           avObject = avQuery.get(url);
       } catch (AVException e) {
           e.printStackTrace();
       }
       // avObject 就是 id 为 558e20cbe4b060308e3eb36c 的 Todo 对象实例

      img.setMimeType(avObject.getString("mime_type"));
       img.setName(avObject.getString("name"));
       img.setThisUrl(avObject.getString("url"));
       img.setProvider(avObject.getString("provider"));


        return img;
   }

    @Override
    public Img setImg(String url) {

        AVQuery query = new AVQuery("FileAtImg");
        AVObject account = null;
        try {
            account = query.getFirst();
        } catch (AVException e) {
            e.printStackTrace();
        }

        account.getUpdatedAt();

        AVSaveOption option = new AVSaveOption();

        option.setFetchWhenSave(true);
        try {
            account.save(option);
            System.out.println("当前余额为：" + account.getInt("balance"));
        } catch (AVException e){
            if (e != null){
                if (e.getCode() == 305){
                    System.out.println("余额不足，操作失败！");
                }
            }
        }
        return null;
    }


}
