package com.app.services;

import java.util.List;

import com.app.exceptions.couponsExceptions.CouponNotExist;
import com.app.exceptions.couponsExceptions.CouponTitleDuplicate;
import com.app.model.Category;
import com.app.model.Company;
import com.app.model.Coupon;
import com.app.model.Customer;

public interface CouponService {
	
	public void createCoupon(Coupon coupon) throws CouponTitleDuplicate;
	public Coupon getCouponById(int couponId) throws CouponNotExist;
	public void updateCoupon(Coupon coupon) throws CouponNotExist,CouponTitleDuplicate;
	public void deleteCoupon(Coupon coupon) throws CouponNotExist;
	public List<Coupon> getAllCoupons();
	public List<Coupon> getAllCompanyCoupons(Company company);
	public List<Coupon> getAllCompanyCouponsByCategory(Company company , Category category);
	public List<Coupon> getAllCompanyCouponsByPrice(Company company , double price);
	public List<Coupon> getAllCustomerCoupons(Customer customer);

}
