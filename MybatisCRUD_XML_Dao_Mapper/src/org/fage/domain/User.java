package org.fage.domain;

import java.util.Date;
/**
 * 
 * @author Caizhf
 * @date 2017年5月6日下午9:25:22
 * @version v.0.1
 * <p>Description: 测试domain</p>
 *
 */
public class User {
	private int id;
	private Date birthday;
	private String username;
	
	
	
	public User() {
		super();
	}
	public User(int id, Date birthday, String username) {
		super();
		this.id = id;
		this.birthday = birthday;
		this.username = username;
	}
	public User(String username, Date birthday) {
		super();
		this.birthday = birthday;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
}
