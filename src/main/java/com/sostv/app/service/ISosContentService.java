package com.sostv.app.service;

import java.util.List;

import com.sostv.app.models.SosContent;

public interface ISosContentService {
	public static final String BEAN_ID = "sostv.service.SosContentService";
	
	public void saveSosContent(SosContent content);
	
	public SosContent loadContentById(String id);
	
	public SosContent loadContentByRefId(String RefId);
	
	public List<SosContent> loadListContentByRefId(String RefId);
}
