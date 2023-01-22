package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
	public boolean findByEmailAndPassword(String email,String pssword);
	
}
