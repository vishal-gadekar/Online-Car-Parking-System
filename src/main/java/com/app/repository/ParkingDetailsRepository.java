package com.app.repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.pojos.ParkingDetails;

@Repository
public interface ParkingDetailsRepository extends JpaRepository<ParkingDetails, Integer> {
	
	@Modifying
	@Query("update ParkingDetails p set p.exitTime = ?2 where p.srNo = ?1")
	int updateExitTime(int srNo, LocalTime exitTime);
	
	@Query("select p from ParkingDetails p where p.date = ?1")
	List<ParkingDetails> findAllByDate(LocalDate date);
	
	@Query("select p from ParkingDetails p where p.vehicleNo like %?1%")
	List<ParkingDetails> findAllByVehicleNo(String vehicle);
	
	List<ParkingDetails> findAllBySlotId(int id);
	
	@Query("select p from ParkingDetails p where p.custFirstName like %?1% or p.custLastName like %?1%")
	List<ParkingDetails> findAllByName(String name);

		
		

}
