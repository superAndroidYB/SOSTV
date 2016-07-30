package com.sostv.app.webservice;

import java.util.Collection;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sostv.app.webservice.model.SostvRequest;
import com.sostv.app.webservice.model.SostvResponse;

@Endpoint
public class SostvServiceEndpoint implements ApplicationContextAware{

	private Collection<WebServiceProcessor> processors;

	@PayloadRoot(localPart="SostvRequest", namespace="http://www.sostvapp.com/ws")
	@ResponsePayload
	public SostvResponse processRequest(@RequestPayload SostvRequest request){
		String ERROR = "ERROR";
		if(processors == null || processors.isEmpty()){
			return new SostvResponse(ERROR, "404", "服务器内部错误");
		}
		String serviceType = request.getServiceType();
		if(StringUtils.isBlank(serviceType)){
			return new SostvResponse(ERROR, "404", "请指定服务类型[serviceType]");
		}
		String result = "";
		boolean processed = false;
		String source = request.getSource();
		String data = request.getData();
		
		try {
			for(WebServiceProcessor processor : processors){
				if(processor.supports(serviceType)){
					result = processor.process(data);
					processed = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(processed){
			return new SostvResponse(source, "200", "succeed", result);
		}
		return new SostvResponse(source, "201", "failure", result);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		processors = applicationContext.getBeansOfType(WebServiceProcessor.class).values();
	}


}
