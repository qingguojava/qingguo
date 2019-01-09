package com.qingguomama.util;

import com.avos.avoscloud.AVOSCloud;

public class LeanCloudUtil {//leanCloud信息
    public static String AppId = "YFzggloQWOnyQPwmXGnRHnGW-gzGzoHsz";
    public static  String AppKey = "5pJ2hDHl7FOTWElqoEADa6kR";
    public static String MasterKey = "bfQPDGLeIM8jFBakOJpPgoTA";
    public static void start(){
        AVOSCloud.useAVCloudCN();
        AVOSCloud.initialize(AppId,AppKey,MasterKey);

    }
}
