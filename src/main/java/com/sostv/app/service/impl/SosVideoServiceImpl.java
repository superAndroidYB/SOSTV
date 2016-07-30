package com.sostv.app.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.provider.Page;
import com.sostv.app.models.SosVideo;
import com.sostv.app.service.ISosVideoService;

@Service(ISosVideoService.BEAN_ID)
public class SosVideoServiceImpl extends HibernateDao implements ISosVideoService{

	public void loadSosVideo(Page<SosVideo> page, Map<String, Object> param) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosVideo.class);
		pagingQuery(page, criteria);
	}
	
	public List<SosVideo> loadSosVideo(){
		DetachedCriteria criteria = DetachedCriteria.forClass(SosVideo.class);
		return (List<SosVideo>) query(criteria);
	}
	
	public SosVideo loadSosVideoById(Integer id) {
		return (SosVideo) getSession().get(SosVideo.class, id);
	}

	public void saveSosVideo(List<SosVideo> videos) {
		for (SosVideo sosVideo : videos) {
			getSession().saveOrUpdate(sosVideo);
		}
		
	}

	public void deleteSosVideo(Integer id) {
		SosVideo sosVideo = loadSosVideoById(id);
		if(sosVideo != null){
			getSession().delete(sosVideo);
		}
		
	}

	

}
