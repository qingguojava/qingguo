package com.qingguomama.bean;

public class Follow {
    private String ObjectId;
    private String fans;
    private String followed;

    public String getObjectId() {
        return ObjectId;
    }

    public void setObjectId(String objectId) {
        ObjectId = objectId;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getFollowed() {
        return followed;
    }

    public void setFollowed(String followed) {
        this.followed = followed;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "ObjectId='" + ObjectId + '\'' +
                ", fans='" + fans + '\'' +
                ", followed='" + followed + '\'' +
                '}';
    }
}
