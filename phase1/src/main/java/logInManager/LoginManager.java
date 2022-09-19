package logInManager;


import facadeApp.AdminFacade;
import facadeApp.ClientFacade;
import facadeApp.CompanyFacade;
import facadeApp.CustomerFacade;

public class LoginManager {
	
	private static LoginManager Instance = null;
	
	private LoginManager() {
		
	}
	
	public static LoginManager getInstance() {
		
		if(Instance == null)
			Instance = new LoginManager();
		
		return Instance;
		
	}
	
	public ClientFacade login(String email , String password , ClientType clientType) {
		ClientFacade client = null;
		if(clientType == ClientType.Administrator) {
			client = new AdminFacade();
		}else if(clientType == ClientType.Company) {
			client = new CompanyFacade();
		}else {
			client = new CustomerFacade();
		}
		
		if(client.login(email, password))
			return client;
		else
			return null;
	}
}
