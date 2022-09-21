package logInManager;

import facadeApp.ClientFacade;
import facadeApp.FacadeFactory;

public class LoginManager {

	private static LoginManager Instance;

	private LoginManager() {

	}

	public static LoginManager getInstance() {

		if (Instance == null)
			Instance = new LoginManager();

		return Instance;

	}

	public ClientFacade login(String email, String password, ClientType clientType) {

		ClientFacade client = FacadeFactory.create(clientType);

		if (client != null && client.login(email, password))
			return client;

		return null;
	}
}
