package com.sostv.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_feedback:用户反馈信息表; InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_feedback")
public class SosFeedback implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;
	@PropertyDef(label = "用户名", description = "用户名")
	private String userName;
	@PropertyDef(label = "用户中文名", description = "用户中文名")
	private String userCname;
	@PropertyDef(label = "反馈内容", description = "反馈内容")
	private String content;
	@PropertyDef(label = "反馈时间", description = "反馈时间")
	private Date createTime;
	
	@Id
	@Column(name = "ID_", nullable = false)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "USER_NAME_", length = 50, nullable = false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "USER_CNAME_", length = 50, nullable = false)
	public String getUserCname() {
		return userCname;
	}
	public void setUserCname(String userCname) {
		this.userCname = userCname;
	}
	
	@Column(name = "CONTENT_", length = 2000, nullable = false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "CREATE_TIME_")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}
