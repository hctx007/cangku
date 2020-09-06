package org.ck.model;

import java.util.Date;


public class inout {

	String id;//流水id
	int gysId;//供应商id
	int cpId;//产品id
	int xckId;//小仓库id
	double size;//产品实际占地容量
	int cpNumber;//产品数量
	double price;//产品存储总价格
	Date inTime;//入库时间
	Date outTime;//出库时间
	int storageTime;//存储时间
	int state;//入库状态  0为未入库  1为已入库 2为已出库
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGysId() {
		return gysId;
	}
	public void setGysId(int gysId) {
		this.gysId = gysId;
	}
	public int getCpId() {
		return cpId;
	}
	public void setCpId(int cpId) {
		this.cpId = cpId;
	}
	public int getXckId() {
		return xckId;
	}
	public void setXckId(int xckId) {
		this.xckId = xckId;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public int getCpNumber() {
		return cpNumber;
	}
	public void setCpNumber(int cpNumber) {
		this.cpNumber = cpNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	public int getStorageTime() {
		return storageTime;
	}
	public void setStorageTime(int storageTime) {
		this.storageTime = storageTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "inout [id=" + id + ", gysId=" + gysId + ", cpId=" + cpId
				+ ", xckId=" + xckId + ", size=" + size + ", cpNumber="
				+ cpNumber + ", price=" + price + ", inTime=" + inTime
				+ ", outTime=" + outTime + ", storageTime=" + storageTime
				+ ", state=" + state + "]";
	}
	
	
}
