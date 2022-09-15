package facade.imp;

import dao.imp.CompaniesDBDAO;
import dao.imp.CouponsDBDAO;
import dao.imp.CustomersDBDAO;
import dao.infc.CompaniesDAO;
import dao.infc.CouponsDAO;
import dao.infc.CustomersDAO;

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
