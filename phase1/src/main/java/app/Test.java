package app;

import java.util.ArrayList;

import constants.DataDemo;
import facadeApp.AdminFacade;
import facadeApp.ClientFacade;
import facadeApp.CompanyFacade;
import facadeApp.CustomerFacade;
import logInManager.ClientType;
import logInManager.LoginManager;
import model.db.Category;
import model.db.Company;
import model.db.Coupon;
import model.db.Customer;

public class Test {
	public static void testAll() {
		try{
			// preparation the database
			DB.createDB();
			System.out.println();
	
			// A step
			DB.getInstance();
			DB.startExpiredCouponTask();
			System.out.println();
	
			// creating companies and customers
			Company[] companies = companiesGen();	
			Customer[] customers = customersGen();
			
			// B step - Login by LoginManager as Administrator
			System.out.println();
			System.out.println(TestData.line + " ADMIN SECTION " + TestData.line);
			allAdminFacadeOperation(companies , customers);
			System.out.println();
			System.out.println(TestData.line + " END OF ADMIN SECTION " + TestData.line);
			
			
			
			// C step - Login by LoginManager as Company
			System.out.println();
			System.out.println(TestData.line + " COMPANY SECTION " + TestData.line);
			allCompanyFacadeOperation(companies[2].getEmail() , companies[2].getPassword());
			System.out.println();
			System.out.println(TestData.line + " END OF COMPANY SECTION " + TestData.line);
			
			// D step - Login by LoginManager as Customer
			System.out.println();
			System.out.println(TestData.line + " CUSTOMER SECTION " + TestData.line);
			allCustomerFacadeOperation(customers[2].getEmail() , customers[2].getPassword());
			System.out.println();
			System.out.println(TestData.line + " END OF CUSTOMER SECTION " + TestData.line);
			
			
			ConnectionPool.getInstance().closeAllConnections();
			//DB.stopExpiredCouponTask();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private static void allCustomerFacadeOperation( String email , String password) {
		ClientFacade client = LoginManager.getInstance().login(email,password,
				ClientType.Customer);
		if(client == null) {
			System.out.println("customer email or password isn't correct");
			return;
		}
		CustomerFacade customer = ((CustomerFacade)client);
		
		ClientFacade admin = LoginManager.getInstance().login(DataDemo.EMAIL_ADMIN, DataDemo.PASS_ADMIN,
				ClientType.Administrator);
		
		System.out.println();
		ArrayList<Coupon> coupons = ((AdminFacade) admin).getOneCompany(3).getCoupons();
		if(coupons.size() > 0) {
			//System.out.println(coupons.get(0));
			customer.purchaseCoupon(coupons.get(0));
			customer.purchaseCoupon(coupons.get(1));
		}else {
			System.out.println("there is no coupons for the company");
		}
		System.out.println();
		System.out.println("all customer coupons : ");
		System.out.println(customer.getCustomerCoupons());
		System.out.println();
		System.out.println("all customer coupons with category food :");
		System.out.println(customer.getCustomerCoupons(Category.Food));
		System.out.println();
		System.out.println("all customer coupons at max price 12 :");
		System.out.println(customer.getCustomerCoupons(12));
		System.out.println();
		System.out.println("customer details :");
		System.out.println(customer.getCustomerDetails());
		
	}
	
	private static void allCompanyFacadeOperation( String email , String password) {
		ClientFacade client = LoginManager.getInstance().login(email,password,
				ClientType.Company);
		if(client == null) {
			System.out.println("company email or password isn't correct");
			return;
		}
		CompanyFacade company = ((CompanyFacade) client);
		
		Coupon[] coupons = CouponsGen(3);
		
		System.out.println("adding coupons to DB");
		for (Coupon coupon : coupons) {
			company.addCoupon(coupon);
			System.out.println("coupon " + coupon.getTitle() + " is in the DB");
		}
		System.out.println();
		
		System.out.println("get companies coupons from DB");
		ArrayList<Coupon> DBcoupons = company.getCompanyCoupons();
		for (Coupon coupon : DBcoupons) {
			System.out.println(coupon);
		}
		System.out.println();
		System.out.println("update Coupon " + DBcoupons.get(2).getId() + " name");
		DBcoupons.get(2).setTitle("Updated title");
		company.updateCoupon(DBcoupons.get(2));
		
		System.out.println("deleting coupon " + DBcoupons.get(2).getId());
		company.deleteCoupon(DBcoupons.get(2).getId());
		
		
	}

	private static void allAdminFacadeOperation(Company[] companies , Customer[] customers) {
		

		
		ClientFacade client = LoginManager.getInstance().login(DataDemo.EMAIL_ADMIN, DataDemo.PASS_ADMIN,
				ClientType.Administrator);
		if(client == null) {
			System.out.println("admin email or password isn't correct");
			return;
		}
		
		AdminFacade admin = ((AdminFacade) client);
	
		System.out.println();
		System.out.println("adding companies to the DB by admin : \n");
		for (Company company : companies) {
			admin.addCompany(company);
			System.out.println("company " + company.getName() + " is in the DB");
		}
		System.out.println();
		System.out.println("adding customers to the DB by admin : \n");
		for (Customer customer : customers) {
			admin.addCustomer(customer);
			System.out.println("customer " + customer.getFirstName() + " " + customer.getLastName() + " is in the DB");
		}
		
		System.out.println();
		System.out.println("get all companies from the DB ");
		ArrayList<Company> DBcompanies = admin.getAllCompanies();
		for (Company company : DBcompanies) {
			System.out.println(company);
		}
		System.out.println();
		
		System.out.println();
		System.out.println("get all customers from the DB ");
		ArrayList<Customer> DBcustomers = admin.getAllCustomers();
		for (Customer customer : DBcustomers) {
			System.out.println(customer);
		}
		System.out.println();
		
		System.out.println();
		System.out.println("company " + DBcompanies.get(0).getName() +" before updating");
		System.out.println(DBcompanies.get(0));
		DBcompanies.get(0).setEmail("ThisEmailWasUpdated@gmail.com");
		admin.updateCompany(DBcompanies.get(0));
		System.out.println("company " + DBcompanies.get(0).getName() +" after updating");
		System.out.println(DBcompanies.get(0));
		
		System.out.println();
		System.out.println("updating " +companies[0].getName()  + " id to 0");
		admin.updateCompany(companies[0]);
		System.out.println();
		System.out.println("deleting non existion company ..");
		admin.deleteCompany(0);
		System.out.println();
		System.out.println("deleting company 1");
		admin.deleteCompany(1);
		System.out.println();
		System.out.println("getting company 1 from DB after we deleted it");
		Company c = admin.getOneCompany(1);
		System.out.println();
		System.out.println("getting company 2 from DB");
		c = admin.getOneCompany(2);
		System.out.println(c);
		
		System.out.println();
		System.out.println("adding existing customer...");
		admin.addCustomer(DBcustomers.get(0));
		
		System.out.println();
		System.out.println("updating customer 1 name..");
		DBcustomers.get(0).setFirstName("updatedName");
		admin.updateCustomer(DBcustomers.get(0));
		System.out.println();
		System.out.println("deleting customer 1");
		admin.deleteCustomer(1);
		
		System.out.println();
		System.out.println("get customer 2");
		System.out.println(admin.getOneCustomer(2));
		

	}
	
	private static Company[] companiesGen() {
		System.out.println();
		Company[] companies = new Company[TestData.companiesNum];
		System.out.println("generated " + TestData.companiesNum + " companies for testing (before adding them to DB)");
		for(int i = 0 ; i< TestData.companiesNum ; ++i) {
			companies[i] = new Company(TestData.companyNames[i], TestData.companyNames[i] + "@gmail.com", TestData.password);
			System.out.println(companies[i]);
		}
		System.out.println();
		return companies;
	}
	
	private static Customer[] customersGen() {
		System.out.println();
		Customer[] customers = new Customer[TestData.customersNum];
		System.out.println("generated " + TestData.customersNum + " customers for testing (before adding them to DB)");
		for(int i = 0 ; i< TestData.companiesNum ; ++i) {
			String email = TestData.customersFirstNames[i] + TestData.customersFamilyNames[i] + "@gmail.com";
			customers[i] = new Customer(TestData.customersFirstNames[i], TestData.customersFamilyNames[i], email, TestData.password );
			System.out.println(customers[i]);
		}
		System.out.println();
		return customers;
	}
	
	private static Coupon[] CouponsGen(int companyID) {
		System.out.println();
		Coupon[] coupons = new Coupon[TestData.couponsNum];
		System.out.println("generated " + TestData.couponsNum + " coupons for testing (before adding them to DB)");
		for(int i = 0 ; i< TestData.couponsNum ; ++i) {
			coupons[i] = new Coupon(companyID, (i%4)+1 , TestData.couponsTitles[i], "description", TestData.startDates[i],
					TestData.endDates[i], TestData.amount[i], TestData.price[i], "sd");
			System.out.println(coupons[i]);
		}
		System.out.println();
		return coupons;
	}
	
	
	
	

//	private static ClientFacade checkloginManagerAs(ClientType clientType) {
//		LoginManager manager = LoginManager.getInstance();
//
//		// ClientFacade client = manager.login("admin@admin.com", "admin",
//		// ClientType.Administrator);
//		// ClientFacade client = manager.login("ah@gmail.com", "123123",
//		// ClientType.Company);
////		ClientFacade client = manager.login("ahmad@gmail.com", "123123", ClientType.Customer);
//		// System.out.println(client);
//		return manager.login("ahmad@gmail.com", "123123", clientType);
//
//	}

}
