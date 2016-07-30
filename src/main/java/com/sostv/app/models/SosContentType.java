package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_content_type:InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_content_type")
public class SosContentType implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;

	/**
	 * TYPE_CODE_:
	 */
	@PropertyDef(label = "TYPE_CODE_", description = "TYPE_CODE_:")
	private String typeCode;

	/**
	 * TYPE_NAME_:
	 */
	@PropertyDef(label = "TYPE_NAME_", description = "TYPE_NAME_:")
	private String typeName;

	/**
	 * TYPE_DESC_:
	 */
	@PropertyDef(label = "TYPE_DESC_", description = "TYPE_DESC_:")
	private String typeDesc;

	/**
	 * TYPE_LEVEL_:
	 */
	@PropertyDef(label = "TYPE_LEVEL_", description = "TYPE_LEVEL_:")
	private String typeLevel;

	/**
	 * PARENT_CODE_:
	 */
	@PropertyDef(label = "PARENT_CODE_", description = "PARENT_CODE_:")
	private String parentCode;

	public SosContentType() {
		super();
	}

	public SosContentType(String id, String typeCode, String typeName,
			String typeDesc, String typeLevel, String parentCode) {
		super();
		this.id = id;
		this.typeCode = typeCode;
		this.typeName = typeName;
		this.typeDesc = typeDesc;
		this.typeLevel = typeLevel;
		this.parentCode = parentCode;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "TYPE_CODE_", length = 10)
	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "TYPE_NAME_", length = 50)
	public String getTypeName() {
		return typeName;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@Column(name = "TYPE_DESC_", length = 50)
	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeLevel(String typeLevel) {
		this.typeLevel = typeLevel;
	}

	@Column(name = "TYPE_LEVEL_", length = 1)
	public String getTypeLevel() {
		return typeLevel;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Column(name = "PARENT_CODE_", length = 10)
	public String getParentCode() {
		return parentCode;
	}

	public String toString() {
		return "SosContentType [id=" + id + ",typeCode=" + typeCode
				+ ",typeName=" + typeName + ",typeDesc=" + typeDesc
				+ ",typeLevel=" + typeLevel + ",parentCode=" + parentCode + "]";
	}

}
