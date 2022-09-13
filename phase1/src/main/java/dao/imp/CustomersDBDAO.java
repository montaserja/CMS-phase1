package dao.imp;

import java.util.ArrayList;

import constants.DBConstants;
import dao.infc.CustomersDAO;
import model.db.Customer;
import sqlQuery.CustomerQuery;
import sqlQuery.QueryFactory;

public class CustomersDBDAO implements CustomersDAO {
	// private ConnectionPool connectionPool;

	public Boolean isCustomerExists(String email, String password) {
//		String sql =  CustomerQuery.getInstance().selectOneRow(DBConstants.Customer, DBConstants.ID, 0)
		return null;
	}

	public void addCustomer(Customer customer) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer)).addCustomer(customer);
		// connection into DB
		// execute query
		// check if happened roll up - handle exception

	}

	public void updateCustomer(Customer customer) {
//		UPDATE table_name
//		SET column1 = value1, column2 = value2, ...
//		WHERE condition;
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer)).updateCustomer(customer);
		// connection into DB
		// execute query
		// check if happened roll up - handle exception

	}

	public void deleteCustomer(int customerID) {
//		DELETE FROM table_name WHERE condition;
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer)).deleteRow(DBConstants.Customer,
				customerID);

		// connection into DB
		// execute query
		// check if happened roll up - handle exception

	}

	public ArrayList<Customer> getAllCompanies() {
		// connection into DB

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer))
				.selectAllData(DBConstants.Customer);

		// execute query and get table of Company and save it in ResultSet
		// pass on ResultSet and convert it to Array of Customer

		return null;
	}

	public Customer getOneCustomer(int customerID) {
		// connection into DB

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.Customer))
				.selectOneRow(DBConstants.Customer, DBConstants.ID, customerID);
		// execute query and get table of Company and save it in ResultSet

		// pass on ResultSet and convert it to Array of Customer
		return null;
	}

}
