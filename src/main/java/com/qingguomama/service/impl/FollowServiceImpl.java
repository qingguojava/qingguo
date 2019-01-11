package com.qingguomama.service.impl;

import com.avos.avoscloud.*;
import com.qingguomama.bean.Artical;
import com.qingguomama.service.FollowService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.qingguomama.util.LeanCloudUtil.Leancloudstart;


public class FollowServiceImpl implements FollowService {
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    public   List<String> followIdList = new ArrayList<>();
    AVQuery<AVObject> user =null;

    public List<String> selectFollowId(String fans, double userlongitude, double latitude) {
        Leancloudstart();
        AVObject tag = AVObject.createWithoutData("_User", fans);
        AVQuery<AVObject> query = new AVQuery<>("Follow");
        query.whereEqualTo("fans", tag);
        try {
            List<AVObject> list = query.find();
            for (AVObject avObject : list) {
                AVObject followed = avObject.getAVObject("followed");
                String objectId = followed.getObjectId();
                followIdList.add(objectId);
            }
        } catch (AVException e) {
            e.printStackTrace();
        }
        return followIdList;
    }

    public  List<Artical> selectArtical(List<String> followIdList, double userlongitude, double latitude) {
        Leancloudstart();
        List<Artical> articalArrayList = new ArrayList<>();

        for (String followId : followIdList) {
            AVObject tag = AVObject.createWithoutData("_User", followId);
            AVQuery<AVObject> query = new AVQuery<>("artical");
            AVQuery<AVObject> userToArtical = query.whereEqualTo("user", tag);
            try {
                List<AVObject> avObjects = userToArtical.find();
                for (AVObject studentCourseMap : avObjects) {
                    Artical artical = new Artical();
                    artical.setContent(studentCourseMap.getString("content"));
                    artical.setAllRate(studentCourseMap.getString("allRate"));
                    artical.setClickrate(studentCourseMap.getInt("clickrate"));
                    artical.setCollectionNum(studentCourseMap.getInt("comment_num"));
                    artical.setPics(studentCourseMap.getList("pics"));
                    artical.setLatitude(studentCourseMap.getDouble("latitude"));
                    artical.setLikesNum(studentCourseMap.getInt("likes_num"));
                    artical.setLongitude(studentCourseMap.getDouble("longitude"));
                    artical.setObjectId(studentCourseMap.getObjectId());
                    artical.setTransmit(studentCourseMap.getString("transmit"));
                    AVObject followed = studentCourseMap.getAVObject("user");
                    artical.setUser(followed.getObjectId());
                    artical.setVideo(studentCourseMap.containsKey("isVideo"));
                    artical.setVideoThumpPath(studentCourseMap.getString("video_thump_path"));
                    articalArrayList.add(artical);
                }

            } catch (AVException e) {
                e.printStackTrace();
            }
        }
            /*for (AVObject studentCourseMap : list1) {
                        Artical artical = new Artical();
                        artical.setContent(studentCourseMap.getString("content"));
                        artical.setAllRate(studentCourseMap.getString("allRate"));
                        artical.setClickrate(studentCourseMap.getInt("clickrate"));
                        artical.setCollectionNum(studentCourseMap.getInt("comment_num"));
                        artical.setCreateDate(studentCourseMap.getDate("createDate"));
                        artical.setLatitude(studentCourseMap.getDouble("latitude"));
                        artical.setLikesNum(studentCourseMap.getInt("likes_num"));
                        artical.setLongitude(studentCourseMap.getDouble("longitude"));
                        artical.setObjectId(studentCourseMap.getObjectId());
                        artical.setTransmit(studentCourseMap.getString("transmit"));
                        AVObject followed = studentCourseMap.getAVObject("user");
                        artical.setUser(followed.getObjectId());
                        artical.setVideo(studentCourseMap.containsKey("isVideo"));
                        artical.setVideoThumpPath(studentCourseMap.getString("video_thump_path"));
                        articalArrayList.add(artical);

                    }
                }

            });
        }

        System.out.println(articalArrayList.size());
        return articalArrayList;
*/
            return articalArrayList;

    }
}