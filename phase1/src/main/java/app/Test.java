package app;

import constants.DataDemo;
import facadeApp.AdminFacade;
import facadeApp.ClientFacade;
import logInManager.ClientType;
import logInManager.LoginManager;
import model.db.Company;

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
		allAdminFacadeOperation(ClientType.Administrator);
		
		ConnectionPool.getInstance().closeAllConnections();
	}

	private static void allAdminFacadeOperation(ClientType clientType) {
		ClientFacade client = LoginManager.getInstance().login(DataDemo.EMAIL_ADMIN, DataDemo.PASS,
				ClientType.Administrator);
		AdminFacade admin = ((AdminFacade) client);
		Company company = new Company(DataDemo.COM1_NAME, DataDemo.COM1_EMAIL, DataDemo.PASS);
		admin.addCompany(company);
		company.setEmail("Li@gmail.com");
		admin.updateCompany(company);

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
