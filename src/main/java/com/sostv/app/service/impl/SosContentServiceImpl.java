package com.sostv.app.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.sostv.app.models.SosContent;
import com.sostv.app.service.ISosContentService;

@Service(ISosContentService.BEAN_ID)
public class SosContentServiceImpl extends HibernateDao implements ISosContentService{

	@Override
	public void saveSosContent(SosContent content) {
		if(content != null){
			getSession().saveOrUpdate(content);
		}
	}

	@Override
	public SosContent loadContentById(String id) {
		return (SosContent) getSession().get(SosContent.class, id);
	}

	@Override
	public SosContent loadContentByRefId(String RefId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosContent.class);
		criteria.add(Restrictions.eq("refId", RefId));
		List<SosContent> list = (List<SosContent>) query(criteria);
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<SosContent> loadListContentByRefId(String RefId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosContent.class);
		criteria.add(Restrictions.eq("refId", RefId));
		List<SosContent> list = (List<SosContent>) query(criteria);
		return list;
	}

}
