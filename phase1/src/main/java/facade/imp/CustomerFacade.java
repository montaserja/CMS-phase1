package facade.imp;

import java.util.ArrayList;

import constants.DBConstants;
import model.db.Category;
import model.db.Company;
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

	public void purchaseCoupon(Coupon coupon) {
		
	}

	public ArrayList<Coupon> getCustomerCoupons() {
		
		return couponsDao.getAllCoupons(DBConstants.Customer, this.customerID);
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
		return customersDao.getOneCustomer(this.customerID);
	}

}
