package org.fage.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Caizhf
 * @date 2017年5月6日下午10:43:20
 * @version v.0.1
 * <p>Description: 订单表，Order与User是一对一，但是与订单详情是一对多</p>
 *
 */
public class Orders implements Serializable{
	private int id;
	private String num;
	private Date createDate;
	private User user;
	private List<Orderdetail> orderdetailList;
	
	
	
	public List<Orderdetail> getOrderdetailList() {
		return orderdetailList;
	}
	public void setOrderdetailList(List<Orderdetail> orderdetailList) {
		this.orderdetailList = orderdetailList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
