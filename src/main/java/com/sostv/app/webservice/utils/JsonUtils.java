package com.sostv.app.webservice.utils;

import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonUtils {

	public static String toJson(Object obj){
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new SosJsonValueProcessor());
		JSONArray jsonArray = JSONArray.fromObject(obj,config);
		return jsonArray.toString();
	}
	
	public static String toJsonObject(Object object){
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Date.class, new SosJsonValueProcessor());
		JSONObject jsonObject = JSONObject.fromObject(object, config);
		return jsonObject.toString();
	}
}
