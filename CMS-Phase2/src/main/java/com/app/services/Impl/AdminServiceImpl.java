package com.app.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Company;
import com.app.model.Coupon;
import com.app.model.Customer;
import com.app.repositories.CompanyRepository;
import com.app.repositories.CouponRepository;
import com.app.repositories.CustomerRepository;
import com.app.services.AdminService;

import jakarta.transaction.Transactional;

public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private CustomerRepository customerRepo;


	@Transactional
	public void addCompany(Company company) {
		companyRepo.save(company);
	}
	
	@Override
	@Transactional
	public void updateCompany(Company company) {
		Optional<Company> companyToUpdate = companyRepo.findById(company.getId());
		if(companyToUpdate.isPresent()) {
			companyToUpdate = Optional.ofNullable(company);
			companyRepo.save(companyToUpdate.get());
		}
	}
	
	@Override
	@Transactional
	public void deleteCompany(Company company) {
		Optional<Company> companyToDelete = companyRepo.findById(company.getId());
		if(companyToDelete.isPresent()) {
			companyRepo.delete(companyToDelete.get());
		}
		
	}
	
	@Override
	@Transactional
	public List<Company> getAllCompanies(){
		return companyRepo.findAll();
		
	}
	
	@Override
	@Transactional
	public Company getOneCompany(int companyId) {
		return companyRepo.findById(companyId).get();
	}

	@Override
	public Coupon getCouponById(int couponId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCoupon(int companyId, Coupon coupon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCoupon(int couponId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getOneCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(long customerId) {
		// TODO Auto-generated method stub

	}

}
