package com.qingguomama.bean;

import com.avos.avoscloud.AVGeoPoint;

public class Follow {
    private String ObjectId;
    private AVGeoPoint fans;
    private AVGeoPoint followed;

    public String getObjectId() {
        return ObjectId;
    }

    public void setObjectId(String objectId) {
        ObjectId = objectId;
    }

    public AVGeoPoint getFans() {
        return fans;
    }

    public void setFans(AVGeoPoint fans) {
        this.fans = fans;
    }

    public AVGeoPoint getFollowed() {
        return followed;
    }

    public void setFollowed(AVGeoPoint followed) {
        this.followed = followed;
    }
}
