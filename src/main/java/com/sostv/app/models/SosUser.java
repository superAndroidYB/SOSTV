package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_user:用户信息表; InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_user")
public class SosUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private int id;

	/**
	 * USER_NAME_:
	 */
	@PropertyDef(label = "USER_NAME_", description = "USER_NAME_:")
	private String userName;

	/**
	 * USER_CNAME_:
	 */
	@PropertyDef(label = "USER_CNAME_", description = "USER_CNAME_:")
	private String userCname;

	/**
	 * USER_PASSWORD_:
	 */
	@PropertyDef(label = "USER_PASSWORD_", description = "USER_PASSWORD_:")
	private String userPassword;
	
	private String imageUrl;
	
	private String salt;
	
	private String loginOrReg;
	
	private String email;
	
	/**
	 * LEVEL_:
	 */
	@PropertyDef(label = "LEVEL_", description = "LEVEL_:")
	private String level;

	public SosUser() {
		super();
	}

	public SosUser(int id, String userName, String userCname,
			String userPassword, String level) {
		super();
		this.id = id;
		this.userName = userName;
		this.userCname = userCname;
		this.userPassword = userPassword;
		this.level = level;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", nullable = false)
	public int getId() {
		return id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "USER_NAME_", length = 50, nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserCname(String userCname) {
		this.userCname = userCname;
	}

	@Column(name = "USER_CNAME_", length = 50, nullable = false)
	public String getUserCname() {
		return userCname;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "USER_PASSWORD_", length = 50, nullable = false)
	public String getUserPassword() {
		return userPassword;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "LEVEL_", length = 500, nullable = false)
	public String getLevel() {
		return level;
	}
	
	@Column(name = "IMAGE_URL_")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Column(name = "SALT_")
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Transient
	public String getLoginOrReg() {
		return loginOrReg;
	}

	public void setLoginOrReg(String loginOrReg) {
		this.loginOrReg = loginOrReg;
	}

	@Column(name = "EMAIL_")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "SosUser [id=" + id + ",userName=" + userName + ",userCname="
				+ userCname + ",userPassword=" + userPassword + ",level="
				+ level + "]";
	}

}
