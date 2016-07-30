package com.sostv.app.webservice.impl;

import java.util.Date;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.sostv.app.models.SosComment;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;

@Service
public class SostvCommentServiceImpl extends HibernateDao implements WebServiceProcessor{

	@Override
	public String process(String data) throws Exception {
		JSONObject object = JSONObject.fromObject(data);
		SosComment comment = (SosComment) object.toBean(object,SosComment.class);
		comment.setCommentTime(new Date());
		getSession().save(comment);
		return "SUCCEED";
	}

	@Override
	public boolean supports(String serviceType) {
		return WebServiceConstants.SENDCOMMENT.equals(serviceType);
	}

}
