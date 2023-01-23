package com.app.services;

import java.util.List;

import com.app.model.Category;
import com.app.model.Coupon;
import com.app.model.Customer;

public interface CustomerService {
	 public void purchaseCoupon(Customer customer, int couponId);
	 public List<Coupon> getPurchasedCoupons(Customer customer);
	 public List<Coupon> getPurchasedCouponsByCategory(Customer customer, Category category);
	 public List<Coupon> getPurchasedCouponsByPrice(Customer customer, double price);
	 
	 
}
