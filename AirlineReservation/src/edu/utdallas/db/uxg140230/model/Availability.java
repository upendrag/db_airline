package edu.utdallas.db.uxg140230.model;

public class Availability {
	private int leg;
	private String deptAirport;
	private String arrAirport;
	private int numOfAvailableSeats;
	
	public int getLeg() {
		return leg;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public String getDeptAirport() {
		return deptAirport;
	}
	public void setDeptAirport(String deptAirport) {
		this.deptAirport = deptAirport;
	}
	public String getArrAirport() {
		return arrAirport;
	}
	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}
	public int getNumOfAvailableSeats() {
		return numOfAvailableSeats;
	}
	public void setNumOfAvailableSeats(int numOfAvailableSeats) {
		this.numOfAvailableSeats = numOfAvailableSeats;
	}
}
