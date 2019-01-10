package com.qingguomama.service.impl;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.qingguomama.bean.Artical;
import com.qingguomama.bean.Follow;
import com.qingguomama.service.FollowService;
import com.qingguomama.util.DistanceUtil;
import com.qingguomama.util.LeanCloudUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FollowServiceImpl implements FollowService {
    @Override
    public List<Artical> selectService(String fans,double userlongitude,double latitude) {
        LeanCloudUtil.start();
        String cql = "select * from Follow where fans = ?";
        AVCloudQueryResult avQuery=null;
        try {
           avQuery = AVQuery.doCloudQuery(cql, Arrays.asList(fans));
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<? extends AVObject> avObjects = avQuery.getResults();
        List<Follow> followList=new ArrayList<>();
        for (AVObject avObject : avObjects) {
            Follow follow = new Follow();
            follow.setFans(avObject.getString("fans"));
            follow.setFollowed(avObject.getString("followed"));
            follow.setObjectId(avObject.getObjectId());
            System.out.println(follow.getFollowed());
            followList.add(follow);
        }



       List<Artical> articalArrayList = new ArrayList<>();
        for (Follow follow : followList) {
            System.out.println(follow.getFollowed());

            AVQuery avQuery1 = LeanCloudUtil.getAVQuery("artical", "user", follow.getFollowed());
            List<AVObject> avObjects1=null;
            try {
               avObjects1=avQuery1.find();
//                articalArrayList.addAll(
            } catch (AVException e) {
                e.printStackTrace();
            }
            for (AVObject avObject : avObjects1) {
                Artical artical = new Artical();
                artical.setContent(avObject.getString("content"));
                artical.setAllRate(avObject.getString("allRate"));
                artical.setClickrate(avObject.getInt("clickrate"));
                artical.setCollectionNum(avObject.getInt("comment_num"));
                artical.setCreateDate(avObject.getDate("createDate"));
                artical.setLatitude(avObject.getDouble("latitude"));
                artical.setLikesNum(avObject.getInt("likes_num"));
                artical.setLongitude(avObject.getDouble("longitude"));
                artical.setObjectId(avObject.getObjectId());
                artical.setPics(artical.getPics());
                artical.setTransmit(avObject.getString("transmit"));
                artical.setUser(avObject.getString("user"));
                artical.setVideo(avObject.containsKey("isVideo"));
                artical.setVideoThumpPath(avObject.getString("video_thump_path"));
                articalArrayList.add(artical);

            }
        };
        for (Artical artical : articalArrayList) {
            artical.setDistance(DistanceUtil.distanceUtil(userlongitude,latitude,artical.getLongitude(),artical.getLatitude()));
        }
        return articalArrayList;
        


    }
}
