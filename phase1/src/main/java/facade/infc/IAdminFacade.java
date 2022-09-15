package facade.infc;

import java.util.ArrayList;

import model.db.Company;
import model.db.Customer;

public interface IAdminFacade {
	
	public void addCompany(Company company);
	
	public void updateCompany(Company company);
	
	public void deleteCompany(int companyID);
	
	public ArrayList<Company> getAllCompanies();
	
	public Company getOneCompany(int companyID);
	
	public void addCustomer(Customer customer);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerID);
	
	public ArrayList<Customer> getAllCustomers();
	
}
