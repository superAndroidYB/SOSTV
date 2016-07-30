package com.sostv.app.models;

import java.io.Serializable;
import javax.persistence.*;
import com.bstek.dorado.annotation.PropertyDef;

/**
 * sos_books:书籍资源表; InnoDB free: 11264 kB
 */
@Entity
@Table(name = "sos_books")
public class SosBooks implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID_:
	 */
	@PropertyDef(label = "ID_", description = "ID_:")
	private int id;

	/**
	 * BOOK_NAME_:
	 */
	@PropertyDef(label = "BOOK_NAME_", description = "BOOK_NAME_:")
	private String bookName;

	/**
	 * BOOK_IMAGE_:
	 */
	@PropertyDef(label = "BOOK_IMAGE_", description = "BOOK_IMAGE_:")
	private String bookImage;

	/**
	 * BOOK_LINK_:
	 */
	@PropertyDef(label = "BOOK_LINK_", description = "BOOK_LINK_:")
	private String bookLink;

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

	/**
	 * TYPE_LEVEL1_:
	 */
	@PropertyDef(label = "TYPE_LEVEL1_", description = "TYPE_LEVEL1_:")
	private String typeLevel1;

	/**
	 * TYPE_LEVEL2_:
	 */
	@PropertyDef(label = "TYPE_LEVEL2_", description = "TYPE_LEVEL2_:")
	private String typeLevel2;

	public SosBooks() {
		super();
	}

	public SosBooks(int id, String bookName, String bookImage, String bookLink,
			int loveNum, int lookNum, String typeLevel1, String typeLevel2) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookImage = bookImage;
		this.bookLink = bookLink;
		this.loveNum = loveNum;
		this.lookNum = lookNum;
		this.typeLevel1 = typeLevel1;
		this.typeLevel2 = typeLevel2;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID_", nullable = false)
	public int getId() {
		return id;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "BOOK_NAME_", length = 50, nullable = false)
	public String getBookName() {
		return bookName;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	@Column(name = "BOOK_IMAGE_", length = 500, nullable = false)
	public String getBookImage() {
		return bookImage;
	}

	public void setBookLink(String bookLink) {
		this.bookLink = bookLink;
	}

	@Column(name = "BOOK_LINK_", length = 500, nullable = false)
	public String getBookLink() {
		return bookLink;
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

	public void setTypeLevel1(String typeLevel1) {
		this.typeLevel1 = typeLevel1;
	}

	@Column(name = "TYPE_LEVEL1_", length = 10)
	public String getTypeLevel1() {
		return typeLevel1;
	}

	public void setTypeLevel2(String typeLevel2) {
		this.typeLevel2 = typeLevel2;
	}

	@Column(name = "TYPE_LEVEL2_", length = 10)
	public String getTypeLevel2() {
		return typeLevel2;
	}

	public String toString() {
		return "SosBooks [id=" + id + ",bookName=" + bookName + ",bookImage="
				+ bookImage + ",bookLink=" + bookLink + ",loveNum=" + loveNum
				+ ",lookNum=" + lookNum + ",typeLevel1=" + typeLevel1
				+ ",typeLevel2=" + typeLevel2 + "]";
	}

}
