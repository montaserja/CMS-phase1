package facade.imp;

import java.util.ArrayList;

import model.db.Category;
import model.db.Coupon;
import model.db.Customer;

public class CustomerFacade extends ClientFacade implements facade.infc.ICustomerFacade {

	private int customerID;
	
	public CustomerFacade(int customerID) {
		super();
		this.customerID = customerID;
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public void purchaseCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Coupon> getCustomerCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Coupon> getCustomerCoupons(Category catagory) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getCustomerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
