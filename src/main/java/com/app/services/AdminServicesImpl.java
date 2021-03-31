package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojos.Admin;
import com.app.repository.AdminRepository;

@Service
@Transactional
public class AdminServicesImpl implements IAdminService {

	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin authenticateAdmin(String email, String password) {
		Admin a = adminRepo.findByEmailAndPassword(email, password);
		return a;
	}

	@Override
	public Admin registerAdmin(Admin a) {
		adminRepo.save(a);
		return a;
	}

}
