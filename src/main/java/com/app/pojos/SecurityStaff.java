package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "security_staff")
public class SecurityStaff {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer securityId;
	
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

	public Integer getSecurityId() {
		return securityId;
	}

	public void setSecurityId(Integer securityId) {
		this.securityId = securityId;
	}
	
	
	
	

}
