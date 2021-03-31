package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exc.ResourceNotFoundException;
import com.app.pojos.Slot;
import com.app.repository.SlotRepository;

@Service
@Transactional
public class SlotServiceImpl implements ISlotService {
	

	@Autowired
	SlotRepository slotRepo;

	@Override
	public List<Slot> allSlot() {
		return slotRepo.findAll(); 
	}
	
	@Override
	public List<Slot> showVacantSlots(int pId, String vehicleNo) {
		return slotRepo.showVacantSlots(pId,vehicleNo);
	}
	
	@Override
	public List<Slot> slotsByPlace(int pId){
		return slotRepo.findByPlaceIs(pId);
	}

	@Override
	public Slot getSlotDetails(int slotId) {
		Slot s = slotRepo.findById(slotId).orElseThrow(() -> new ResourceNotFoundException("Invalid Slot Id"));
		return s;
	}

	@Override
	public String deleteSlot(int slotId) {
		Slot s = slotRepo.findById(slotId).orElseThrow(() -> new ResourceNotFoundException("Invalid Slot Id"));
		slotRepo.delete(s);
		return "Slot details for ID " + slotId + " deleted...";
	}

	@Override
	public Slot addSlot(Slot s) {
		
		slotRepo.save(s);
		return s;
	}

	@Override
	public String bookSlot(int slotId, String vehicleNo) {
		Slot s = slotRepo.findById(slotId).orElseThrow(() -> new ResourceNotFoundException("Invalid Slot Id"));
		s.setVehicleNo(vehicleNo);
		return +slotId + " Booked.....";
	}

	@Override
	public String cancleSlot(int slotId) {
		Slot s = slotRepo.findById(slotId).orElseThrow(() -> new ResourceNotFoundException("Invalid Slot Id"));
		s.setVehicleNo("0");
		return +slotId + " Car exited from Parking";
	}
	
	

}
