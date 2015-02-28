package edu.utdallas.db.uxg140230.controller;

import java.util.ArrayList;

import edu.utdallas.db.uxg140230.jdbc.JDBCManager;
import edu.utdallas.db.uxg140230.model.Flight;

public class DataManager {
	JDBCManager jdbcManager;
	
	public DataManager() {
		jdbcManager = new JDBCManager();
	}

	public ArrayList<String> getAllAirportCodes() {
		return jdbcManager.getAllAirportCodes();		
	}

	public ArrayList<Flight> getFlights(String deptCode, String arrCode) {
		return jdbcManager.getFlights(deptCode, arrCode);
	}
}
