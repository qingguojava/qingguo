package com.qingguomama.service;

import com.qingguomama.bean.Artical;

import java.util.List;

public interface FollowService {
    List<Artical> selectService(String fans,double userlongitude,double latitude);
}
