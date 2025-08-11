package com.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DoctorRepository {
	
	private Map<String, List<LocalDate>> doctorSchedules;
	


	public void setDoctorSchedules(Map<String, List<LocalDate>> doctorSchedules) {
		this.doctorSchedules = doctorSchedules;
	}

	public boolean isAvailable(String doctorId,LocalDate date) {
		List<LocalDate> schedule =doctorSchedules.get(doctorId);
		  if (schedule == null) return false;
	        // Available if NOT yet booked (date not in schedule)
	        return !schedule.contains(date);
	}
	
	
	public void bookDate(String doctorId, LocalDate date) {
		doctorSchedules.get(doctorId).add(date);
		
	}
	

}
