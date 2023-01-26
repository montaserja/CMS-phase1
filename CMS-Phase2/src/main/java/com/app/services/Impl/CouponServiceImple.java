package com.app.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.exceptions.couponsExceptions.CouponNotExist;
import com.app.exceptions.couponsExceptions.CouponTitleDuplicate;
import com.app.model.Category;
import com.app.model.Company;
import com.app.model.Coupon;
import com.app.model.Customer;
import com.app.model.utilities.Validation;
import com.app.repositories.CategoryRepository;
import com.app.repositories.CouponRepository;
import com.app.services.CategoryService;
import com.app.services.CouponService;

import jakarta.transaction.Transactional;

public class CouponServiceImple implements CouponService , Validation {
	
	@Autowired
	private CouponRepository couponRepo;
	
	@Autowired
	private CategoryService categoryService;
	

	@Override
	@Transactional
	public void createCoupon(Coupon coupon) throws CouponTitleDuplicate {
		Optional<Coupon> temp = couponRepo.findByTitle(coupon.getTitle());
		if(temp.isPresent()) {
			throw new CouponTitleDuplicate("title is already exists!!");
		}
		couponRepo.save(coupon);
		
	}

	@Override
	@Transactional
	public Coupon getCouponById(int couponId) throws CouponNotExist {
		this.isCouponExists(couponId, couponRepo);
		return couponRepo.findById(couponId).get();
	}

	@Override
	@Transactional
	public void updateCoupon(Coupon coupon) throws CouponNotExist, CouponTitleDuplicate {
		Optional<Coupon> couponFromDB = couponRepo.findByTitle(coupon.getTitle());
		
		if(couponFromDB.isPresent())
			if(couponFromDB.get().getId() != coupon.getId())
				throw new CouponTitleDuplicate("title is already exist!!");
		couponRepo.save(coupon);
	}

	@Override
	@Transactional
	public void deleteCoupon(Coupon coupon) throws CouponNotExist {
		this.isCouponExists(coupon.getId(), couponRepo);
		couponRepo.delete(coupon);
	}

	@Override
	@Transactional
	public List<Coupon> getAllCoupons() {
		return couponRepo.findAll();
	}

	@Override
	@Transactional
	public List<Coupon> getAllCompanyCoupons(Company company) {
		return couponRepo.findAllByCompany(company);
	}

	@Override
	@Transactional
	public List<Coupon> getAllCompanyCouponsByCategory(Company company, Category category) {
		return couponRepo.findAllByCompanyAndCategory(company, category);
	}

	@Override
	@Transactional
	public List<Coupon> getAllCompanyCouponsByPrice(Company company, double price) {
		return couponRepo.findByCompanyAndPriceLessThan(company, price);
	}

	@Override
	@Transactional
	public List<Coupon> getAllCustomerCoupons(Customer customer) {
		// TODO Auto-generated method stub
		return couponRepo.findAllByCustomer(customer);
	}

}
