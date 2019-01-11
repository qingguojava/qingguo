package com.qingguomama.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 */
public class Msg {
	//状态码   100-成功    200-失败
	private int code;
	//提示信息
	private String msg;
	//用户要返回给浏览器的数据
	private Map<String, Object> extend = new HashMap<String, Object>();
	private Object object;
	public static Msg success(){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("处理成功！");
		return result;
	}
	
	public static Msg success(Object object){
		Msg result = new Msg();
		result.setCode(100);
		result.setMsg("处理成功！");
		result.setObject(object);
		return result;
	}
	

	
	public static Msg fail(){
		Msg result = new Msg();
		result.setCode(200);
		result.setMsg("处理失败！");
		return result;
	}
	
	
	//返回方法add()的定义
	public Msg add(String key,Object value){
		this.getExtend().put(key, value);
		return this;
	}
	
	//返回方法add()的定义
	public Msg addObject(Object obj){
		this.setObject(obj);
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

	
	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	
}
