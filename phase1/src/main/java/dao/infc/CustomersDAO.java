package dao.infc;

import java.util.ArrayList;

import model.db.Customer;

public interface CustomersDAO {
	public Boolean isCustomerExists(String email, String password);

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(int customerID);

	public ArrayList<Customer> getAllCustomers();

	public Customer getOneCustomer(int customerID);
	
	public Customer getCustomerByEmail(String email);
}
