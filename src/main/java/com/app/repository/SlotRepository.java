package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.pojos.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Integer> {

	@Query("select s from Slot s where s.place.placeId = ?1")
	List<Slot> findByPlaceIs(int pId);
	
	@Query("select s from Slot s where s.place.placeId = ?1 and s.vehicleNo = ?2")
	List<Slot> showVacantSlots(int pId, String vehicleNo);
	
	
	

}
