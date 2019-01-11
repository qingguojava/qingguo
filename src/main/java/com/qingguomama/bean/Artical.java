package com.qingguomama.bean;

import java.util.Date;
import java.util.List;

public class Artical {

    private String ObjectId;
    private String content;
    private List pics;
    private Integer collectionNum;
    private Double longitude;
    private Integer clickrate;
    private Date createDate;
    private boolean isVideo;
    private String videoThumpPath;
    private String allRate;
    private double latitude;
    private String transmit;

    private  Integer likesNum;
    private String user;
    private String distance;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getObjectId() {
        return ObjectId;
    }

    public void setObjectId(String objectId) {
        ObjectId = objectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List getPics() {
        return pics;
    }

    public void setPics(List pics) {
        this.pics = pics;
    }

    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getClickrate() {
        return clickrate;
    }

    public void setClickrate(Integer clickrate) {
        this.clickrate = clickrate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }

    public String getVideoThumpPath() {
        return videoThumpPath;
    }

    public void setVideoThumpPath(String videoThumpPath) {
        this.videoThumpPath = videoThumpPath;
    }

    public String getAllRate() {
        return allRate;
    }

    public void setAllRate(String allRate) {
        this.allRate = allRate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTransmit() {
        return transmit;
    }

    public void setTransmit(String transmit) {
        this.transmit = transmit;
    }



    public Integer getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(Integer likesNum) {
        this.likesNum = likesNum;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Artical{" +
                "ObjectId='" + ObjectId + '\'' +
                ", content='" + content + '\'' +
                ", pics=" + pics.toString() +
                ", collectionNum=" + collectionNum +
                ", longitude=" + longitude +
                ", clickrate=" + clickrate +
                ", createDate=" + createDate +
                ", isVideo=" + isVideo +
                ", videoThumpPath='" + videoThumpPath + '\'' +
                ", allRate='" + allRate + '\'' +
                ", latitude=" + latitude +
                ", transmit='" + transmit + '\'' +
                ", likesNum=" + likesNum +
                ", user='" + user + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
