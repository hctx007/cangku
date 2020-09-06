package org.ck.model;

public class cgy {

	int cgyId;//仓管员id（账号）
	String cgyName;//仓管员姓名
	String cgySex;//仓管员性别
	int cgyAge;//仓管员年龄
	String password;//密码
	public int getCgyId() {
		return cgyId;
	}
	public void setCgyId(int cgyId) {
		this.cgyId = cgyId;
	}
	public String getCgyName() {
		return cgyName;
	}
	public void setCgyName(String cgyName) {
		this.cgyName = cgyName;
	}
	public String getCgySex() {
		return cgySex;
	}
	public void setCgySex(String cgySex) {
		this.cgySex = cgySex;
	}
	public int getCgyAge() {
		return cgyAge;
	}
	public void setCgyAge(int cgyAge) {
		this.cgyAge = cgyAge;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "cgy [cgyId=" + cgyId + ", cgyName=" + cgyName + ", cgySex="
				+ cgySex + ", cgyAge=" + cgyAge + ", password=" + password
				+ "]";
	}
	
}
