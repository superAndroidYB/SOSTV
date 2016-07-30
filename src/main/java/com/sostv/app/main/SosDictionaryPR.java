package com.sostv.app.main;

import java.util.Collection;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.annotation.Expose;
import com.sostv.app.models.SosDictionary;
import com.sostv.app.service.ISosDictionaryService;

@Component(SosDictionaryPR.BEAN_ID) 
public class SosDictionaryPR {
	public static final String BEAN_ID = "sostv.SosDictionaryPR";

	@Resource(name = ISosDictionaryService.BEAN_ID)
	private ISosDictionaryService service;
	
	@DataProvider
	public Collection<SosDictionary> loadAllDictionary(String id) throws Exception {
		//sostv.SosDictionaryPR#loadAllDictionary
		Collection<SosDictionary> list = service.loadAllDictionary(id);
		return list;
	}
	
	@DataProvider
	public Collection<SosDictionary> loadChildDictionaryByCode(String code){
		//sostv.SosDictionaryPR#loadChildDictionaryByCode
		return service.loadChildDictionaryById(code);
	}
	
	@DataProvider
	public SosDictionary loadDictionaryById(String id){
		//sostv.SosDictionaryPR#loadDictionaryById
		return service.loadDictionaryById(id);
	}
	
	@DataResolver
	public void saveDictionary(SosDictionary dic){
		//sostv.SosDictionaryPR#saveDictionary
		service.saveDictionary(dic);
	}
	
	@DataProvider
	public SosDictionary loadNullDictionary(){
		//sostv.SosDictionaryPR#loadNullDictionary
		return new SosDictionary();
	}
	
	@Expose
	public void saveNewDictionary(SosDictionary dic, String parentCode){
		//sostv.SosDictionaryPR#saveNewDictionary
		dic.setId(UUID.randomUUID().toString());
		dic.setLevel(2);
		dic.setParentCode(parentCode);
		service.saveDictionary(dic);
	}
}
