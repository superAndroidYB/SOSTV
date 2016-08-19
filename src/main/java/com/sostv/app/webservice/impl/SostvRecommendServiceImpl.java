package com.sostv.app.webservice.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sostv.app.models.SosComment;
import com.sostv.app.models.SosVideo;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

public class SostvRecommendServiceImpl extends HibernateDaoSupport implements WebServiceProcessor{

	@Override
	public String process(String data) throws Exception {
		JSONObject object = JSONObject.fromObject(data);
		SosVideo video = (SosVideo) object.toBean(object,SosVideo.class);
		Criteria criteria = getSession().createCriteria(SosVideo.class);
		criteria.add(Restrictions.eq("type", video.getType()));
		criteria.addOrder(Order.desc("lookNum"));
		criteria.setFetchSize(5);
		List<SosVideo> list = criteria.list();
		return JsonUtils.toJson(list);
	}

	@Override
	public boolean supports(String serviceType) {
		// TODO Auto-generated method stub
		return false;
	}

}
