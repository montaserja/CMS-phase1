package app;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.imp.CustomersDBDAO;
import dao.infc.CompaniesDAO;
import dao.infc.CouponsDAO;
import dao.infc.CustomersDAO;

import dao.imp.CompaniesDBDAO;
import dao.imp.CouponsDBDAO;
import model.db.Company;
import model.db.Coupon;
import model.db.Customer;

public class Runner {
	
	
	public static void main(String[] args) {
			DB.createDB();
			DB.initCategoriesTable();
			
			checkCompanySQLs();
			chcekCustomerSQLs();

			checkCouponSQLs();
			


	}
	private static void checkCouponSQLs() {
		CouponsDAO couponsDAO = new CouponsDBDAO();
		
		LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	    
	    String formattedDate = myDateObj.format(myFormatObj);  
	    
		Coupon c = new Coupon(1,1,1,"title","description",formattedDate.toString() , formattedDate.toString(), 10,9.5, "sd");
		couponsDAO.addCoupon(c);
//		couponsDAO.updateCoupon(c);
//		couponsDAO.deleteCoupon(1);
//		couponsDAO.getAllCoupons();
//		couponsDAO.getOneCoupon(2);
		
		
		couponsDAO.addCouponPurchase(1, 1);
		couponsDAO.deleteCouponPurchase(1,1);
		
		
	}
	private static void checkCompanySQLs() {
		CompaniesDAO companiesDAO = new CompaniesDBDAO();
		ArrayList<Coupon> coupons = null;
		Company c = new Company(1,"Sabbah","ahmad@gmail.com","123123",coupons);
		
		companiesDAO.addCompany(c);
		System.out.println();
//		
//		companiesDAO.deleteCompany(1);
//		System.out.println();
//		
//		companiesDAO.updateCompany(c);
//		System.out.println();
		
//		companiesDAO.getOneCompany(2);
//		System.out.println();
		
//		companiesDAO.getAllCompanies();

	}
	
	private static void chcekCustomerSQLs() {
		CustomersDAO customerDAO = new CustomersDBDAO();
		ArrayList<Coupon> coupons = null;
		Customer c = new Customer(2,"Ahmad","Sabbah","ahmad@gmail.com","123123",coupons);
		
		Customer c2 = new Customer(11,"Ahmad","Sabbah","ahmad@gmail.com","123123",coupons);
		
		customerDAO.addCustomer(c);
//		System.out.println();
		
//		customerDAO.deleteCustomer(2);
//		System.out.println();
//
//		customerDAO.updateCustomer(c2);
//		System.out.println();
//	
//		customerDAO.getAllCompanies();
//		System.out.println();
		
//		customerDAO.getOneCustomer(2);
		
	}
}
