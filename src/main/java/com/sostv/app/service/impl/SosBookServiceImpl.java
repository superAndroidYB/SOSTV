package com.sostv.app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.uploader.UploadFile;
import com.sostv.app.models.SosBooks;
import com.sostv.app.service.ISosBooksService;

@Service(ISosBooksService.BEAN_ID)
public class SosBookServiceImpl extends HibernateDao implements ISosBooksService{

	private final String di = "第";
	private final String zhang = "章";
	private final String pian = "篇";
	
	@Override
	public void loadSosBooks(Page<SosBooks> page, Map<String, String> params) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosBooks.class);
		pagingQuery(page, criteria);
	}

	@Override
	public List<SosBooks> loadSosBooks(String typeLevel1,String typeLevel2) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SosBooks.class);
		if(StringUtils.isNotBlank(typeLevel1)){
			criteria.add(Restrictions.eq("typeLevel1", typeLevel1));
		}
		if(StringUtils.isNotBlank(typeLevel2)){
			criteria.add(Restrictions.eq("typeLevel2", typeLevel2));
		}
		return (List<SosBooks>) query(criteria);
	}

	@Override
	public SosBooks loadSosBookById(Integer id) {
		return (SosBooks) getSession().get(SosBooks.class, id);
	}

	@Override
	public void saveSosBooks(List<SosBooks> list) {
		for (SosBooks book : list) {
			getSession().save(book);
		}
	}

	@Override
	public void deleteSosBook(Integer id) {
		SosBooks book = loadSosBookById(id);
		getSession().delete(book);
	}

	@Override
	public SosBooks uploadFile(UploadFile file, Map<String, Object> params) {
		SosBooks book = new SosBooks();
		book.setBookName(file.getFileName());
		book.setLoveNum(0);
		book.setLookNum(0);
		try {
			WordExtractor extractor = new WordExtractor(file.getInputStream());
			StringBuffer sb = new StringBuffer(extractor.getText());
			getDirectory(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//getSession().save(book);
		return book;
	}
	
	private void getDirectory(StringBuffer sb){
		List<String> list = new ArrayList<String>();
		String[] str = new String[]{"零","一","二","三","四","五","六","七","八","九"};

		int flag_zhang = sb.indexOf(di+str[1]+ zhang);
		int flag_pian = sb.indexOf(di+str[1]+ pian);
		if(flag_zhang != -1 || flag_pian != -1){
			if(flag_zhang < flag_pian){
				//本书以"章"为单位
				System.out.println("本书以章为单位");
			}else{
				//本书以"篇"为单位
				System.out.println("本书以篇为单位");
			}
		}
	
		for (int i = 0; i < str.length; i++) {
			
		}
	}

}
