package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
		
		//Admin login
		Admin findByEmailAndPassword(String email,String password);

}
