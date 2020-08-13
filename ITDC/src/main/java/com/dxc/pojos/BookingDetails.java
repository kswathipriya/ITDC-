package com.dxc.pojos;

import java.util.Date;

public class BookingDetails {

	private String cphno;
	private String hphno;
	private String hname;
	private int wrooms;
	private int days;
	private String fdate;
	private String edate;
	private double trent;
	
	public BookingDetails() {
	}

	public String getCphno() {
		return cphno;
	}

	public void setCphno(String cphno) {
		this.cphno = cphno;
	}
	
	public String getHphno() {
		return hphno;
	}

	public void setHphno(String hphno) {
		this.hphno = hphno;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public int getWrooms() {
		return wrooms;
	}

	public void setWrooms(int wrooms) {
		this.wrooms = wrooms;
	}
	

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public double getTrent() {
		return trent;
	}

	public void setTrent(double trent) {
		this.trent = trent;
	}
	
}
