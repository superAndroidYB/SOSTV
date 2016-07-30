package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_content:InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_content")
public class SosContent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private String id;

	/**
	 * CONTENT_:
	 */
	@PropertyDef(label = "CONTENT_", description = "CONTENT_:")
	private String content;

	/**
	 * REF_ID_:
	 */
	@PropertyDef(label = "REF_ID_", description = "REF_ID_:")
	private String refId;

	public SosContent() {
		super();
	}

	public SosContent(String id, String content, String refId) {
		super();
		this.id = id;
		this.content = content;
		this.refId = refId;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@Column(name = "CONTENT_", columnDefinition = "CLOB", nullable = false)
	public String getContent() {
		return content;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	@Column(name = "REF_ID_", length = 50, nullable = false)
	public String getRefId() {
		return refId;
	}

	public String toString() {
		return "SosContent [id=" + id + ",content=" + content + ",refId="
				+ refId + "]";
	}

}
