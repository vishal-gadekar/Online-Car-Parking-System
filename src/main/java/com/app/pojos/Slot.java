package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "slots")
public class Slot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer slotId;
	
	@NotBlank(message = "Enter Place Status")
	@Column(length = 10)
	private String vehicleNo= "0";
	
	@ManyToOne
	@JoinColumn(name="place_id", nullable = false)
	private Place place;
	
	public Slot() {
		// TODO Auto-generated constructor stub
	}


	public Slot(@NotBlank(message = "Enter Place Status") String vehicleNo, Place place) {
		super();
		this.vehicleNo = vehicleNo;
		this.place = place;
	}



	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}


	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	@Override
	public String toString() {
		return "Slot [slotId=" + slotId + ", vehicleNo=" + vehicleNo + ", place=" + place +  "]";
	}	

}
