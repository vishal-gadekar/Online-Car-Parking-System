package com.app.pojos;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
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
	
	@Column(length = 10, nullable = false)
	@NotEmpty
	@NotBlank(message="Please enter your vehicle number")
	private String vehicleNo;
	
	@OneToMany(mappedBy = "customer")
	private List<Invoice> invoice;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String email, String password, String phoneNo,
			String vehicleNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.vehicleNo = vehicleNo;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public List<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", phoneNo=" + phoneNo + ", vehicleNo=" + vehicleNo + "]";
	}

}
