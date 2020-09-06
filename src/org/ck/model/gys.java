package org.ck.model;

public class gys {
	int gysId;//供应商id
	String gysName;//供应商名称
	String phone;//供应商电话
	
	public int getGysId() {
		return gysId;
	}
	public void setGysId(int gysId) {
		this.gysId = gysId;
	}
	public String getGysName() {
		return gysName;
	}
	public void setGysName(String gysName) {
		this.gysName = gysName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "gys [gysId=" + gysId + ", gysName=" + gysName + ", phone="
				+ phone + "]";
	}
	
	

}
