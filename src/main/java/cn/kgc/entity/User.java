package cn.kgc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class User implements Serializable {
	private int userId;
	private String userName;
	private String userPassword;
	private Date userDate;
	private String email;
	private String phone;
public User(){}
	public User(int userId, String userName, String userPassword, Date userDate, String email, String phone) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.userPassword = userPassword;
	this.userDate = userDate;
	this.email = email;
	this.phone = phone;
}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", email="
				+ email + ", phone=" + phone + "]";
	}

}
