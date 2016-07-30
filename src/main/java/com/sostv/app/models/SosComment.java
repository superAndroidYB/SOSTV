package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_comment:用户评论表; InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_comment")
public class SosComment implements Serializable {

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
	 * COMMENT_USER_:
	 */
	@PropertyDef(label = "COMMENT_USER_", description = "COMMENT_USER_:")
	private String commentUser;

	/**
	 * COMMENT_TIME_:
	 */
	@PropertyDef(label = "COMMENT_TIME_", description = "COMMENT_TIME_:")
	private Date commentTime;

	/**
	 * COMMENT_CONTENT_:
	 */
	@PropertyDef(label = "COMMENT_CONTENT_", description = "COMMENT_CONTENT_:")
	private String commentContent;

	public SosComment() {
		super();
	}

	public SosComment(int id, String resourceId, String commentUser,
			Date commentTime, String commentContent) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.commentUser = commentUser;
		this.commentTime = commentTime;
		this.commentContent = commentContent;
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

	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}

	@Column(name = "COMMENT_USER_", length = 50, nullable = false)
	public String getCommentUser() {
		return commentUser;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMENT_TIME_", nullable = false)
	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Column(name = "COMMENT_CONTENT_", length = 50, nullable = false)
	public String getCommentContent() {
		return commentContent;
	}

	public String toString() {
		return "SosComment [id=" + id + ",resourceId=" + resourceId
				+ ",commentUser=" + commentUser + ",commentTime=" + commentTime
				+ ",commentContent=" + commentContent + "]";
	}

}
