package facadeApp;

import dao.CompaniesDAO;
import dao.CompaniesDBDAO;
import dao.CouponsDAO;
import dao.CouponsDBDAO;
import dao.CustomersDAO;
import dao.CustomersDBDAO;

public abstract class ClientFacade {
	protected CompaniesDAO companiesDao;
	protected CustomersDAO customersDao;
	protected CouponsDAO couponsDao;
	
	public ClientFacade() {
		companiesDao = new CompaniesDBDAO();
		customersDao = new CustomersDBDAO();
		couponsDao = new CouponsDBDAO();
	}
	
	public abstract boolean login(String email,String password);
}
