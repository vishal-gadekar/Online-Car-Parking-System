package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parking_details")
public class ParkingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer srNo;
	
	@Column(length = 20)
	private LocalDate date;
	
	@Column(length = 20)
	private String custFirstName;
	
	@Column(length = 20)
	private String custLastName;
	
	@Column(length = 10)
	private String custPhoneNo;
	
	@Column(length = 10)
	private String vehicleNo;
	
	@Column(length = 10)
	private Integer slotId;
	
	@Column(length = 20)
	private LocalTime entryTime;
	
	@Column(length = 20)
	private LocalTime exitTime;
	
	public ParkingDetails() {
		// TODO Auto-generated constructor stub
	}



	public ParkingDetails(LocalDate date, String custFirstName, String custLastName, String custPhoneNo, String vehicleNo,
			Integer slotId, LocalTime entryTime) {
		super();
		this.date = date;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custPhoneNo = custPhoneNo;
		this.vehicleNo = vehicleNo;
		this.slotId = slotId;
		this.entryTime = entryTime;
	}


	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustPhoneNo() {
		return custPhoneNo;
	}

	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}

	public LocalTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalTime exitTime) {
		this.exitTime = exitTime;
	}	

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "ParkingDetails [srNo=" + srNo + ", date=" + date + ", custFirstName=" + custFirstName
				+ ", custLastName=" + custLastName + ", custPhoneNo=" + custPhoneNo + ", vehicleNo=" + vehicleNo
				+ ", slotId=" + slotId + ", entryTime=" + entryTime + ", exitTime=" + exitTime + "]";
	}
	
	



}
