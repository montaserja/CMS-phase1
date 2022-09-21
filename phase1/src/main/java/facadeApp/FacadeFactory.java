package facadeApp;

import logInManager.ClientType;

public class FacadeFactory {

	public static ClientFacade create(ClientType clientType) {
		ClientFacade client = null;
		if (clientType == ClientType.Administrator) {
			client = new AdminFacade();
		} else if (clientType == ClientType.Company) {
			client = new CompanyFacade();
		} else if (clientType == ClientType.Customer) {
			client = new CustomerFacade();
		}

		return client;

	}

}
