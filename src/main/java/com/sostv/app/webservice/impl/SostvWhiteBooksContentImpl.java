package com.sostv.app.webservice.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sostv.app.models.SosBooks;
import com.sostv.app.service.ISosBooksService;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

@Service
public class SostvWhiteBooksContentImpl implements WebServiceProcessor {

	@Resource(name = ISosBooksService.BEAN_ID)
	private ISosBooksService bookService;

	@Override
	public String process(String data) throws Exception {
		List<SosBooks> list = bookService.loadSosBooks("WHITE_BOOK",null);
		return JsonUtils.toJson(list);
	}

	@Override
	public boolean supports(String serviceType) {
		return serviceType.equals(WebServiceConstants.WHITE_BOOKS);
	}

}
