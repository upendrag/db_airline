package edu.utdallas.db.uxg140230.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import edu.utdallas.db.uxg140230.config.ConfigCache;
import edu.utdallas.db.uxg140230.model.Flight;

public class JDBCManager {
	private Connection conn;
	
	public JDBCManager() {
		ConfigCache config = ConfigCache.getInstance();
		try {
			Class.forName(config.getJDBCDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {			
			conn = DriverManager.getConnection(config.getDatabaseURL(), 
					config.getDatabaseUsername(), config.getDatabasePassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAllAirportCodes() {
		try {
			ArrayList<String> codes = new ArrayList<String>();
			Statement stmt = conn.createStatement();
			String sql = String.format("SELECT Airport_code FROM AIRPORT");
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {				
				codes.add(rs.getString("Airport_code"));
			}
			return codes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Flight> getFlights(String deptCode, String arrCode) {
		try {
			ArrayList<Flight> flights = new ArrayList<Flight>();
			Statement stmt = conn.createStatement();
			String sql = String.format("select DISTINCT FLIGHT.Flight_number, Weekdays "
					+ "FROM FLIGHT JOIN FLIGHT_LEG ON FLIGHT.Flight_number=FLIGHT_LEG.Flight_number  "
					+ "WHERE Departure_airport_code='%s' OR Arrival_airport_code='%s'", deptCode, arrCode);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Flight flight = new Flight();
				flight.setFlightNumber(rs.getString("Flight_number"));
				flight.setWeekdays(rs.getByte("Weekdays"));
				flights.add(flight);
			}
			return flights;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
