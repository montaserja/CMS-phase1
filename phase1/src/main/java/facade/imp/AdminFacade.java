package facade.imp;

import java.util.ArrayList;

import model.db.Company;
import model.db.Customer;

public class AdminFacade extends ClientFacade {

	@Override
	public boolean login(String email, String password) {

		if (email.equals("admin@admin.com") && password.equals("admin"))
			return true;

		return false;
	}

	public void addCompany(Company company) {
		

	}

	public void updateCompany(Company company) {
		// TODO Auto-generated method stub

	}

	public void deleteCompany(int companyID) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	public Company getOneCompany(int companyID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void deleteCustomer(int customerID) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
