package com.sostv.app.webservice.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.sostv.app.models.SosVideo;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

@Service
public class SostvVideoListContentImpl extends HibernateDao implements WebServiceProcessor{
	
	@Override
	public String process(String data) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosVideo.class);
		criteria.add(Restrictions.eq("type", data));
		List<SosVideo> videos = (List<SosVideo>) query(criteria);
		return JsonUtils.toJson(videos);
	}

	@Override
	public boolean supports(String serviceType) {
		return serviceType.equals(WebServiceConstants.VIDEO_LIST);
	}

}
