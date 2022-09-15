package facade.imp;

import java.util.ArrayList;

import model.db.Category;
import model.db.Company;
import model.db.Coupon;

public class CompanyFacade extends ClientFacade implements facade.infc.ICompanyFacade {
	
	private int companyID;
	
	public CompanyFacade(int companyID) {
		super();
		this.companyID = companyID;
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
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
