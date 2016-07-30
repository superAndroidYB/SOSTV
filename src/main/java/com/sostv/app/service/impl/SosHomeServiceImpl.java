package com.sostv.app.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.provider.Page;
import com.sostv.app.models.SosHome;
import com.sostv.app.service.ISosHomeService;

@Service(ISosHomeService.BEAN_ID)
public class SosHomeServiceImpl extends HibernateDao implements ISosHomeService{

	@Override
	public void loadSosHome(Page<SosHome> page, Map<String, Object> params) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosHome.class);
		pagingQuery(page, criteria);
	}

	@Override
	public SosHome loadSosHomeById(String id) {
		return (SosHome) getSession().get(SosHome.class, id);
	}

	@Override
	public void saveSosHome(List<SosHome> list) {
		for (SosHome sosHome : list) {
			getSession().saveOrUpdate(sosHome);
		}
	}
	
	@Override
	public void saveSosHome(SosHome home){
		if(home != null){
			getSession().saveOrUpdate(home);
		}
	}
	

	@Override
	public void deleteSosHome(String id) {
		SosHome home = loadSosHomeById(id);
		if(home != null){
			getSession().delete(home);
		}
	}

	@Override
	public List<SosHome> loadTodayNewHome(String data) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosHome.class);
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.add(5, -3);
		criteria.add(Restrictions.between("date", gc.getTime(), new Date()));
		criteria.addOrder(Order.desc("date"));
		return (List<SosHome>) query(criteria);
	}

	@Override
	public List<SosHome> loadMoreNewHome(String data) {
		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.CHINA);
		DetachedCriteria criteria = DetachedCriteria.forClass(SosHome.class);
		if(StringUtils.isNotBlank(data) && !"[]".equals(data)){
			Date lastDate = new Date();
			try {
				lastDate = sdf.parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(lastDate);
			gc.add(5, -3);
			
			GregorianCalendar gc2 = new GregorianCalendar();
			gc2.setTime(lastDate);
			gc2.add(5, -1);
			criteria.add(Restrictions.between("date", gc.getTime(), gc2.getTime()));
		}else{
			return null;
		}
		criteria.addOrder(Order.desc("date"));
		return (List<SosHome>) query(criteria);
	}

}
