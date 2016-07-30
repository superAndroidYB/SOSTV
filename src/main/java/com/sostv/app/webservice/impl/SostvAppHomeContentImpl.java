package com.sostv.app.webservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sostv.app.models.SosHome;
import com.sostv.app.service.ISosHomeService;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

/**
 * 获取首页内容
 * @author Administrator
 *
 */
@Service
public class SostvAppHomeContentImpl implements WebServiceProcessor{

	@Resource(name = ISosHomeService.BEAN_ID)
	private ISosHomeService homeService;
	
	@Override
	public String process(String data) throws Exception {
		List<SosHome> homes = homeService.loadTodayNewHome(data);
		return JsonUtils.toJson(homes);
	}

	@Override
	public boolean supports(String serviceType) {
		return serviceType.equals(WebServiceConstants.HOME);
	}

}
