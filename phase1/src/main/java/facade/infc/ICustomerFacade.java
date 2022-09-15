package facade.infc;

import java.util.ArrayList;

import model.db.Category;
import model.db.Coupon;
import model.db.Customer;

public interface ICustomerFacade {
	
	public void purchaseCoupon(Coupon coupon);
	
	public ArrayList<Coupon> getCustomerCoupons();
	
	public ArrayList<Coupon> getCustomerCoupons(Category catagory);
	
	public ArrayList<Coupon> getCustomerCoupons(double maxPrice);
	
	public Customer getCustomerDetails();

}
