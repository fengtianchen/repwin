package com.swu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PublishMessage {
	
	@Id
	@GeneratedValue
	private Integer publishmessageid;
	private String begin;
	private String end;
	
	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="publishuserid",referencedColumnName="userid")
	private User puser;
	
	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="bookid")
	private Book pbook;

	public Integer getPublishmessageid() {
		return publishmessageid;
	}

	public void setPublishmessageid(Integer publishmessageid) {
		this.publishmessageid = publishmessageid;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public User getPuser() {
		return puser;
	}

	public void setPuser(User puser) {
		this.puser = puser;
	}

	public Book getPbook() {
		return pbook;
	}

	public void setPbook(Book pbook) {
		this.pbook = pbook;
	}

	public PublishMessage() {
	}

	public PublishMessage(Integer publishmessageid, String begin, String end, User puser, Book pbook) {
		super();
		this.publishmessageid = publishmessageid;
		this.begin = begin;
		this.end = end;
		this.puser = puser;
		this.pbook = pbook;
	}
}
