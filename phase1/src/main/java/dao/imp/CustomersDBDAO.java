package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import app.ConnectionPool;
import app.DB;
import constants.DBConstants;
import dao.infc.CustomersDAO;
import mapper.imp.MyMapperCustomerImp;
import model.db.Customer;
import sqlQuery.CustomerQuery;
import sqlQuery.QueryFactory;

public class CustomersDBDAO implements CustomersDAO {
	private ConnectionPool connectionPool;

	public CustomersDBDAO() {
		this.connectionPool = ConnectionPool.getInstance();
	}

	public Boolean isCustomerExists(String email, String password) {
//		String sql =  CustomerQuery.getInstance().selectOneRow(DBConstants.Customer, DBConstants.ID, 0)
		return null;
	}

	public void addCustomer(Customer customer) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS)).addCustomer(customer);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, inserted a new customer into CUSTOMER table",
				"Failed, we can't insert a new customer form CUSTOMER table", true);

	}

	public void updateCustomer(Customer customer) {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS)).updateCustomer(customer);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, updated a customer into CUSTOMER table",
				"Failed, we can't update a new customer form CUSTOMER table", true);
	}

	public void deleteCustomer(int customerID) {
		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.deleteRow(DBConstants.CUSTOMERS, customerID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();
		DB.excute(sql, con, "Succssfully, deleted a customer from CUSTOMER table",
				"Failed, we can't delete a customer form CUSTOMER table", true);
	}

	public ArrayList<Customer> getAllCompanies() {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.selectAllData(DBConstants.CUSTOMERS);
		System.out.println(sql);

		Connection con = this.connectionPool.getConnection();

		ResultSet rs = DB.excute(sql, con, "Succssfully, deleted a customer from CUSTOMER table",
				"Failed, we can't get all customers form CUSTOMER table", false);

		ArrayList<Customer> customers = MyMapperCustomerImp.getInstance().convertResultSetToArrayListOfCustomer(rs);
		System.out.println(customers);
		System.out.println("Succssfully, get all customers from CUSTOMER table");
		return customers;
	}

	public Customer getOneCustomer(int customerID) {

		String sql = ((CustomerQuery) QueryFactory.createInstance(DBConstants.CUSTOMERS))
				.selectOneRow(DBConstants.CUSTOMERS, DBConstants.ID, customerID);
		System.out.println(sql);
		Connection con = this.connectionPool.getConnection();

		ResultSet rs = DB.excute(sql, con, "Succssfully, get a customer from CUSTOMER table",
				"Failed, we can't get a customer form CUSTOMER table", false);

		Customer customer = MyMapperCustomerImp.getInstance().convertResultSetToCustomer(rs);
		System.out.println(customer);
		return customer;

	}

}
