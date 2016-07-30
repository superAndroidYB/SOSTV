package com.sostv.app.webservice.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.sostv.app.models.SosContent;
import com.sostv.app.service.ISosContentService;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

@Service
public class SostvTextContentImpl implements WebServiceProcessor{

	@Resource(name = ISosContentService.BEAN_ID)
	private ISosContentService contentService;
	
	@Override
	public String process(String data) throws Exception {
		if(StringUtils.isNotBlank(data) && !"[]".equals(data)){
			SosContent content = contentService.loadContentByRefId(data);
			return JsonUtils.toJson(content);
		}
		return null;
	}

	@Override
	public boolean supports(String serviceType) {
		return serviceType.equals(WebServiceConstants.SOS_CONTENT);
	}

}
