package com.sostv.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_video:视频资源表; InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_video")
public class SosVideo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private int id;

	/**
	 * VIDEO_NAME_:
	 */
	@PropertyDef(label = "VIDEO_NAME_", description = "VIDEO_NAME_:")
	private String videoName;

	/**
	 * VEDIO_IMAGE_:
	 */
	@PropertyDef(label = "VEDIO_IMAGE_", description = "VEDIO_IMAGE_:")
	private String vedioImage;

	/**
	 * VIDEO_HD_URL_:
	 */
	@PropertyDef(label = "VIDEO_HD_URL_", description = "VIDEO_HD_URL_:")
	private String videoHdUrl;

	/**
	 * VIDEO_SD_URL_:
	 */
	@PropertyDef(label = "VIDEO_SD_URL_", description = "VIDEO_SD_URL_:")
	private String videoSdUrl;

	/**
	 * PUB_DATE_:
	 */
	@PropertyDef(label = "PUB_DATE_", description = "PUB_DATE_:")
	private Date pubDate;

	/**
	 * LOVE_NUM_:
	 */
	@PropertyDef(label = "LOVE_NUM_", description = "LOVE_NUM_:")
	private int loveNum;

	/**
	 * LOOK_NUM_:
	 */
	@PropertyDef(label = "LOOK_NUM_", description = "LOOK_NUM_:")
	private int lookNum;

	
	private String type;

	public SosVideo() {
		super();
	}

	public SosVideo(int id, String videoName, String vedioImage,
			String videoHdUrl, String videoSdUrl, Date pubDate, int loveNum,
			int lookNum, String typeLevel1, String typeLevel2) {
		super();
		this.id = id;
		this.videoName = videoName;
		this.vedioImage = vedioImage;
		this.videoHdUrl = videoHdUrl;
		this.videoSdUrl = videoSdUrl;
		this.pubDate = pubDate;
		this.loveNum = loveNum;
		this.lookNum = lookNum;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", nullable = false)
	public int getId() {
		return id;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	@Column(name = "VIDEO_NAME_", length = 50, nullable = false)
	public String getVideoName() {
		return videoName;
	}

	public void setVedioImage(String vedioImage) {
		this.vedioImage = vedioImage;
	}

	@Column(name = "VEDIO_IMAGE_", length = 500)
	public String getVedioImage() {
		return vedioImage;
	}

	public void setVideoHdUrl(String videoHdUrl) {
		this.videoHdUrl = videoHdUrl;
	}

	@Column(name = "VIDEO_HD_URL_", length = 500, nullable = false)
	public String getVideoHdUrl() {
		return videoHdUrl;
	}

	public void setVideoSdUrl(String videoSdUrl) {
		this.videoSdUrl = videoSdUrl;
	}

	@Column(name = "VIDEO_SD_URL_", length = 500)
	public String getVideoSdUrl() {
		return videoSdUrl;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@Column(name = "PUB_DATE_", nullable = false)
	public Date getPubDate() {
		return pubDate;
	}

	public void setLoveNum(int loveNum) {
		this.loveNum = loveNum;
	}

	@Column(name = "LOVE_NUM_")
	public int getLoveNum() {
		return loveNum;
	}

	public void setLookNum(int lookNum) {
		this.lookNum = lookNum;
	}

	@Column(name = "LOOK_NUM_")
	public int getLookNum() {
		return lookNum;
	}

	@Column(name = "TYPE_")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return "SosVideo [id=" + id + ",videoName=" + videoName
				+ ",vedioImage=" + vedioImage + ",videoHdUrl=" + videoHdUrl
				+ ",videoSdUrl=" + videoSdUrl + ",pubDate=" + pubDate
				+ ",loveNum=" + loveNum + ",lookNum=" + lookNum
				+ ",type=" + type + "]";
	}

}
