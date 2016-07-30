package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_interact:用户互动表; InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_interact")
public class SosInteract implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private int id;

	/**
	 * RESOURCE_ID_:
	 */
	@PropertyDef(label = "RESOURCE_ID_", description = "RESOURCE_ID_:")
	private String resourceId;

	/**
	 * INTERACT_USER_:
	 */
	@PropertyDef(label = "INTERACT_USER_", description = "INTERACT_USER_:")
	private String interactUser;

	/**
	 * INTERACT_TIME_:
	 */
	@PropertyDef(label = "INTERACT_TIME_", description = "INTERACT_TIME_:")
	private Date interactTime;

	/**
	 * INTERACT_THANK_:
	 */
	@PropertyDef(label = "INTERACT_THANK_", description = "INTERACT_THANK_:")
	private String interactThank;

	/**
	 * INTERACT_ZHUAN_:
	 */
	@PropertyDef(label = "INTERACT_ZHUAN_", description = "INTERACT_ZHUAN_:")
	private String interactZhuan;

	/**
	 * INTERACT_AMEN_:
	 */
	@PropertyDef(label = "INTERACT_AMEN_", description = "INTERACT_AMEN_:")
	private String interactAmen;

	public SosInteract() {
		super();
	}

	public SosInteract(int id, String resourceId, String interactUser,
			Date interactTime, String interactThank, String interactZhuan,
			String interactAmen) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.interactUser = interactUser;
		this.interactTime = interactTime;
		this.interactThank = interactThank;
		this.interactZhuan = interactZhuan;
		this.interactAmen = interactAmen;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", nullable = false)
	public int getId() {
		return id;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name = "RESOURCE_ID_", length = 50, nullable = false)
	public String getResourceId() {
		return resourceId;
	}

	public void setInteractUser(String interactUser) {
		this.interactUser = interactUser;
	}

	@Column(name = "INTERACT_USER_", length = 50, nullable = false)
	public String getInteractUser() {
		return interactUser;
	}

	public void setInteractTime(Date interactTime) {
		this.interactTime = interactTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INTERACT_TIME_", nullable = false)
	public Date getInteractTime() {
		return interactTime;
	}

	public void setInteractThank(String interactThank) {
		this.interactThank = interactThank;
	}

	@Column(name = "INTERACT_THANK_", length = 50, nullable = false)
	public String getInteractThank() {
		return interactThank;
	}

	public void setInteractZhuan(String interactZhuan) {
		this.interactZhuan = interactZhuan;
	}

	@Column(name = "INTERACT_ZHUAN_", length = 50, nullable = false)
	public String getInteractZhuan() {
		return interactZhuan;
	}

	public void setInteractAmen(String interactAmen) {
		this.interactAmen = interactAmen;
	}

	@Column(name = "INTERACT_AMEN_", length = 50, nullable = false)
	public String getInteractAmen() {
		return interactAmen;
	}

	public String toString() {
		return "SosInteract [id=" + id + ",resourceId=" + resourceId
				+ ",interactUser=" + interactUser + ",interactTime="
				+ interactTime + ",interactThank=" + interactThank
				+ ",interactZhuan=" + interactZhuan + ",interactAmen="
				+ interactAmen + "]";
	}

}
