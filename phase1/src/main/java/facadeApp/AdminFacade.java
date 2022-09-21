package facadeApp;

import java.util.ArrayList;

import constants.DBConstants;
import constants.DataDemo;
import model.db.Company;
import model.db.Coupon;
import model.db.Customer;

public class AdminFacade extends ClientFacade {

	@Override
	public boolean login(String email, String password) {
		
		if (email.equals(DataDemo.EMAIL_ADMIN) && password.equals(DataDemo.PASS)) {
			System.out.println("admin logged in...");
			return true;
		}

		return false;
	}

	public void addCompany(Company company) {
		if(companiesDao.getCompanyBystr(company.getName() , DBConstants.NAME) != null) {
			System.out.println("company name already exist!!");
			return ;
		}
		if(companiesDao.getCompanyBystr(company.getEmail() , DBConstants.EMAIL) != null) {
			System.out.println("company email already exist !!");
			return;
		}
		
		companiesDao.addCompany(company);
	}

	public void updateCompany(Company company) {
		
		Company com1  = companiesDao.getCompanyBystr(company.getName(), DBConstants.NAME);
		Company com2 = companiesDao.getOneCompany(company.getId());
		if(com1 == null || com2 == null) {
			System.out.println("no such company to update (code or name cant be updated)!!");
			return;
		}
		if(com1.getId() == com2.getId() && com2.getId() == company.getId() && com1.getName().equals(company.getName()))
			companiesDao.updateCompany(company);
		else
			System.out.println("Company name or code can not be updated!!!!");

	}

	public void deleteCompany(int companyID) {
		Company company = companiesDao.getOneCompany(companyID);
		if(company == null) {
			System.out.println("No such company to delete!!");
			return;
		}
		company.setCoupons(couponsDao.getAllCoupons(DBConstants.Company,companyID));
		if(company.getCoupons() != null) {
			for (Coupon coupon : company.getCoupons()) {
				couponsDao.deleteCouponPurchase(-1, coupon.getId());
				couponsDao.deleteCoupon(coupon.getId());
			}
		}
		
		companiesDao.deleteCompany(companyID);

	}

	public ArrayList<Company> getAllCompanies() {
		return companiesDao.getAllCompanies();
	}

	public Company getOneCompany(int companyID) {
		Company company = companiesDao.getOneCompany(companyID);
		if(company == null) {
			System.out.println("No such company for id : "+companyID +" !!");
			return null;
		}
		company.setCoupons(couponsDao.getAllCoupons(DBConstants.Company,companyID));
		return company;
	}

	public void addCustomer(Customer customer) {
		if(customersDao.getCustomerByEmail(customer.getEmail()) != null) {
			System.out.println("customer email already exist !!");
			return;
		}
		
		customersDao.addCustomer(customer);

	}

	public void updateCustomer(Customer customer) { // customer code can not be updated 
		customersDao.updateCustomer(customer);
	}

	public void deleteCustomer(int customerID) {
		
		couponsDao.deleteCouponPurchase(customerID, -1);
		
		customersDao.deleteCustomer(customerID);

	}

	public ArrayList<Customer> getAllCustomers() {
		
		return customersDao.getAllCustomers();
	}

}
