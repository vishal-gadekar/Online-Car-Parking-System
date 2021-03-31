package com.app.services;

import java.util.List;

import com.app.pojos.SecurityStaff;

public interface ISecurityStaffService {
	
	
	SecurityStaff registerStaff(SecurityStaff s);
	SecurityStaff findByEmailAndPassword(String email,String password);
	List<SecurityStaff> findAll();

}
