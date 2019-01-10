package com.qingguomama.bean;

public class Img {

//    String mime_type = avObject.getInt("mime_type");
//    String key = avObject.getString("name");
//    String thisUrl = avObject.getString("url");
//    String provider = avObject.getString("provider");

    private String mimeType;
    private String name;
    private String thisUrl;
    private String provider;

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThisUrl() {
        return thisUrl;
    }

    public void setThisUrl(String thisUrl) {
        this.thisUrl = thisUrl;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Img() {
    }

    public Img(String mimeType, String name, String thisUrl, String provider) {
        this.mimeType = mimeType;
        this.name = name;
        this.thisUrl = thisUrl;
        this.provider = provider;
    }
}
