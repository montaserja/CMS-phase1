package app;

import java.util.ArrayList;

import constants.DataDemo;
import facadeApp.AdminFacade;
import facadeApp.ClientFacade;
import logInManager.ClientType;
import logInManager.LoginManager;
import model.db.Company;
import model.db.Customer;

public class Test {
	public static void testAll() {
		// preparation the database
		DB.createDB();
		System.out.println();

		// A step
		DB.getInstance();
		DB.startExpiredCouponTask();
		System.out.println();

		// B step - Login by LoginManager as Administrator
		System.out.println();
		System.out.println(TestData.line + " ADMIN SECTION " + TestData.line);
		allAdminFacadeOperation(ClientType.Administrator);
		System.out.println(TestData.line + " END OF ADMIN SECTION " + TestData.line);
		
		ConnectionPool.getInstance().closeAllConnections();
		
	}

	private static void allAdminFacadeOperation(ClientType clientType) {
		
		Company[] companies = companiesGen();	
		Customer[] customers = customersGen();
		
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
