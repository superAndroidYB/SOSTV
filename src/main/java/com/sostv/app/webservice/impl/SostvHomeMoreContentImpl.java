package com.sostv.app.webservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sostv.app.models.SosHome;
import com.sostv.app.service.ISosHomeService;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

@Service
public class SostvHomeMoreContentImpl implements WebServiceProcessor{

	@Resource(name = ISosHomeService.BEAN_ID)
	private ISosHomeService homeService;
	
	@Override
	public String process(String data) throws Exception {
		List<SosHome> homes = homeService.loadMoreNewHome(data);
		return JsonUtils.toJson(homes);
	}

	@Override
	public boolean supports(String serviceType) {
		return serviceType.equals(WebServiceConstants.HOME_MORE);
	}

}
