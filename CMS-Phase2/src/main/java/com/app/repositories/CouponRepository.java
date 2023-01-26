package com.app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Category;
import com.app.model.Company;
import com.app.model.Coupon;
import com.app.model.Customer;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	
	public Optional<Coupon> findByTitle(String title);
	public List<Coupon> findAllByCompany(Company company);
	public List<Coupon> findAllByCompanyAndCategory(Company company , Category category);
 	public List<Coupon> findByCompanyAndPriceLessThan(Company company , double price);
 	public List<Coupon> findAllByCustomer(Customer customer);

}
