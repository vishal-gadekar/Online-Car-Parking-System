package com.app.pojos;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "places")
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer placeId;
	
	@Column(length = 20)
	@NotBlank(message = "Place Name Cant't be Blank")
	private String name;
	
	@Column(length = 50)
	@NotBlank(message = "Address Cant't be Blank")
	private String address;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="admin_id", nullable = false)
	private Admin admin;
	
	@OneToMany(mappedBy = "place")
	private List<Slot> slotList;
	
	public Place() {
		// TODO Auto-generated constructor stub
	}

	public Place(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Slot> getSlotList() {
		return slotList;
	}

	public void setSlotList(List<Slot> slotList) {
		this.slotList = slotList;
	}

	@Override
	public String toString() {
		return "Place [placeId=" + placeId + ", name=" + name + ", address=" + address + "]";
	}
	
	
	

}
