package com.app.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.app.pojos.ParkingDetails;

public interface IParkingDetailsService {
	
	ParkingDetails addDetails(ParkingDetails p);
	int updateExitTime(int srNo, LocalTime exitTime);
	List<ParkingDetails> allDetails();
	
	List<ParkingDetails> findByDate(LocalDate date);
	List<ParkingDetails> findByVehicleNoContaining(String vehicle);
	List<ParkingDetails> findAllBySlotId(int id);
	List<ParkingDetails> findAllByName(String name);
}
