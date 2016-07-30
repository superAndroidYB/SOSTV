package com.sostv.app.webservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sostv.app.models.SosVideo;
import com.sostv.app.service.ISosVideoService;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

/**
 * 获取视频的最新推荐 
 * @author Administrator
 *
 */
@Service
public class SostvVideoNewsContentImpl implements WebServiceProcessor{

	@Resource(name = ISosVideoService.BEAN_ID)
	private ISosVideoService sosVideoService;
	
	@Override
	public String process(String data) throws Exception {
		List<SosVideo> videos = sosVideoService.loadSosVideo();
		return JsonUtils.toJson(videos);
	}

	@Override
	public boolean supports(String serviceType) {
		return serviceType.equals(WebServiceConstants.VIDEO_NEWS);
	}

}
