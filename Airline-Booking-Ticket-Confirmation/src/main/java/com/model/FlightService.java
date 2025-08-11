package com.model;
import java.util.HashMap;
import java.util.Map;

public class FlightService {
	
	private Map<String,Integer> flightSeats=new HashMap<>();

	

	public void setFlightSeats(Map<String, Integer> flightSeats) {
		this.flightSeats = flightSeats;
	}
	
	
	//checks if seats are there are not in flight;
	
	public boolean hasAvailableSeats(String flightId) {
		Integer seats=flightSeats.get(flightId);
		return seats !=null && seats >0;
	}
	
	public void bookSeat(String flightId) {
		 Integer seats = flightSeats.get(flightId);
	        if (seats != null && seats > 0) {
	            flightSeats.put(flightId, seats - 1);
	        }
	}
	

}
