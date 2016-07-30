package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_chapters:书籍章节信息表; InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_chapters")
public class SosChapters implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private int id;

	/**
	 * BOOKS_ID_:
	 */
	@PropertyDef(label = "BOOKS_ID_", description = "BOOKS_ID_:")
	private String booksId;

	/**
	 * CHAPTERS_SEQ_:
	 */
	@PropertyDef(label = "CHAPTERS_SEQ_", description = "CHAPTERS_SEQ_:")
	private String chaptersSeq;

	/**
	 * CHAPTERS_NAME_:
	 */
	@PropertyDef(label = "CHAPTERS_NAME_", description = "CHAPTERS_NAME_:")
	private String chaptersName;

	/**
	 * CHAPTERS_HTML_:
	 */
	@PropertyDef(label = "CHAPTERS_HTML_", description = "CHAPTERS_HTML_:")
	private String chaptersHtml;

	public SosChapters() {
		super();
	}

	public SosChapters(int id, String booksId, String chaptersSeq,
			String chaptersName, String chaptersHtml) {
		super();
		this.id = id;
		this.booksId = booksId;
		this.chaptersSeq = chaptersSeq;
		this.chaptersName = chaptersName;
		this.chaptersHtml = chaptersHtml;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", nullable = false)
	public int getId() {
		return id;
	}

	public void setBooksId(String booksId) {
		this.booksId = booksId;
	}

	@Column(name = "BOOKS_ID_", length = 50, nullable = false)
	public String getBooksId() {
		return booksId;
	}

	public void setChaptersSeq(String chaptersSeq) {
		this.chaptersSeq = chaptersSeq;
	}

	@Column(name = "CHAPTERS_SEQ_", length = 50, nullable = false)
	public String getChaptersSeq() {
		return chaptersSeq;
	}

	public void setChaptersName(String chaptersName) {
		this.chaptersName = chaptersName;
	}

	@Column(name = "CHAPTERS_NAME_", length = 50, nullable = false)
	public String getChaptersName() {
		return chaptersName;
	}

	public void setChaptersHtml(String chaptersHtml) {
		this.chaptersHtml = chaptersHtml;
	}

	@Column(name = "CHAPTERS_HTML_", length = 500, nullable = false)
	public String getChaptersHtml() {
		return chaptersHtml;
	}

	public String toString() {
		return "SosChapters [id=" + id + ",booksId=" + booksId
				+ ",chaptersSeq=" + chaptersSeq + ",chaptersName="
				+ chaptersName + ",chaptersHtml=" + chaptersHtml + "]";
	}

}
