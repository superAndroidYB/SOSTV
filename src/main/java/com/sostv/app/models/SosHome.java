package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_home:InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_home")
public class SosHome implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id_:
	 */
	@PropertyDef(label = "id_", description = "id_:")
	private String id;

	/**
	 * title_:
	 */
	@PropertyDef(label = "title_", description = "title_:")
	private String title;

	/**
	 * own_type_:
	 */
	@PropertyDef(label = "own_type_", description = "own_type_:")
	private String ownType;

	/**
	 * content_:
	 */
	@PropertyDef(label = "content_", description = "content_:")
	private String content;

	@PropertyDef(label = "link_", description = "link_:")
	private String link;
	
	/**
	 * imageUrl:
	 */
	@PropertyDef(label = "imageUrl", description = "imageUrl:")
	private String imageUrl;

	/**
	 * lookNum:
	 */
	@PropertyDef(label = "lookNum", description = "lookNum:")
	private long lookNum;
	
	private long loveNum;
	
	private long collectNum;

	/**
	 * date:
	 */
	@PropertyDef(label = "date", description = "date:")
	private Date date;

	public SosHome() {
		super();
	}

	public SosHome(String id, String title, String ownType, String content,
			String imageUrl, long lookNum, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.ownType = ownType;
		this.content = content;
		this.imageUrl = imageUrl;
		this.lookNum = lookNum;
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "id_", length = 50, nullable = false)
	public String getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "title_", length = 500)
	public String getTitle() {
		return title;
	}

	public void setOwnType(String ownType) {
		this.ownType = ownType;
	}

	@Column(name = "own_type_", length = 10)
	public String getOwnType() {
		return ownType;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "content_", length = 500)
	public String getContent() {
		return content;
	}

	@Column(name = "link_", length = 500)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "image_url_", length = 200)
	public String getImageUrl() {
		return imageUrl;
	}

	public void setLookNum(long lookNum) {
		this.lookNum = lookNum;
	}

	@Column(name = "look_num_")
	public long getLookNum() {
		return lookNum;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "date_")
	public Date getDate() {
		return date;
	}
	
	@Column(name = "LOVE_NUM_")
	public long getLoveNum() {
		return loveNum;
	}

	public void setLoveNum(long loveNum) {
		this.loveNum = loveNum;
	}

	@Column(name = "COLLECT_NUM_")
	public long getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(long collectNum) {
		this.collectNum = collectNum;
	}

	public String toString() {
		return "SosHome [id=" + id + ",title=" + title + ",ownType=" + ownType
				+ ",content=" + content + ",imageurl=" + imageUrl + ",looknum="
				+ lookNum + ",date=" + date + "]";
	}

}
