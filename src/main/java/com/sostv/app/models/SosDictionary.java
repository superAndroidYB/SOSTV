package com.sostv.app.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_dictionary:InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_dictionary")
public class SosDictionary implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;

	/**
	 * CODE_:
	 */
	@PropertyDef(label = "CODE_", description = "CODE_:")
	private String code;

	/**
	 * VALUE_:
	 */
	@PropertyDef(label = "VALUE_", description = "VALUE_:")
	private String value;

	/**
	 * PARENT_CODE_:
	 */
	@PropertyDef(label = "PARENT_CODE_", description = "PARENT_CODE_:")
	private String parentCode;

	/**
	 * ORDER_:
	 */
	@PropertyDef(label = "ORDER_", description = "ORDER_:")
	private int order;
	
	private int level;
	
	private boolean hasChild;
	
	private List<SosDictionary> dictionaries;
	private List<SosDictionary> childDictionaries;

	public SosDictionary() {
		super();
	}

	public SosDictionary(String id, String code, String value,
			String parentCode, int order) {
		super();
		this.id = id;
		this.code = code;
		this.value = value;
		this.parentCode = parentCode;
		this.order = order;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "CODE_", length = 50)
	public String getCode() {
		return code;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "VALUE_", length = 500)
	public String getValue() {
		return value;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Column(name = "PARENT_CODE_", length = 50)
	public String getParentCode() {
		return parentCode;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Column(name = "ORDER_")
	public int getOrder() {
		return order;
	}
	
	@Column(name = "LEVEL_")
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	@Transient
	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	@Transient
	public List<SosDictionary> getChildDictionaries() {
		return childDictionaries;
	}

	public void setChildDictionaries(List<SosDictionary> childDictionaries) {
		this.childDictionaries = childDictionaries;
	}
	
	@Transient
	public List<SosDictionary> getDictionaries() {
		return dictionaries;
	}

	public void setDictionaries(List<SosDictionary> dictionaries) {
		this.dictionaries = dictionaries;
	}

	public String toString() {
		return "SosDictionary [id=" + id + ",code=" + code + ",value=" + value
				+ ",parentCode=" + parentCode + ",order=" + order + "]";
	}

}
