package org.fage.domain;

import java.io.Serializable;

/**
 * 
 * @author Caizhf
 * @date 2017年5月7日上午11:21:36
 * @version v.0.1
 * <p>Description: 订单明细表</p>
 *
 */
public class Orderdetail implements Serializable{
	private int id;
	private Items items;
	private String discription;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
}
