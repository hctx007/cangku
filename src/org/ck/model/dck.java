package org.ck.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class dck {

	int dckId;//大仓库id
	String dckName;//大仓库名称
	String dckLocation;//大仓库地址
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	Date buildTime;//大仓库建立时间
	String dckBoss;//大仓库老板
	public int getDckId() {
		return dckId;
	}
	public void setDckId(int dckId) {
		this.dckId = dckId;
	}
	public String getDckName() {
		return dckName;
	}
	public void setDckName(String dckName) {
		this.dckName = dckName;
	}
	public String getDckLocation() {
		return dckLocation;
	}
	public void setDckLocation(String dckLocation) {
		this.dckLocation = dckLocation;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
	public String getDckBoss() {
		return dckBoss;
	}
	public void setDckBoss(String dckBoss) {
		this.dckBoss = dckBoss;
	}
	@Override
	public String toString() {
		return "dck [dckId=" + dckId + ", dckName=" + dckName
				+ ", dckLocation=" + dckLocation + ", buildTime=" + buildTime
				+ ", dckBoss=" + dckBoss + "]";
	}
	
}
