package org.fage.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Caizhf
 * @date 2017年5月6日下午10:41:52
 * @version v.0.1
 * <p>Description: 用户表，User与Order是一对多</p>
 *
 */
public class User implements Serializable{
	private int id;
	private String username;
	private Date birthday;
	private List<Orders> ordersList;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	
}
