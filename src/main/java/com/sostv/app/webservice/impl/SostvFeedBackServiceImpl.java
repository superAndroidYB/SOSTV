package com.sostv.app.webservice.impl;

import java.util.Date;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.sostv.app.models.SosFeedback;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;

@Service
public class SostvFeedBackServiceImpl extends HibernateDao implements WebServiceProcessor{

	@Override
	public String process(String data) throws Exception {
		JSONObject object = JSONObject.fromObject(data);
		SosFeedback feedBack = (SosFeedback)object.toBean(object,SosFeedback.class);
		feedBack.setId(UUID.randomUUID().toString());
		feedBack.setCreateTime(new Date());
		getSession().save(feedBack);
		return "SUCCEED";
	}

	@Override
	public boolean supports(String serviceType) {
		return WebServiceConstants.FEEDBACK.equals(serviceType);
	}

}
