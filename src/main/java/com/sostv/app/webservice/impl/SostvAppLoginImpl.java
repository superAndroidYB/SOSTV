package com.sostv.app.webservice.impl;

import java.security.MessageDigest;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.bstek.bdf2.core.orm.hibernate.HibernateDao;
import com.sostv.app.models.SosUser;
import com.sostv.app.webservice.WebServiceConstants;
import com.sostv.app.webservice.WebServiceProcessor;
import com.sostv.app.webservice.utils.JsonUtils;

@Service
public class SostvAppLoginImpl extends HibernateDao implements WebServiceProcessor{

	private static final String LOGIN = "LOGIN";
	private static final String REGISTER = "REGISTER";
	
	@Override
	public String process(String data) throws Exception {
		JSONObject obj = JSONObject.fromObject(data);
		SosUser user = (SosUser) obj.toBean(obj,SosUser.class);
		if(LOGIN.equals(user.getLoginOrReg())){
			user = encryptionMD5(user);
			DetachedCriteria criteria = DetachedCriteria.forClass(SosUser.class);
			if(StringUtils.isNotBlank(user.getUserName())){
				criteria.add(Restrictions.or(Restrictions.eq("userName", user.getUserName().trim()), Restrictions.eq("email", user.getUserName().trim())));
			}else{
				return "LOGIN_FAILURE";
			}
			criteria.add(Restrictions.eq("userPassword", user.getUserPassword()));
			List<SosUser> userList = (List<SosUser>) query(criteria);
			if(userList.isEmpty()){
				return "LOGIN_FAILURE";
			}
			if(userList.size() > 1){
				return "LOGIN_FAILURE";
			}
			return JsonUtils.toJsonObject(userList.get(0));
		}else{
			DetachedCriteria criteria = DetachedCriteria.forClass(SosUser.class);
			if(StringUtils.isNotBlank(user.getUserName())){
				criteria.add(Restrictions.eq("userName", user.getUserName().trim()));
			}else if(StringUtils.isNotBlank(user.getEmail())){
				criteria.add(Restrictions.eq("email", user.getEmail().trim()));
			}else{
				return "REGISTER_FAILURE_NON";
			}
			List<SosUser> userList = (List<SosUser>) query(criteria);
			if(!userList.isEmpty()){
				return "REGISTER_FAILURE_REPEAT";
			}
			getSession().save(encryptionMD5(user));
			return "REGISTER_SUCCEED";
		}
	}
	
	private SosUser encryptionMD5(SosUser user) throws Exception{
		MessageDigest md5 = null;
		md5 = MessageDigest.getInstance("MD5");
		
		String passWord = user.getUserPassword() + user.getSalt();
		char[] charArray = passWord.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)  
				buffer.append("0");  
			buffer.append(Integer.toHexString(val));
		}
		user.setUserPassword(buffer.toString());
		return user;
	}
	

	@Override
	public boolean supports(String serviceType) {
		return WebServiceConstants.LOGINREG.equals(serviceType);
	}

}
