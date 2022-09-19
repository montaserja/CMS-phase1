package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.imp.CustomersDBDAO;
import dao.infc.CompaniesDAO;
import dao.infc.CouponsDAO;
import dao.infc.CustomersDAO;
import facade.imp.AdminFacade;
import facade.imp.ClientFacade;
import facade.imp.CompanyFacade;
import facade.imp.CustomerFacade;
import logInManagerD.ClientType;
import logInManagerD.LoginManager;
import dao.imp.CompaniesDBDAO;
import dao.imp.CouponsDBDAO;
import model.db.Category;
import model.db.Company;
import model.db.Coupon;
import model.db.Customer;

public class Runner {

	public static void main(String[] args) {
		DB.createDB();
		System.out.println();
		
		
		//checkCompanySQLs();
		//chcekCustomerSQLs();

		//checkCouponSQLs();
		
		//checkAdminFacade();
		
		//checkCompanyFacade();
		
		//checkCustomerFacade();
		
		//System.out.println(Category.Electricity.ordinal());
		
		checkloginManager();

	}
	
	private static void checkloginManager() {
		LoginManager manager = LoginManager.getInstance();
		
		//ClientFacade client = manager.login("admin@admin.com", "admin", ClientType.Administrator);
		//ClientFacade client = manager.login("ah@gmail.com", "123123", ClientType.Company);
		ClientFacade client = manager.login("ahmad@gmail.com", "123123", ClientType.Customer);
		//System.out.println(client);
		
	}
	
	private static void checkCustomerFacade() {
		System.out.println();
		System.out.println("Customer Facade");
		ClientFacade customer = new CustomerFacade();
		((CustomerFacade)customer).login("ahmad@gmail.com", "123123");
		System.out.println();
		//System.out.println(((CustomerFacade)customer).getCustomerDetails());
		
		//System.out.println(((CustomerFacade)customer).getCustomerCoupons());
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String formattedDate = myDateObj.format(myFormatObj);
		Coupon c = new Coupon(4, 2, 1, "vs", "cc", "2022-09-17","2022-09-20",32,
				9.5, "sd");
		
		//((CustomerFacade)customer).purchaseCoupon(c);
		
		//System.out.println(((CustomerFacade)customer).getCustomerCoupons(10));
		System.out.println(((CustomerFacade)customer).getCustomerCoupons(Category.Food));
		
	}
	
	private static void checkCompanyFacade() { 
		System.out.println();
		System.out.println("Company Facade");
		ClientFacade company = new CompanyFacade();
		((CompanyFacade)company).login("ah@gmail.com", "123123");
		
		//CouponsDAO couponsDAO = new CouponsDBDAO();

		//LocalDateTime myDateObj = LocalDateTime.now();
		//DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		//String formattedDate = myDateObj.format(myFormatObj);

		//Coupon c = new Coupon(3, 2, 1, "aaaa", "description", formattedDate.toString(), formattedDate.toString(), 10,
		//		9.5, "sd");
		
		//((CompanyFacade)company).addCoupon(c);
		
		//c.setCompanyID(4);
		//c.setAmount(1);
		//((CompanyFacade)company).updateCoupon(c);
		
		System.out.println(((CompanyFacade)company).getCompanyCoupons());
		//System.out.println(((CompanyFacade)company).getCompanyCoupons(9.5));
		
		
	}
	
	
	private static void checkAdminFacade() {
		ClientFacade admin = new AdminFacade();
		System.out.println("LogIn : " + admin.login("admin@admin.com" , "admin"));
		System.out.println();
		ArrayList<Coupon> coupons = null;
		Company c = new Company(1,"Sabbah", "ahm@gmail.com", "123123", coupons);
		((AdminFacade)admin).addCompany(c);
		System.out.println();
		Company c1 = new Company(2,"Montaser", "montaser@gmail.com", "123123", coupons);
		((AdminFacade)admin).addCompany(c1);	
		System.out.println();
		//c.setEmail("asd@ds.com");
		//((AdminFacade)admin).updateCompany(c);
		
		//admin.deleteCompany(1);

		Customer customer = new Customer(1, "Ahmad", "Sabbah", "ahmad@gmail.com", "123123", coupons);
		((AdminFacade)admin).addCustomer(customer);
		
		Customer customer1 = new Customer(2, "Montaser", "Jafrah", "mo@gmail.com", "123123", coupons);
		((AdminFacade)admin).addCustomer(customer);
		((AdminFacade)admin).addCustomer(customer1);
		
		System.out.println();
		System.out.println();
		((AdminFacade)admin).deleteCompany(1);
		//((AdminFacade)admin).deleteCustomer(1);
		
		
	}

	private static void checkCouponSQLs() {
		CouponsDAO couponsDAO = new CouponsDBDAO();

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String formattedDate = myDateObj.format(myFormatObj);

		Coupon c = new Coupon(1, 1, 1, "title", "description", formattedDate.toString(), formattedDate.toString(), 10,
				9.5, "sd");
		couponsDAO.addCoupon(c);
		System.out.println();
//		couponsDAO.updateCoupon(c);
//		couponsDAO.deleteCoupon(1);
//		couponsDAO.getAllCoupons();
//		couponsDAO.getOneCoupon(2);

		couponsDAO.addCouponPurchase(1, c.getId());
		System.out.println();

		couponsDAO.deleteCouponPurchase(1, 1);
		System.out.println();

	}

	private static void checkCompanySQLs() {
		CompaniesDAO companiesDAO = new CompaniesDBDAO();
		ArrayList<Coupon> coupons = null;
		Company c = new Company(1, "Sabbah", "ah@gmail.com", "123123", coupons);
		
		//System.out.println(companiesDAO.isCompanyExists("ahmad@gmail.com","13123"));
		companiesDAO.addCompany(c);
//		
//		comp)aniesDAO.deleteCompany(1);
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
		Customer c = new Customer(2, "Ahmad", "Sabbah", "ahmad@gmail.com", "123123", coupons);
		//System.out.println(customerDAO.isCustomerExists(c.getEmail(), c.getPassword()));
//		Customer c2 = new Customer(11,"Ahmad","Sabbah","ahmad@gmail.com","123123",coupons);

		customerDAO.addCustomer(c);
		System.out.println();
//		customerDAO.deleteCustomer(2);
//		System.out.println();
//
//		customerDAO.updateCustomer(c2);
//		System.out.println();
//	
//		customerDAO.getAllCustomers();
//		System.out.println();

//		customerDAO.getOneCustomer(2);

	}
}
