package org.fage.domain;

import java.util.Date;
/**
 * 
 * @author Caizhf
 * @date 2017年5月7日下午12:23:50
 * @version v.0.1
 * <p>Description: 商品</p>
 *
 */
public class Items {
	private int id;
	private String itname;
	private double price;
	private Date launchTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getItname() {
		return itname;
	}
	public void setItname(String itname) {
		this.itname = itname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getLaunchTime() {
		return launchTime;
	}
	public void setLaunchTime(Date launchTime) {
		this.launchTime = launchTime;
	}

}
