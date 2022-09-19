package dao;

import java.util.ArrayList;

import constants.DBConstants;
import model.db.Coupon;

public interface CouponsDAO {

	public void addCoupon(Coupon coupon);

	public void updateCoupon(Coupon coupon);

	public void deleteCoupon(int couponID);

	public ArrayList<Coupon> getAllCoupons();

	public Coupon getOneCoupon(int couponID);

	public void addCouponPurchase(int CustomerID, int copounID);

	public void deleteCouponPurchase(int customerID, int couponID);
	
	public Coupon getCouponByNameAndComId(String title, int CompanyID);
	
	//public ArrayList<Coupon> getAllCoupons(int CompanyID);
	public ArrayList<Coupon> getAllCoupons(DBConstants table ,int ID);
	
	public ArrayList<Coupon> getAllCoupons(double maxPrice , int CompanyID);

	public boolean canCouponPurchaseExist(int CustomerID, int copounID);

	public void deleteExpirationCoupon(String date);


}
