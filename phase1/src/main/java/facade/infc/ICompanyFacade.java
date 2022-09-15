package facade.infc;

import java.util.ArrayList;

import model.db.Category;
import model.db.Company;
import model.db.Coupon;

public interface ICompanyFacade {

	public void addCoupon(Coupon coupon);
	
	public void updateCoupon(Coupon coupon);
	
	public void deleteCoupon(int couponID);
	
	public ArrayList<Coupon> getCompanyCoupons();
	
	public ArrayList<Coupon> getCompanyCoupons(Category category);
	
	public ArrayList<Coupon> getCompanyCoupons(double maxPrice);
	
	public Company getCompanyDetails();
	
	
}
