package com.qingguomama.util;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

public class LeanCloudUtil {//leanCloud信息
    public static String AppId = "YFzggloQWOnyQPwmXGnRHnGW-gzGzoHsz";
    public static  String AppKey = "5pJ2hDHl7FOTWElqoEADa6kR";
    public static String MasterKey = "bfQPDGLeIM8jFBakOJpPgoTA";
    public static void Leancloudstart(){
        AVOSCloud.useAVCloudCN();
        AVOSCloud.initialize(AppId,AppKey,MasterKey);

    }
    public static String getObjectId(String className,String columnName,Object object){
        AVObject avObject = getAvObject(className, columnName, object);
        return avObject.getObjectId();

    }
    public static AVObject getAvObject(String className,String columnName,Object object){
        Leancloudstart();
        AVQuery avQuery = getAVQuery(className, columnName, object);
        AVObject avObject=null;
        try {
            avObject= avQuery.getFirst();
        } catch (AVException e) {
            e.printStackTrace();
        }
        return avObject;


    }
    public static  AVQuery getAVQuery(String className,String columnName,Object object){
        Leancloudstart();
        if(object==null){
          //  start();
            AVQuery<AVObject> avQuery = new AVQuery<>(className);

            return avQuery;

        }else {
           // start();
            AVQuery<AVObject> avQuery = new AVQuery<>(className);
            AVQuery<AVObject> avQuery1 = null;
            AVObject avObject = null;
            try {
                avQuery1 = avQuery.whereEqualTo(columnName, object);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return avQuery1;
        }
    }
}
