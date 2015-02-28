package edu.utdallas.db.uxg140230.model;

public class Leg {
	private int legNumber;
	private String deptAirportCode;
	private String schedDeptTime;
	private String arrAirportCode;
	private String schedArrTime;
	
	public int getLegNumber() {
		return legNumber;
	}
	public void setLegNumber(int legNumber) {
		this.legNumber = legNumber;
	}
	public String getDeptAirportCode() {
		return deptAirportCode;
	}
	public void setDeptAirportCode(String deptAirportCode) {
		this.deptAirportCode = deptAirportCode;
	}
	public String getSchedDeptTime() {
		return schedDeptTime;
	}
	public void setSchedDeptTime(String schedDeptTime) {
		this.schedDeptTime = schedDeptTime;
	}
	public String getArrAirportCode() {
		return arrAirportCode;
	}
	public void setArrAirportCode(String arrAirportCode) {
		this.arrAirportCode = arrAirportCode;
	}
	public String getSchedArrTime() {
		return schedArrTime;
	}
	public void setSchedArrTime(String schedArrTime) {
		this.schedArrTime = schedArrTime;
	}
	
}
