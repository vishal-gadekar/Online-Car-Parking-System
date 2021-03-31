package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.SecurityStaff;

@Repository
public interface SecurityStaffRepository extends JpaRepository<SecurityStaff, Integer> {
		
		
		SecurityStaff findByEmailAndPassword(String email,String password);
		
		List<SecurityStaff> findAll();

}
