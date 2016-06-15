package com.swu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Integer bookid;  		//书籍ID
	private String bookname;		//书籍名称
	private String bclass;			//书籍类别
	private String bookauthor;		//书籍作者
	private String bookpress;		//书籍出版社
	private String bookintoduction;	//书籍简介
	private String bookimage;		//书籍图片路径
	
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	public String getBclass() {
		return bclass;
	}
	public void setBclass(String bclass) {
		this.bclass = bclass;
	}
	public String getBookauthor() {
		return bookauthor;
	}
	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}
	public String getBookpress() {
		return bookpress;
	}
	public void setBookpress(String bookpress) {
		this.bookpress = bookpress;
	}
	public String getBookintoduction() {
		return bookintoduction;
	}
	public void setBookintoduction(String bookintoduction) {
		this.bookintoduction = bookintoduction;
	}
	public String getBookimage() {
		return bookimage;
	}
	public void setBookimage(String bookimage) {
		this.bookimage = bookimage;
	}
	public Book() {
	}
	public Book(Integer bookid, String bookname, String bclass, String bookauthor, String bookpress,
			String bookintoduction, String bookimage) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bclass = bclass;
		this.bookauthor = bookauthor;
		this.bookpress = bookpress;
		this.bookintoduction = bookintoduction;
		this.bookimage = bookimage;
	}
}
