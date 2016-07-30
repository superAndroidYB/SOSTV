package com.sostv.app.webservice.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.sostv.app.models.SosHome;
import com.sostv.app.models.SosOrder;
import com.sostv.app.service.ISosHomeService;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;

@Service
public class SostvOrderServiceImpl extends HibernateDao implements WebServiceProcessor{

	private static final String DIANZAN = "DIANZAN";
	private static final String SHOUCANG = "SHOUCANG";
	private static final String UNDIANZAN = "UNDIANZAN";
    private static final String UNSHOUCANG = "UNSHOUCANG";
	
	@Resource(name = ISosHomeService.BEAN_ID)
	private ISosHomeService homeService;
	
	@Override
	public String process(String data) throws Exception {
		JSONObject object = JSONObject.fromObject(data);
		SosOrder order = (SosOrder) object.toBean(object,SosOrder.class);
		if(DIANZAN.equals(order.getOrderType())){
			SosHome home = homeService.loadSosHomeById(order.getOrderId());
			home.setLoveNum(home.getLoveNum() + 1);
			this.getSession().update(home);
		}else if(SHOUCANG.equals(order.getOrderType())){
			SosHome home = homeService.loadSosHomeById(order.getOrderId());
			home.setCollectNum(home.getCollectNum() + 1);
			this.getSession().update(home);
		}else if(UNDIANZAN.equals(order.getOrderType())){
			SosHome home = homeService.loadSosHomeById(order.getOrderId());
			home.setLoveNum(home.getLoveNum() - 1);
			this.getSession().update(home);
		}else if(UNSHOUCANG.equals(order.getOrderType())){
			SosHome home = homeService.loadSosHomeById(order.getOrderId());
			home.setCollectNum(home.getCollectNum() - 1);
			this.getSession().update(home);
		}
		return "SUCCEED";
	}

	@Override
	public boolean supports(String serviceType) {
		return WebServiceConstants.ORDER.equals(serviceType);
	}

}
