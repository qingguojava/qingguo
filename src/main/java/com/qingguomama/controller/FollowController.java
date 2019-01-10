package com.qingguomama.controller;

import com.qingguomama.bean.Artical;
import com.qingguomama.service.impl.FollowServiceImpl;

import java.util.List;

//@Controller
//@CrossOrigin
public class FollowController {
//    @Autowired
    static FollowServiceImpl followService=new FollowServiceImpl();

//    @RequestMapping(value="/attention")
//    @ResponseBody

    public static List<Artical> attention(/*@RequestParam("fans")String fans, @RequestParam("userlongitude")double userlongitude, @RequestParam("userlatitude") double userlatitude, HttpServletResponse response*/){
//        response.setContentType("text/html;charset=utf-8");
        /* 设置响应头允许ajax跨域访问 */
//        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
//        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String fans="5c0f59059f54540067fc247f";
        double userlongitude =120.1875732421875;
        double userlatitude= 36.331553649902344;
        List<Artical> articalList = followService.selectService(fans, userlongitude, userlatitude);


        return articalList;


    }
}
