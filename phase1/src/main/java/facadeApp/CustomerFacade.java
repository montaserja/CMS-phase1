package facadeApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import constants.DBConstants;
import model.db.Category;
import model.db.Coupon;
import model.db.Customer;

public class CustomerFacade extends ClientFacade {

	private int customerID;
	
	public CustomerFacade() {
		super();
		//this.customerID = customerID;
	}

	@Override
	public boolean login(String email, String password) {
		if(customersDao.isCustomerExists(email, password) == true) {
			Customer c = customersDao.getCustomerByEmail(email);
			this.customerID = c.getId();
			System.out.println("customer " + this.customerID + " logged in");
			return true;
		}
		return false;
	}
	
	private boolean dateIsAfterThanToday(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = sdf.parse(date);
			if(date1.compareTo(new Date()) < 0 ) {
				return false;
			}else
				return true;
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
	
	public void purchaseCoupon(Coupon coupon) {
		if(couponsDao.canCouponPurchaseExist(this.customerID,coupon.getId())) {
			if(coupon.getAmount() > 0 && !dateIsAfterThanToday(coupon.getStartDate()) && dateIsAfterThanToday(coupon.getEndDate())) {
					couponsDao.addCouponPurchase(this.customerID, coupon.getId());
					coupon.setAmount(coupon.getAmount()-1);
					//System.out.println("coupon amount " + coupon.getAmount());
					couponsDao.updateCoupon(coupon);
			}
		}else {
			System.out.println("Customer " +this.customerID+ " already have the coupon " + coupon.getId());
		}
	}

	public ArrayList<Coupon> getCustomerCoupons() {
		
		return couponsDao.getAllCoupons(DBConstants.Customer, this.customerID);
	}

	public ArrayList<Coupon> getCustomerCoupons(Category category) {
		ArrayList<Coupon> coupons =  getCustomerCoupons();
		if(coupons == null)
			return null;
		ArrayList<Coupon> resultCoupons = new ArrayList<Coupon>() ;
		
		//System.out.println(coupons);
		
		for (Coupon coupon : coupons) {
			if(coupon != null && coupon.getCategoryID() == category.ordinal() + 1)
				resultCoupons.add(coupon);
		}
		return resultCoupons;
	}

	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {
		ArrayList<Coupon> coupons =  getCustomerCoupons();
		if(coupons == null)
			return null;
		ArrayList<Coupon> resultCoupons = new ArrayList<Coupon>() ;
		for (Coupon coupon : coupons) {
			if(coupon != null && coupon.getPrice() < maxPrice)
				resultCoupons.add(coupon);
		}
		return resultCoupons;
	}

	public Customer getCustomerDetails() {
		return customersDao.getOneCustomer(this.customerID);
	}

}
