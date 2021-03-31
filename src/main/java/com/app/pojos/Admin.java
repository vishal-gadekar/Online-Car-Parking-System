package com.app.pojos;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "admins")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
	@Column(length = 20)
	@NotBlank(message = "First Name Cant't be Blank")
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column(length = 50, unique = true)
	@NotBlank(message = "Email can't be blank")
	@Email(message = "Invalid Email Format")
	@Length(min = 10, max = 50, message = "Invalid Email lenght")
	private String email;
	
	@Column(length = 10, nullable = false)
	@NotEmpty
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = " Password blank or invalid")
	private String password;
	
	@Column(length = 10, nullable = false)
	@NotEmpty
	@NotBlank(message="Please enter your phone number")
	@Length(min = 10, message = "Invalid Phone Number")
	private String phoneNo;
	
	@OneToMany(mappedBy = "admin")//,cascade = CascadeType.MERGE,orphanRemoval = true)
	private  List<Place> placeList;
	
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String firstName, String lastName, String email, String password, String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public List<Place> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<Place> placeList) {
		this.placeList = placeList;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNo=" + phoneNo + "]";
	}
	
	

}
