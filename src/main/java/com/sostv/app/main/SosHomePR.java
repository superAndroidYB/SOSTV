package com.sostv.app.main;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.sostv.app.common.Constants;
import com.sostv.app.models.SosContent;
import com.sostv.app.models.SosHome;
import com.sostv.app.service.ISosContentService;
import com.sostv.app.service.ISosHomeService;

@Component(SosHomePR.BEAN_ID)
public class SosHomePR {
	public static final String BEAN_ID = "sostv.SosHomePR";
	
	@Resource(name = ISosHomeService.BEAN_ID)
	private ISosHomeService homeService;
	
	@Resource(name = ISosContentService.BEAN_ID)
	private ISosContentService contentService;
	
	@DataProvider
	public SosHome loadSosHome(String id){
		//sostv.SosHomePR#loadSosHome
		SosHome home = new SosHome();
		if(StringUtils.isNotBlank(id)){
			home = homeService.loadSosHomeById(id);
		}
		return home;
	}
	
	@DataResolver
	public void saveHome(SosHome home){
		//sostv.SosHomePR#saveHome
		if(home != null){
			if(StringUtils.isBlank(home.getId())){
				home.setId(UUID.randomUUID().toString());
			}
			if(StringUtils.isBlank(home.getOwnType())){
				home.setOwnType(Constants.CONTENT);
			}
			if(home.getDate() == null){
				home.setDate(new Date());
			}
			homeService.saveSosHome(home);
		}
	}
	
	@Expose
	public void saveSosContent(String id,String text){
		//sostv.SosHomePR#saveSosContent
		SosContent content = new SosContent();
		content.setId(UUID.randomUUID().toString());
		content.setRefId(id);
		content.setContent(text);
		contentService.saveSosContent(content);
	}

}
