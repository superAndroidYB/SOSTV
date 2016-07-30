package com.sostv.app.main;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.sostv.app.models.SosBooks;
import com.sostv.app.service.ISosBooksService;

@Component(SosBookPR.BEAN_ID)
public class SosBookPR {
	public static final String BEAN_ID = "sostv.SosBookPR";
	
	@Resource(name = ISosBooksService.BEAN_ID)
	private ISosBooksService service;
	
	@DataProvider
	public void loadSosBooks(Page<SosBooks> page, Map<String, String> params){
		//sostv.SosBookPR#loadSosBooks
		service.loadSosBooks(page, params);
	}
	
	@FileResolver
	public SosBooks uploadFile(UploadFile file,Map<String, Object> params){
		//sostv.SosBookPR#uploadFile
		return service.uploadFile(file, params);
	}
}
