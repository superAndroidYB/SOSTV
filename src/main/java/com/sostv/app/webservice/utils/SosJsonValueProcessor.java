package com.sostv.app.webservice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class SosJsonValueProcessor implements JsonValueProcessor{
	private String format = "yyyy-MM-dd HH:mm:ss";
	
	public SosJsonValueProcessor() {
	}
	
	public SosJsonValueProcessor(String format) {
		this.format = format;
	}

	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		return process(arg0);
	}

	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		return process(arg1);
	}

	private Object process(Object value){ 
		if(value == null) return null;
        if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.CHINA);    
            return sdf.format(value);  
        }    
        return value == null ? "" : value.toString();    
    } 
}
