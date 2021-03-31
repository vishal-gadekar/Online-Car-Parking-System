package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.SecurityStaff;
import com.app.repository.SecurityStaffRepository;

@Service
@Transactional
public class SecurityStaffServiceImpl implements ISecurityStaffService {
	
	@Autowired
	SecurityStaffRepository securityRepo;

	@Override
	public SecurityStaff registerStaff(SecurityStaff s) {
		
		return securityRepo.save(s);
	}

	@Override
	public SecurityStaff findByEmailAndPassword(String email, String password) {
		
		return securityRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<SecurityStaff> findAll() {

		return securityRepo.findAll();
	}
	
	
	
	

}
