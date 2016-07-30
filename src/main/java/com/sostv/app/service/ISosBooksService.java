package com.sostv.app.service;

import java.util.List;
import java.util.Map;

import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.uploader.UploadFile;
import com.sostv.app.models.SosBooks;

public interface ISosBooksService {
	public static final String BEAN_ID = "sostv.service.SosBooksService";
	
	public void loadSosBooks(Page<SosBooks> page, Map<String, String> params);
	
	public List<SosBooks> loadSosBooks(String typeLevel1,String typeLevel2);
	
	public SosBooks loadSosBookById(Integer id);
	
	public void saveSosBooks(List<SosBooks> list);
	
	public void deleteSosBook(Integer id);
	
	public SosBooks uploadFile(UploadFile file,Map<String, Object> params);
}
