package com.app.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.model.Category;
import com.app.model.Coupon;
import com.app.model.Customer;
import com.app.repositories.CouponRepository;
import com.app.repositories.CustomerRepository;
import com.app.services.CustomerService;

import jakarta.transaction.Transactional;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CouponRepository couponRepo;
	
	

	@Override
	@Transactional
	public void purchaseCoupon(Customer customer, int couponId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Coupon> getPurchasedCoupons(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Coupon> getPurchasedCouponsByCategory(Customer customer, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Coupon> getPurchasedCouponsByPrice(Customer customer, double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
