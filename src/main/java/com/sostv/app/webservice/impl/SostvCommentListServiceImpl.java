package com.sostv.app.webservice.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sostv.app.models.SosComment;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

public class SostvCommentListServiceImpl extends HibernateDaoSupport implements WebServiceProcessor{

	@Override
	public String process(String data) throws Exception {
		Criteria criteria = getSession().createCriteria(SosComment.class);
		int count = Integer.parseInt(data);
		if(count > 0){
			criteria.setFetchSize(count);
		}
		List<SosComment> list = criteria.list();
		return JsonUtils.toJson(list);
	}

	@Override
	public boolean supports(String serviceType) {
		return WebServiceConstants.GETCOMMENT.equals(serviceType);
	}

}
