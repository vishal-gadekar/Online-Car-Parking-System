package com.app.services;

import java.util.List;
import com.app.pojos.Slot;

public interface ISlotService {
	List<Slot> allSlot();
	Slot getSlotDetails(int slotId);
	String deleteSlot(int slotId);
	Slot addSlot(Slot s);
	String bookSlot(int slotId, String vehicleNo);
	String cancleSlot(int slotId);
	List<Slot> slotsByPlace(int pId);
	
	List<Slot> showVacantSlots(int pId,String vehicleNo);

}
