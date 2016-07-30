package com.sostv.app.main;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.sostv.app.models.SosVideo;
import com.sostv.app.service.ISosVideoService;

@Component(SosVideoPR.BEAN_ID)
public class SosVideoPR extends HibernateDao{
	public static final String BEAN_ID = "sostv.SosVideoPR";
	
	@Resource(name = ISosVideoService.BEAN_ID)
	private ISosVideoService videoService;
	
	@DataProvider
	public void loadSosVideo(Page<SosVideo> page, Map<String, Object> param){
		//sostv.SosVideoPR#loadSosVideo
		videoService.loadSosVideo(page, param);
	}
	
	@DataProvider
	public SosVideo loadSosVideoById(Integer id){
		//sostv.SosVideoPR#loadSosVideoById
		return videoService.loadSosVideoById(id);
	}
	
	@DataResolver
	public void saveSosVideo(List<SosVideo> videos){
		//sostv.SosVideoPR#saveSosVideo
		videoService.saveSosVideo(videos);
	}
	
	@Expose
	public void deleteSosVideo(Integer id){
		//sostv.SosVideoPR#deleteSosVideo
		videoService.deleteSosVideo(id);
	}
	
}
