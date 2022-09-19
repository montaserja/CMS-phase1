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
			System.out.println("can't add the coupon");
			return;
		}
		couponsDao.addCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		if(coupon.getCompanyID() != this.companyID) {
			System.out.println("can not update company ID");
			return;
		}
		
		Coupon c = couponsDao.getCouponByNameAndComId(coupon.getTitle(), this.companyID);
		
		if(c != null && coupon.getId() == c.getId()) {
			couponsDao.updateCoupon(coupon);
		}else {
			System.out.println("name of coupon already exist!!");
		}
		
	}

	public void deleteCoupon(int couponID) {
		couponsDao.deleteCouponPurchase(-1, couponID);
		couponsDao.deleteCoupon(couponID);
	}

	public ArrayList<Coupon> getCompanyCoupons() {
		return couponsDao.getAllCoupons(DBConstants.Company,this.companyID);
	}

	public ArrayList<Coupon> getCompanyCoupons(Category category) {
		ArrayList<Coupon> coupons =  getCompanyCoupons();
		if(coupons == null)
			return null;
		ArrayList<Coupon> resultCoupons = new ArrayList<Coupon>() ;
		for (Coupon coupon : coupons) {
			if(coupon != null && coupon.getCategoryID() == category.ordinal() + 1)
				resultCoupons.add(coupon);
		}
		return resultCoupons;
	}

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {
		return couponsDao.getAllCoupons(maxPrice,this.companyID);
	}

	public Company getCompanyDetails() {
		Company company = companiesDao.getOneCompany(this.companyID);
		if(company == null) {
			System.out.println("No such company for id : "+this.companyID +" !!");
			return null;
		}
		company.setCoupons(couponsDao.getAllCoupons(DBConstants.Company,this.companyID));
		return company;
	}

}
