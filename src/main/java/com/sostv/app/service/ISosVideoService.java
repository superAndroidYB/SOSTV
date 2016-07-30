package com.sostv.app.service;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.sostv.app.models.SosVideo;

public interface ISosVideoService {
	public static String BEAN_ID = "sostv.service.SosVideoService";
	
	public void loadSosVideo(Page<SosVideo> page, Map<String, Object> param);
	
	public List<SosVideo> loadSosVideo();
	
	public SosVideo loadSosVideoById(Integer id);
	
	public void saveSosVideo(List<SosVideo> videos);
	
	public void deleteSosVideo(Integer id);
}
