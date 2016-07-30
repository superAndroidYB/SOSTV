package com.sostv.app.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.entity.EntityUtils;
import com.sostv.app.models.SosDictionary;
import com.sostv.app.service.ISosDictionaryService;

@Service(ISosDictionaryService.BEAN_ID)
public class SosDictionarySeviceImpl extends HibernateDao implements ISosDictionaryService{

	@Override
	public Collection<SosDictionary> loadAllDictionary(String id) throws Exception{
		List<SosDictionary> list = new ArrayList<SosDictionary>();
		List<Object[]> result = new ArrayList<Object[]>();
		if(StringUtils.isEmpty(id)){
			result = query("select a, " +
					"(select count(*) from SosDictionary b where a.code = b.parentCode) as childCount " +
					"from SosDictionary a where level = '1'");
		}else{
			result = query("select a, " +
					"(select count(*) from SosDictionary b where a.code = b.parentCode) as childCount " +
					"from SosDictionary a where level = '2' and a.parentCode = '"+id+"'");
		}
		for (Object[] objects : result) {
			SosDictionary dictionary = EntityUtils.toEntity(objects[0]);
			int childCount = (int) ((Long) objects[1] + 0);
			EntityUtils.setValue(dictionary, "childCount", childCount);
			EntityUtils.setValue(dictionary, "hasChild", childCount > 0);
			list.add(dictionary);
		}
		return list;
	}
	
	@Override
	public Collection<SosDictionary> loadChildDictionaryById(String code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosDictionary.class);
		criteria.add(Restrictions.eq("parentCode", code));
		criteria.add(Restrictions.eq("level", 2));
		return (Collection<SosDictionary>) query(criteria);
	}

	@Override
	public SosDictionary loadDictionaryById(String id) {
		return (SosDictionary) getSession().get(SosDictionary.class, id);
	}

	@Override
	public void saveDictionary(SosDictionary dic) {
		getSession().saveOrUpdate(dic);
	}

	

}
