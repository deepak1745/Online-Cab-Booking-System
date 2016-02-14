package com.wipro.ata.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ata_tbl_login")
public class LoginBean
{
	private String user_type;
	@Id
	 private String login_id;
	 private String password;
	 private int login_status;
	 
 public int getLogin_status() {
		return login_status;
	}
	public void setLogin_status(int login_status) {
		this.login_status = login_status;
	}
public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	}

 

