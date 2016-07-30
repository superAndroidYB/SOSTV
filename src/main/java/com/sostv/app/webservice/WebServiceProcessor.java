package com.sostv.app.webservice;

public interface WebServiceProcessor {

	String process(String data) throws Exception;
	
	boolean supports(String serviceType);
}
