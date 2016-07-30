package com.sostv.app.service;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.sostv.app.models.SosHome;

public interface ISosHomeService {
	public static final String BEAN_ID = "sostv.service.SosHomeService";
	
	public void loadSosHome(Page<SosHome> page,Map<String, Object> params);
	
	public SosHome loadSosHomeById(String id);
	
	public void saveSosHome(List<SosHome> list);
	
	public void saveSosHome(SosHome home);
	
	public void deleteSosHome(String id);
	
	/**
	 * 获取当天的新数据
	 * @param data
	 */
	public List<SosHome> loadTodayNewHome(String data);
	
	public List<SosHome> loadMoreNewHome(String data);
	
}
