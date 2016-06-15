package com.swu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BorrowMessage {
	@Id
	@GeneratedValue
	private Integer borrowmessageid;
	private String begin;
	private String end;
	
	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="publishmessageid")
	private PublishMessage publishMessage;
	
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="borrowuserid", referencedColumnName="userid")
	private User buser;

	public BorrowMessage() {
	}

	public BorrowMessage(Integer borrowmessageid, String begin, String end, PublishMessage publishMessage, User buser) {
		super();
		this.borrowmessageid = borrowmessageid;
		this.begin = begin;
		this.end = end;
		this.publishMessage = publishMessage;
		this.buser = buser;
	}
	
	public Integer getBorrowmessageid() {
		return borrowmessageid;
	}

	public void setBorrowmessageid(Integer borrowmessageid) {
		this.borrowmessageid = borrowmessageid;
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

	public PublishMessage getPublishMessage() {
		return publishMessage;
	}

	public void setPublishMessage(PublishMessage publishMessage) {
		this.publishMessage = publishMessage;
	}

	public User getBuser() {
		return buser;
	}

	public void setBuser(User buser) {
		this.buser = buser;
	}
}
