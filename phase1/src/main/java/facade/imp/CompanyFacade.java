package facade.imp;

import java.util.ArrayList;

import constants.DBConstants;
import model.db.Category;
import model.db.Company;
import model.db.Coupon;

public class CompanyFacade extends ClientFacade {
	
	private int companyID;
	
	public CompanyFacade() {
		super();
		//this.companyID = companyID;
	}

	@Override
	public boolean login(String email, String password) {
		if(companiesDao.isCompanyExists(email, password) == true) {
			Company c = companiesDao.getCompanyBystr(email, DBConstants.EMAIL);
			this.companyID = c.getId();
			System.out.println("company " + this.companyID + " loged in");
			return true;
		}
		return false;
	}

	public void addCoupon(Coupon coupon) {
		if(couponsDao.getCouponByNameAndComId(coupon.getTitle() , this.companyID ) != null) {
			System.out.println("coupon title for your company is already exist!!");
			return;
		}
		couponsDao.addCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	public void deleteCoupon(int couponID) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Coupon> getCompanyCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Coupon> getCompanyCoupons(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	public Company getCompanyDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
