package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public boolean findByEmailAndPassword(String email,String pssword);

}
