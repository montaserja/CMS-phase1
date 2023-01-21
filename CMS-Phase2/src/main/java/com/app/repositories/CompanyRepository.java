package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
