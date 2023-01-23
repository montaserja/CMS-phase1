package com.app.services;

import java.util.List;

import com.app.model.Category;
import com.app.model.Company;
import com.app.model.Coupon;

public interface CompanyService {
	public boolean isCompanyExist(String email,String password) ;
	public void addCoupon(Company company, Coupon coupon) ;
	public Coupon getCompanyCoupon(Company company, long couponId);
	public List<Coupon> getAllCompanyCoupons(Company company);
	public List<Coupon> getAllCompanyCouponsByCategory(Company company, Category category);
	public List<Coupon> getAllCompanyCouponsByPrice(Company company, double price);
	public void updateCoupon(Company company, Coupon coupon);
	public void deleteCoupon(Company company, long couponId);
}
