package com.sostv.app.service;

import java.util.Collection;

import com.sostv.app.models.SosDictionary;

public interface ISosDictionaryService {
	public static final String BEAN_ID = "sostv.service.SosDictionaryService";
	
	public Collection<SosDictionary> loadAllDictionary(String id) throws Exception;
	
	public Collection<SosDictionary> loadChildDictionaryById(String code);
	
	public SosDictionary loadDictionaryById(String id);
	
	public void saveDictionary(SosDictionary dic);
}
