package com.app.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.ParkingDetails;
import com.app.repository.ParkingDetailsRepository;

@Service
@Transactional
public class ParkingDetailsServiceImpl implements IParkingDetailsService {

	@Autowired
	ParkingDetailsRepository parkingRepo;
	
	@Override
	public ParkingDetails addDetails(ParkingDetails p) {
		
		return parkingRepo.save(p);
	}

	@Override
	public int updateExitTime(int srNo, LocalTime exitTime) {
		
		parkingRepo.updateExitTime(srNo, exitTime);
		return 1;
	}

	@Override
	public List<ParkingDetails> allDetails() {

		return parkingRepo.findAll();
	}
	
	@Override
	public List<ParkingDetails> findByDate(LocalDate date) {
		
		return parkingRepo.findAllByDate(date);
	}

	@Override
	public List<ParkingDetails> findByVehicleNoContaining(String vehicle) {
		
		return parkingRepo.findAllByVehicleNo(vehicle);
	}

	@Override
	public List<ParkingDetails> findAllBySlotId(int id) {
		
		return parkingRepo.findAllBySlotId(id);
	}

	@Override
	public List<ParkingDetails> findAllByName(String name) {
		
		return parkingRepo.findAllByName(name);
	}
	
	

}
