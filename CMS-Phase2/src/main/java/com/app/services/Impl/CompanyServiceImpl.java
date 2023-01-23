package com.app.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Category;
import com.app.model.Company;
import com.app.model.Coupon;
import com.app.repositories.CompanyRepository;
import com.app.repositories.CouponRepository;
import com.app.services.CompanyService;

import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private CouponRepository couponRepo;
	
//	@Autowired
//	public CompanyServiceImpl(CompanyRepository companyRepo,CouponRepository couponRepo) {
//	}
	
	@Override
	@Transactional
	public boolean isCompanyExist(String email,String password) {
		return companyRepo.findByEmailAndPassword(email, password);
	}
	
	@Override
	@Transactional
	public void addCoupon(Company company, Coupon coupon) {
	}

	@Override
	@Transactional
	public Coupon getCompanyCoupon(Company company, long couponId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Coupon> getAllCompanyCoupons(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Coupon> getAllCompanyCouponsByCategory(Company company, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Coupon> getAllCompanyCouponsByPrice(Company company, double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void updateCoupon(Company company, Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void deleteCoupon(Company company, long couponId) {
		// TODO Auto-generated method stub
		
	}
	
	
}
