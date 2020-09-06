package org.ck.model;

public class cp {
  
	int cpId;//产品id
	int gysId;//供应商id
	String cpName;//产品名称
	double price;//产品存储价格/天
	double size;//产品大小
	double cpHeight;//产品高度
	int stackable;//产品是否可堆叠
	public int getCpId() {
		return cpId;
	}
	public void setCpId(int cpId) {
		this.cpId = cpId;
	}
	public int getGysId() {
		return gysId;
	}
	public void setGysId(int gysId) {
		this.gysId = gysId;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getCpHeight() {
		return cpHeight;
	}
	public void setCpHeight(double cpHeight) {
		this.cpHeight = cpHeight;
	}
	public int getStackable() {
		return stackable;
	}
	public void setStackable(int stackable) {
		this.stackable = stackable;
	}
	@Override
	public String toString() {
		return "cp [cpId=" + cpId + ", gysId=" + gysId + ", cpName=" + cpName
				+ ", price=" + price + ", size=" + size + ", cpHeight="
				+ cpHeight + ", stackable=" + stackable + "]";
	}
	
	
	
	
	
	
}
