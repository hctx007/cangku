package org.ck.model;

public class yg {

	int ygId;//员工id
	String ygName;//员工姓名
	String ygSex;//员工性别
	int ygAge;//员工年龄
	public int getYgId() {
		return ygId;
	}
	public void setYgId(int ygId) {
		this.ygId = ygId;
	}
	public String getYgName() {
		return ygName;
	}
	public void setYgName(String ygName) {
		this.ygName = ygName;
	}
	public String getYgSex() {
		return ygSex;
	}
	public void setYgSex(String ygSex) {
		this.ygSex = ygSex;
	}
	public int getYgAge() {
		return ygAge;
	}
	public void setYgAge(int ygAge) {
		this.ygAge = ygAge;
	}
	@Override
	public String toString() {
		return "yg [ygId=" + ygId + ", ygName=" + ygName + ", ygSex=" + ygSex
				+ ", ygAge=" + ygAge + "]";
	}
	
}
