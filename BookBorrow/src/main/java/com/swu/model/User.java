package com.swu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer userid;    		//用户ID
	private String username;		//用户名
	private String userpass;		//用户密码
	private String userphone;		//用户电话
	
	public User() {
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public User(Integer userid, String username, String userpass, String userphone) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpass = userpass;
		this.userphone = userphone;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userpass=" + userpass + ", userphone="
				+ userphone + "]";
	}
	
}
